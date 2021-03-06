
{
:name Test-ValidityInheritance-with-2LayerChoiceList-WIP
:assumptions
  {

;; A1 and its subsections explicitly state the definition of the various types of TwoByOneMult steps
;; along with stating that it is fine to directly replace those steps with their broken down versions.

  A1   (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (=  (TwoByOneMult ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (Addition
                  (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                  (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              )
          )
       )

  A1-2 (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (= (TwoByOneMultErr1 ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (Addition
                  (MultiplicandTensDigitTimesMultiplicandOnesDigit ?MultiplicandTensDigit ?MultiplicandOnesDigit)
                  (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              )
          )
       )

  A1-3 (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (= (TwoByOneMultErr2 ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (Addition
                  (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                  (MultiplicandTensDigitTimesMultiplicandOnesDigit ?MultiplicandTensDigit ?MultiplicandOnesDigit)
              )
          )
       )

;; This is not currently being used.

  A2  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (Define
              (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (Optionally (OneByOneMultAttempt ?MultiplicandOnesDigit ?MultiplierOnesDigit) ?Choice)
          )
      )

  A3  (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (Define
              (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              (* (* ?MultiplicandTensDigit 10) ?MultiplierOnesDigit)
          )
      )

  A4  (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit)
          (Define
              (MultiplicandTensDigitTimesMultiplicandOnesDigit ?MultiplicandTensDigit ?MultiplicandOnesDigit)
              (* ?MultiplicandTensDigit ?MultiplicandOnesDigit)
          )
      )

;; A5-A8 are representing that validity of various possible steps one could take in the process of multiplying
;; a two digit number by a one digit number. They are used to both state that a specific step is valid or
;; invalid as an assertion and to state that it is fine to substitute to substitute the raw step with
;; the explicit validity statement during reasoning.

  A5  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (and
              (Validity
                  (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                  Valid
              )
              (=
                  (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                  (Validity
                      (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                      Valid
                  )
              )
          )
      )

  A6  (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (and
              (Validity
                  (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
                  Valid
              )
              (=
                  (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
                  (Validity
                      (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
                      Valid
                  )
              )
          )
      )

  A7  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (and
              (Validity
                  (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                  Valid
              )
              (=
                  (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                  (Validity
                      (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                      Valid
                  )
              )
          )
      )

  A8  (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit)
          (and
              (Validity
                  (MultiplicandTensDigitTimesMultiplicandOnesDigit ?MultiplicandTensDigit ?MultiplicandOnesDigit)
                  Invalid
              )
              (=
                  (MultiplicandTensDigitTimesMultiplicandOnesDigit ?MultiplicandTensDigit ?MultiplicandOnesDigit)
                  (Validity
                      (MultiplicandTensDigitTimesMultiplicandOnesDigit ?MultiplicandTensDigit ?MultiplicandOnesDigit)
                      Invalid
                  )
              )
          )
      )

;; A9 and it's subsections are a representation of how the validity of two part addition steps
;; is built and maintained from it's parts.

  A9  (forall (?AddedStep1 ?AddedStep2)
          (Validity
              (Addition (Validity ?AddedStep1 Valid) (Validity ?AddedStep2 Valid) )
              Valid
          )
      )

  A9-1(forall (?AddedStep1 ?AddedStep2)
          (Validity
              (Addition (Validity ?AddedStep1 Invalid) (Validity ?AddedStep2 Valid) )
              Invalid
          )
      )

  A9-2(forall (?AddedStep1 ?AddedStep2)
          (Validity
              (Addition (Validity ?AddedStep1 Valid) (Validity ?AddedStep2 Invalid) )
              Invalid
          )
      )

  A9-3(forall (?AddedStep1 ?AddedStep2)
          (Validity
              (Addition (Validity ?AddedStep1 Invalid) (Validity ?AddedStep2 Invalid) )
              Invalid
          )
      )

;; A10 and it's subsections are a representation of how the validity of two part multiplication steps
;; is built and maintained from it's parts.

  A10 (forall (?AddedStep1 ?AddedStep2)
          (Validity
              (Multiplication (Validity ?AddedStep1 Valid) (Validity ?AddedStep2 Valid) )
              Valid
          )
      )

  A10-1(forall (?AddedStep1 ?AddedStep2)
          (Validity
              (Multiplication (Validity ?AddedStep1 Invalid) (Validity ?AddedStep2 Valid) )
              Invalid
          )
      )

  A10-2(forall (?AddedStep1 ?AddedStep2)
          (Validity
              (Multiplication (Validity ?AddedStep1 Valid) (Validity ?AddedStep2 Invalid) )
              Invalid
          )
      )

  A10-3(forall (?AddedStep1 ?AddedStep2)
          (Validity
              (Multiplication (Validity ?AddedStep1 Invalid) (Validity ?AddedStep2 Invalid) )
              Invalid
          )
      )

;; A11 through A13 are representations of various attempts at multiplying two digit numbers by one digit
;; numbers. We'll call this idea an option tree.

  A11   (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (Optionally
              (TwoByOneMultAttempt ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (TwoByOneMult ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
       )

  A12   (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (Optionally
              (TwoByOneMultAttempt ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (TwoByOneMultErr1 ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
       )

  A13   (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (Optionally
              (TwoByOneMultAttempt ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (TwoByOneMultErr2 ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
       )

;; A14 through A17 are representations of various attempts at multiplying one digit numbers by one digit
;; numbers. We'll call this idea an option tree.

  A14   (forall (?MultiplierDigit ?MultiplicandDigit)
          (Optionally
              (OneByOneMultAttempt ?MultiplierDigit ?MultiplicandDigit)
              (OneByOneMult ?MultiplierDigit ?MultiplicandDigit)
          )
       )

  A15   (forall (?MultiplierDigit ?MultiplicandDigit)
          (Optionally
              (OneByOneMultAttempt ?MultiplierDigit ?MultiplicandDigit)
              (OneByOneMultErr1 ?MultiplierDigit ?MultiplicandDigit)
          )
       )

  A16   (forall (?MultiplierDigit ?MultiplicandDigit)
          (Optionally
              (OneByOneMultAttempt ?MultiplierDigit ?MultiplicandDigit)
              (OneByOneMultErr2 ?MultiplierDigit ?MultiplicandDigit)
          )
       )

  A17   (forall (?MultiplierDigit ?MultiplicandDigit)
          (Optionally
              (OneByOneMultAttempt ?MultiplierDigit ?MultiplicandDigit)
              (OneByOneMultErr3 ?MultiplierDigit ?MultiplicandDigit)
          )
       )

  A18  (forall (?Attempt ?Choice)
          (=
              (Answered (Optionally ?Attempt ?Choice) )
              ?Choice
          )
       )


  }

 :answer-variables [?x, ?valid]

 :answers-expected ( )

;; ABANDON: The notion of doing math in the snark. This is because we wouldn't have the lowest levels be unique.
;; ABANDON: The notion of using the justification in further logic. It's difficult to access in addition to not holding the direct math.
;; NOTE: The output will most likely be the lowest level of representation when I write their validity.
;; QUESTION: Can we replace the intermediate validity ratings and how can I write the rules for those.
;; NOTE: Keep in mind that all parts of the branching logic need to be unique identified to work.
;; CONSIDER: Embracing the limitations we're running into with multilevel branching.
;;      It's possible that creating a system that explicitly calls the lower levels gives up access to specifying their validity or simply assuming they are correct.
;;      Current attempt is to build a similar problem based on the results and then run it on the results.

 :goal
        (and
            (Validity ?x ?valid)
            (Optionally (TwoByOneMultAttempt 1 5 5) ?x) ;;This represents the questions being analysed and is not optional
        )

}

{:name Teleportation-test
 :assumptions
    {A1 (Perceives! human t1 (Believes! (embodies a) t1 (Holds (Prop watch stopped) t1 )))
     A2 (Perceives! human t2 (Believes! (embodies b) t2 (Holds (Prop watch stopped) t2 )))

     A3 (Believes! human t3 (PersonalObject watch))
     A4 (Believes! human t4 (if (exists [?agent1 ?agent2 ?u ?prop ?time1 ?time2]
                                    (and
                                        (PersonalObject ?u)
                                        (Believes! ?agent1 ?time1 (Holds (Prop ?u ?prop) ?time1))
                                        (Believes! ?agent2 ?time2 (Holds (Prop ?u ?prop) ?time2))
                                    )
                                )
                                (= (identityOf ?agent1) (identityOf ?agent2) )))


     A5 (Perceives! human t1 (Believes! (embodies a) t1 (Holds (Prop watch stopped) t1 )))
     A6 (Perceives! human t2 (Believes! (embodies b) t2 (Holds (Prop watch stopped) t2 )))

     A7 (Believes! human t3 (PersonalObject watch))
     A8 (Believes! human t4 (if (exists [?agent1 ?agent2 ?u ?prop ?time1 ?time2]
                                    (and
                                        (PersonalObject ?u)
                                        (Believes! ?agent1 ?time1 (Holds (Prop ?u ?prop) ?time1))
                                        (Believes! ?agent2 ?time2 (Holds (Prop ?u ?prop) ?time2))
                                    )
                                )
                                (= (identityOf ?agent1) (identityOf ?agent2) )))
    }

 :goal  (Believes! human t5 (= (identityOf (embodiment a)) (identityOf (embodiment b))))
}