package com.naveensundarg.shadow.prover.sandboxes;

import com.naveensundarg.shadow.prover.core.SnarkWrapperCustom;
import com.naveensundarg.shadow.prover.core.proof.Justification;
import com.naveensundarg.shadow.prover.representations.formula.Formula;
import com.naveensundarg.shadow.prover.representations.value.Value;
import com.naveensundarg.shadow.prover.representations.value.Variable;
import com.naveensundarg.shadow.prover.utils.CollectionUtils;
import com.naveensundarg.shadow.prover.utils.Problem;
import com.naveensundarg.shadow.prover.utils.ProblemReader;
import com.naveensundarg.shadow.prover.utils.Reader;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by John on 2/11/2019.
 */
public class TippaeTreeSandbox {

  public void readResource(String fileLocation) throws Reader.ParsingException {

    List<Problem> tests = ProblemReader.readFrom(TippaeSandbox.class.getResourceAsStream(fileLocation));

    Problem p = tests.get(0);

    Set<Formula> assumptions = p.getAssumptions();

    Set<Formula> assumedOptionallyBranches = CollectionUtils.newEmptySet();
    Set<Formula> assumedValidityDeclarations = CollectionUtils.newEmptySet();
    Set<Formula> assumedDefinitionDeclarations = CollectionUtils.newEmptySet();

    Map<Value, Set<Value>> attemptToOptionsMap = CollectionUtils.newMap();
    Map<Value, Value> OptionToValidityMap = CollectionUtils.newMap();

    for (Formula assumption: assumptions) {

      System.out.println(assumption);

      for (Formula subAssumption : assumption.subFormulae()) {

        if(assumption != subAssumption && subAssumption.toString().indexOf("Optionally") == 1) { //The if statement that find Optionally formula
          assumedOptionallyBranches.add(subAssumption);
        }

        if(assumption != subAssumption && subAssumption.toString().indexOf("Validity") == 1 && subAssumption.toString().indexOf("Addition")==-1 && subAssumption.toString().indexOf("Multiplication")==-1) { //The if statement that find Validity formula
          assumedValidityDeclarations.add(subAssumption);
        }

        if(assumption != subAssumption && subAssumption.toString().indexOf("Define") == 1){
          assumedDefinitionDeclarations.add(subAssumption);
        }

      }

    }

    System.out.println("Optionally Formula are: ");
    for (Formula option: assumedOptionallyBranches){
      System.out.println("     " + option);
      //The command to print out the values that aren't variables
      Set<Value> attemptAndOption = option.valuesPresent().stream().filter(op -> !op.getName().startsWith("?")).collect(Collectors.toSet());
      System.out.println("          " + attemptAndOption);

      //The commands for collecting the Attempts and the associated Option
      Value att = attemptAndOption.stream().filter(part -> part.getName().endsWith("Attempt")).findFirst().get();
      System.out.println("Attempt is     " + att);
      Value op = attemptAndOption.stream().filter(part -> !part.getName().endsWith("Attempt")).findFirst().get();
      System.out.println("Option is      " + op);

      if(!attemptToOptionsMap.containsKey(att)){
        Set<Value> optionsSet = CollectionUtils.newEmptySet();
        optionsSet.add(op);
        attemptToOptionsMap.put(att, optionsSet);
      }else {
        attemptToOptionsMap.get(att).add(op);
      }
    }

    System.out.println("Validity Formula are: ");
    for (Formula validity: assumedValidityDeclarations){
      System.out.println("     " + validity);
      //The command to print out the values that aren't variables
      Set<Value> stepAndValidity = validity.valuesPresent().stream().filter(val -> !val.getName().startsWith("?")).collect(Collectors.toSet());
      System.out.println("          " + stepAndValidity);

      //The command to get the step and validity separately
      Value vali = stepAndValidity.stream().filter(val -> (val.getName().equalsIgnoreCase("Valid") || val.getName().equalsIgnoreCase("Invalid"))).findAny().get();
      Value stp = stepAndValidity.stream().filter(val -> !(val.getName().equalsIgnoreCase("Valid") || val.getName().equalsIgnoreCase("Invalid"))).findAny().get();
      System.out.println("Validity       " + vali);
      System.out.println("Step           " + stp);

      OptionToValidityMap.put(stp, vali);

    }

    System.out.println("Definition Formula are: ");
    for (Formula definition: assumedDefinitionDeclarations){
      System.out.println("     " + definition);
      String stringForm = definition.toString();
      String firstName = stringForm.substring(9, stringForm.indexOf(" ", 9));

      int clausesTraveled = 0;
      int layersInward = 0;
      int indexOfSecondName = 0;
      for (int i = 5; i < stringForm.length(); i++){
        if(stringForm.substring(i, i+1).equals("(")){
          layersInward++;
          if(clausesTraveled == 1 && layersInward == 1){
            indexOfSecondName = i+1;
          }
        }else if(stringForm.substring(i, i+1).equals(")")){
          layersInward--;
          if(layersInward == 0){
            clausesTraveled++;
          }
        }
      }
      String secondName = stringForm.substring(indexOfSecondName, stringForm.indexOf(" ", indexOfSecondName));
      System.out.println("          " + definition.valuesPresent().stream().filter(def -> def.getName().equals(firstName)).collect(Collectors.toSet()));
      System.out.println("          " + secondName);
    }

    System.out.println("\n\n" + attemptToOptionsMap);
    System.out.println("\n" + OptionToValidityMap);




    //SnarkWrapperCustom snarkProver = SnarkWrapperCustom.getInstance();
    //Optional<Pair<Justification, Set<Map<Variable, Value>>>> answer = snarkProver.proveAndGetMultipleBindings(p.getAssumptions(), p.getGoal(), p.getAnswerVariables().get());
    //System.out.println(answer.get().getRight().iterator().next().entrySet().iterator().next().getValue().getArguments()[1].getName());

  }

  public static void main(String[] args) throws Exception {

    TippaeTreeSandbox testingEnvironment = new TippaeTreeSandbox();
    testingEnvironment.readResource("../Tippae-Math-Truth.clj");

  }

}
