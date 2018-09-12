
{
:name Test-1
:assumptions
  {
  A1   (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
            (= (TwoByOneMult ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                (+
                    (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                    (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
                )
            )
        )

  }


:goal  (=
            (TwoByOneMult 1 5 5)
            (+
                (MultiplicandOnesDigitTimesMultiplierOnesDigit 5 5)
                (MultiplicandTensDigitTimesMultiplierOnesDigit 1 5)
            )
        )
}

{
:name Test-ValidityInheritance-with-ChoiceList
:assumptions
  {

  A1   (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (=  (TwoByOneMult ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (+
                  (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                  (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              )
          )
       )

  A1-c (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (= (TwoByOneMultCalc ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              ($$sum
                  (MultiplicandOnesDigitTimesMultiplierOnesDigitCalc ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                  (MultiplicandTensDigitTimesMultiplierOnesDigitCalc ?MultiplicandTensDigit ?MultiplierOnesDigit)
              )
          )
       )

  A1-2 (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (= (TwoByOneMultErr1 ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (+
                  (MultiplicandTensDigitTimesMultiplicandOnesDigit ?MultiplicandTensDigit ?MultiplicandOnesDigit)
                  (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              )
          )
       )

  A1-2c(forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (= (TwoByOneMultErr1Calc ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              ($$sum
                  (MultiplicandTensDigitTimesMultiplicandOnesDigitCalc ?MultiplicandTensDigit ?MultiplicandOnesDigit)
                  (MultiplicandTensDigitTimesMultiplierOnesDigitCalc ?MultiplicandTensDigit ?MultiplierOnesDigit)
              )
          )
       )

  A1-3 (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (= (TwoByOneMultErr2 ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (+
                  (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                  (MultiplicandTensDigitTimesMultiplicandOnesDigit ?MultiplicandTensDigit ?MultiplicandOnesDigit)
              )
          )
       )

  A1-3c(forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (= (TwoByOneMultErr2Calc ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              ($$sum
                  (MultiplicandOnesDigitTimesMultiplierOnesDigitCalc ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                  (MultiplicandTensDigitTimesMultiplicandOnesDigitCalc ?MultiplicandTensDigit ?MultiplicandOnesDigit)
              )
          )
       )

  A2  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (Define
              (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (* ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
      )

  A2-c (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandOnesDigitTimesMultiplierOnesDigitCalc ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              ($$product ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
       )

  A3  (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (Define
              (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              (* (* ?MultiplicandTensDigit 10) ?MultiplierOnesDigit)
          )
      )

  A3-c (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandTensDigitTimesMultiplierOnesDigitCalc ?MultiplicandTensDigit ?MultiplierOnesDigit)
              ($$product ($$product ?MultiplicandTensDigit 10 ) ?MultiplierOnesDigit)
          )
       )

  A4  (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit)
          (Define
              (MultiplicandTensDigitTimesMultiplicandOnesDigit ?MultiplicandTensDigit ?MultiplicandOnesDigit)
              (* ?MultiplicandTensDigit ?MultiplicandOnesDigit)
          )
      )

  A4-c(forall (?MultiplicandTensDigit ?MultiplicandOnesDigit)
          (=
              (MultiplicandTensDigitTimesMultiplicandOnesDigitCalc ?MultiplicandTensDigit ?MultiplicandOnesDigit)
              ($$product ?MultiplicandTensDigit ?MultiplicandOnesDigit)
          )
      )

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

  A9  (forall (?AddedStep1 ?AddedStep2)
          (Validity
              (+ (Validity ?AddedStep1 Valid) (Validity ?AddedStep2 Valid) )
              Valid
          )
      )

  A9-1(forall (?AddedStep1 ?AddedStep2)
          (Validity
              (+ (Validity ?AddedStep1 Invalid) (Validity ?AddedStep2 Valid) )
              Invalid
          )
      )

  A9-2(forall (?AddedStep1 ?AddedStep2)
          (Validity
              (+ (Validity ?AddedStep1 Valid) (Validity ?AddedStep2 Invalid) )
              Invalid
          )
      )

  A9-3(forall (?AddedStep1 ?AddedStep2)
          (Validity
              (+ (Validity ?AddedStep1 Invalid) (Validity ?AddedStep2 Invalid) )
              Invalid
          )
      )

  A10 (forall (?AddedStep1 ?AddedStep2)
          (Validity
              (* (Validity ?AddedStep1 Valid) (Validity ?AddedStep2 Valid) )
              Valid
          )
      )

  A10-1(forall (?AddedStep1 ?AddedStep2)
          (Validity
              (* (Validity ?AddedStep1 Invalid) (Validity ?AddedStep2 Valid) )
              Invalid
          )
      )

  A10-2(forall (?AddedStep1 ?AddedStep2)
          (Validity
              (* (Validity ?AddedStep1 Valid) (Validity ?AddedStep2 Invalid) )
              Invalid
          )
      )

  A10-3(forall (?AddedStep1 ?AddedStep2)
          (Validity
              (* (Validity ?AddedStep1 Invalid) (Validity ?AddedStep2 Invalid) )
              Invalid
          )
      )



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

  }

 :answer-variables [?x]

 :answers-expected ( )

 :goal
        (and
            (Validity ?x invalid)
            (Optionally (TwoByOneMultAttempt 1 5 5) ?x)
        )

}