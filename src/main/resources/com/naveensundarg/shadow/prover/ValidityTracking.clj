
{
:name Test-Validity-1
:assumptions
  {
;;  A0  (forall (?Step ?ValidityState)
;;          (=
;;              (Validity ?Step ?ValidityState)
;;              ?Step
;;          )
;;      )

  A1   (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (=  (TwoByOneMult ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (+
                  (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                  (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              )
          )
       )

  A2  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (* ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
      )

  A3  (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              (* (* ?MultiplicandTensDigit 10) ?MultiplierOnesDigit)
          )
      )

  A4  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (Validity
              (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              Valid
          )
      )

  A5  (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (Validity
              (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              Valid
          )
      )

  A6  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (Validity
              (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              Valid
          )
      )

  A7  (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit)
          (Validity
              (MultiplicandTensDigitTimesMultiplicandOnesDigit ?MultiplicandTensDigit ?MultiplicandOnesDigit)
              Invalid
          )
      )

  }

 :goal  (Validity
            (MultiplicandOnesDigitTimesMultiplierOnesDigit 5 5 )
            Valid
        )
}


{
:name Test-Validity-2-Inheritance
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

  A2  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (* ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
      )

  A3  (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              (* (* ?MultiplicandTensDigit 10) ?MultiplierOnesDigit)
          )
      )

  A4  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (Validity
              (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              Valid
          )
      )

  A5  (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (Validity
              (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              Valid
          )
      )

  A6  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (Validity
              (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              Valid
          )
      )

  A7  (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit)
          (Validity
              (MultiplicandTensDigitTimesMultiplicandOnesDigit ?MultiplicandTensDigit ?MultiplicandOnesDigit)
              Invalid
          )
      )

  A8  (forall (?AddedStep1 ?AddedStep2)
          (Validity
              (+ (Validity ?AddedStep1 Valid) (Validity ?AddedStep2 Valid) )
              Valid
          )
      )

  A9  (forall (?AddedStep1 ?AddedStep2)
          (Validity
              (* (Validity ?AddedStep1 Valid) (Validity ?AddedStep2 Valid) )
              Valid
          )
      )

  }

 :goal  (Validity (+ (Validity (MultiplicandOnesDigitTimesMultiplierOnesDigit 5 5 ) Valid) (Validity (MultiplicandTensDigitTimesMultiplierOnesDigit 1 5) Valid) ) Valid)

}

{
:name Test-Validity-2-2-InheritanceCont
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

  A2  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (* ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
      )

  A3  (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              (* (* ?MultiplicandTensDigit 10) ?MultiplierOnesDigit)
          )
      )

  A4  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
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

  A5  (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
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

  A6  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
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

  A7  (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit)
          (Validity
              (MultiplicandTensDigitTimesMultiplicandOnesDigit ?MultiplicandTensDigit ?MultiplicandOnesDigit)
              Invalid
          )
      )

  A8  (forall (?AddedStep1 ?AddedStep2)
          (Validity
              (+ (Validity ?AddedStep1 Valid) (Validity ?AddedStep2 Valid) )
              Valid
          )
      )

  A9  (forall (?AddedStep1 ?AddedStep2)
          (Validity
              (* (Validity ?AddedStep1 Valid) (Validity ?AddedStep2 Valid) )
              Valid
          )
      )

  }

 :goal  (Validity
            (TwoByOneMult 1 5 5)
            Valid)

}

