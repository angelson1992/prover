{
:name Test-Invalidity-5-Choices
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

  A2   (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (Optionally
              (TwoByOneMultAttempt ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (TwoByOneMult ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
       )

  A3   (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (Optionally
              (TwoByOneMultAttempt ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (TwoByOneMultErr1 ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
       )

  A4   (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (Optionally
              (TwoByOneMultAttempt ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (TwoByOneMultErr2 ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
       )

  }

 :answer-variables [?x]

 :answers-expected ( )

 :goal  (Optionally
            (TwoByOneMultAttempt 1 2 2)
            ?x
        )
}

{
:name Test-Invalidity-5-Choices-identity
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

  A2   (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (Optionally
              (TwoByOneMultAttempt ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (TwoByOneMult ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
       )

  A3   (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (Optionally
              (TwoByOneMultAttempt ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (TwoByOneMultErr1 ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
       )

  A4   (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (Optionally
              (TwoByOneMultAttempt ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (TwoByOneMultErr2 ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
       )

;;  A5   (forall (?Attempt ?Selected)
;;          (=
;;              (Optionally
;;                  ?Attempt
;;                  ?Selected
;;              )
;;              ?Selected
;;          )
;;       )

  }

 :answer-variables [?x]

 :answers-expected ( )

 :goal
            (Optionally
                (TwoByOneMultAttempt 1 2 2)
                ?x
            )
}