{
:name Test-Invalidity-2-3-InheritanceCont
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

  A1-2 (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (= (TwoByOneMultErr1 ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (+
                  (MultiplicandTensDigitTimesMultiplicandOnesDigit ?MultiplicandTensDigit ?MultiplicandOnesDigit)
                  (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
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

  A2  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (* ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
      )

  A3  (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              (* (* ?MultiplicandTensDigit 10) ?MultiplierOnesDigit)
          )
      )

  A4  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
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

  A5  (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
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

  A6  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
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

  A7  (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit)
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

  A8  (forall (?AddedStep1 ?AddedStep2)
          (Validity
              (+ (Validity ?AddedStep1 Valid) (Validity ?AddedStep2 Valid) )
              Valid
          )
      )

  A8-1(forall (?AddedStep1 ?AddedStep2)
          (Validity
              (+ (Validity ?AddedStep1 Invalid) (Validity ?AddedStep2 Valid) )
              Invalid
          )
      )

  A8-2(forall (?AddedStep1 ?AddedStep2)
          (Validity
              (+ (Validity ?AddedStep1 Valid) (Validity ?AddedStep2 Invalid) )
              Invalid
          )
      )

  A8-3(forall (?AddedStep1 ?AddedStep2)
          (Validity
              (+ (Validity ?AddedStep1 Invalid) (Validity ?AddedStep2 Invalid) )
              Invalid
          )
      )

  A9  (forall (?AddedStep1 ?AddedStep2)
          (Validity
              (* (Validity ?AddedStep1 Valid) (Validity ?AddedStep2 Valid) )
              Valid
          )
      )

  A9-1(forall (?AddedStep1 ?AddedStep2)
          (Validity
              (* (Validity ?AddedStep1 Invalid) (Validity ?AddedStep2 Valid) )
              Invalid
          )
      )

  A9-2(forall (?AddedStep1 ?AddedStep2)
          (Validity
              (* (Validity ?AddedStep1 Valid) (Validity ?AddedStep2 Invalid) )
              Invalid
          )
      )

  A9-3(forall (?AddedStep1 ?AddedStep2)
          (Validity
              (* (Validity ?AddedStep1 Invalid) (Validity ?AddedStep2 Invalid) )
              Invalid
          )
      )

  }

 :goal  (Validity
            (TwoByOneMult 1 5 5)
            valid)

}

{
:name Test-Validity-3-Inheritance-with-ChoiceList
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

  A1-2 (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (= (TwoByOneMultErr1 ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (+
                  (MultiplicandTensDigitTimesMultiplicandOnesDigit ?MultiplicandTensDigit ?MultiplicandOnesDigit)
                  (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
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

  A2  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (* ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
      )

  A3  (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              (* (* ?MultiplicandTensDigit 10) ?MultiplierOnesDigit)
          )
      )

  A4  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
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

  A5  (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
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

  A6  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
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

  A7  (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit)
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

  A8  (forall (?AddedStep1 ?AddedStep2)
          (Validity
              (+ (Validity ?AddedStep1 Valid) (Validity ?AddedStep2 Valid) )
              Valid
          )
      )

  A8-1(forall (?AddedStep1 ?AddedStep2)
          (Validity
              (+ (Validity ?AddedStep1 Invalid) (Validity ?AddedStep2 Valid) )
              Invalid
          )
      )

  A8-2(forall (?AddedStep1 ?AddedStep2)
          (Validity
              (+ (Validity ?AddedStep1 Valid) (Validity ?AddedStep2 Invalid) )
              Invalid
          )
      )

  A8-3(forall (?AddedStep1 ?AddedStep2)
          (Validity
              (+ (Validity ?AddedStep1 Invalid) (Validity ?AddedStep2 Invalid) )
              Invalid
          )
      )

  A9  (forall (?AddedStep1 ?AddedStep2)
          (Validity
              (* (Validity ?AddedStep1 Valid) (Validity ?AddedStep2 Valid) )
              Valid
          )
      )

  A9-1(forall (?AddedStep1 ?AddedStep2)
          (Validity
              (* (Validity ?AddedStep1 Invalid) (Validity ?AddedStep2 Valid) )
              Invalid
          )
      )

  A9-2(forall (?AddedStep1 ?AddedStep2)
          (Validity
              (* (Validity ?AddedStep1 Valid) (Validity ?AddedStep2 Invalid) )
              Invalid
          )
      )

  A9-3(forall (?AddedStep1 ?AddedStep2)
          (Validity
              (* (Validity ?AddedStep1 Invalid) (Validity ?AddedStep2 Invalid) )
              Invalid
          )
      )



  A10   (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (Optionally
              (TwoByOneMultAttempt ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (TwoByOneMult ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
       )

  A11   (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (Optionally
              (TwoByOneMultAttempt ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (TwoByOneMultErr1 ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
       )

  A12   (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
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
            (Optionally (TwoByOneMultAttempt 1 5 5) ?x)
            (Validity ?x invalid)
        )

}

{
:name Test-ValidityInheritance-with-ChoiceList-from-Debug
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

  A1-2 (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (= (TwoByOneMultErr1 ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (+
                  (MultiplicandTensDigitTimesMultiplicandOnesDigit ?MultiplicandTensDigit ?MultiplicandOnesDigit)
                  (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
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

  A2  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (Define
              (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (* ?MultiplicandOnesDigit ?MultiplierOnesDigit)
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
            (Validity ?x valid)
            (Optionally (TwoByOneMultAttempt 1 5 5) ?x)
        )

}