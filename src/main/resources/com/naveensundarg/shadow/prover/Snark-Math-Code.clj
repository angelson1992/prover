{
:name Basic-Math-code
:assumptions {}
:goal  (=
            ($$product 5 5)
            (25)
       )
}

{
:name Test-Code-Basic-Math-1
:assumptions
  {
  A1   (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (= (TwoByOneMult ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              ($$sum
                  (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                  (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              )
          )
       )

  A2  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              ($$product ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
      )

  A3  (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              ($$product ($$product ?MultiplicandTensDigit 10 ) ?MultiplierOnesDigit)
          )
      )

  }


 :goal  (=
            (TwoByOneMult 1 2 2 )
            ($$sum
                4
                ($$product ($$product 1 10 ) 2 )
            )
        )
}

{
:name Test-Code-Basic-Math-2
:assumptions
  {
  A1   (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (= (TwoByOneMult ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              ($$sum
                  (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                  (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              )
          )
       )

  A2  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              ($$product ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
      )

  A3  (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              ($$product ($$product ?MultiplicandTensDigit 10 ) ?MultiplierOnesDigit)
          )
      )

  }


 :goal  (=
            (TwoByOneMult 1 2 2 )
            ($$sum
                4
                ($$product 10 2 )
            )
        )
}

{
:name Test-Code-Basic-Math-3
:assumptions
  {
  A1   (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (= (TwoByOneMult ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              ($$sum
                  (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                  (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              )
          )
       )

  A2  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              ($$product ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
      )

  A3  (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              ($$product ($$product ?MultiplicandTensDigit 10 ) ?MultiplierOnesDigit)
          )
      )

  }


 :goal  (=
            (TwoByOneMult 1 2 2 )
            ($$sum
                4
                20
            )
        )
}

{
:name Test-Code-Basic-Math-4
:assumptions
  {
  A1   (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (= (TwoByOneMult ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              ($$sum
                  (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                  (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              )
          )
       )

  A2  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              ($$product ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
      )

  A3  (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              ($$product ($$product ?MultiplicandTensDigit 10 ) ?MultiplierOnesDigit)
          )
      )

  }


 :goal  (=
            (TwoByOneMult 1 2 2 )
            24
        )
}

{
:name Test-Code-Basic-Math-4-Calc
:assumptions
  {
  A1-c (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (= (TwoByOneMultCalc ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              ($$sum
                  (MultiplicandOnesDigitTimesMultiplierOnesDigitCalc ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                  (MultiplicandTensDigitTimesMultiplierOnesDigitCalc ?MultiplicandTensDigit ?MultiplierOnesDigit)
              )
          )
       )

  A1-p (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (= (TwoByOneMultProv ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (+
                  (MultiplicandOnesDigitTimesMultiplierOnesDigitProv ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                  (MultiplicandTensDigitTimesMultiplierOnesDigitProv ?MultiplicandTensDigit ?MultiplierOnesDigit)
              )
          )
       )

  A2-c (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandOnesDigitTimesMultiplierOnesDigitCalc ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              ($$product ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
       )

  A2-p (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandOnesDigitTimesMultiplierOnesDigitProv ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (* ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
       )

  A3-c (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandTensDigitTimesMultiplierOnesDigitCalc ?MultiplicandTensDigit ?MultiplierOnesDigit)
              ($$product ($$product ?MultiplicandTensDigit 10 ) ?MultiplierOnesDigit)
          )
       )

  A3-p (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandTensDigitTimesMultiplierOnesDigitProv ?MultiplicandTensDigit ?MultiplierOnesDigit)
              (* (* ?MultiplicandTensDigit 10 ) ?MultiplierOnesDigit)
          )
       )

  }


 :goal  (=
            (TwoByOneMultCalc 1 2 2 )
            24
        )
}

{
:name Test-Code-Basic-Math-4-Prov
:assumptions
  {
  A1-c (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (= (TwoByOneMultCalc ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              ($$sum
                  (MultiplicandOnesDigitTimesMultiplierOnesDigitCalc ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                  (MultiplicandTensDigitTimesMultiplierOnesDigitCalc ?MultiplicandTensDigit ?MultiplierOnesDigit)
              )
          )
       )

  A1-p (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (= (TwoByOneMultProv ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (+
                  (MultiplicandOnesDigitTimesMultiplierOnesDigitProv ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                  (MultiplicandTensDigitTimesMultiplierOnesDigitProv ?MultiplicandTensDigit ?MultiplierOnesDigit)
              )
          )
       )

  A2-c (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandOnesDigitTimesMultiplierOnesDigitCalc ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              ($$product ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
       )

  A2-p (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandOnesDigitTimesMultiplierOnesDigitProv ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (* ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
       )

  A3-c (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandTensDigitTimesMultiplierOnesDigitCalc ?MultiplicandTensDigit ?MultiplierOnesDigit)
              ($$product ($$product ?MultiplicandTensDigit 10 ) ?MultiplierOnesDigit)
          )
       )

  A3-p (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandTensDigitTimesMultiplierOnesDigitProv ?MultiplicandTensDigit ?MultiplierOnesDigit)
              (* (* ?MultiplicandTensDigit 10 ) ?MultiplierOnesDigit)
          )
       )

  }

 :answer-variables [?x]

 :answers-expected ( )

 :goal  (=
            (TwoByOneMultProv 1 2 2 )
            ?x
        )
}

{
:name Test-Code-Basic-Math-4-Prov-N-Calc
:assumptions
  {
  A1-c (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (= (TwoByOneMultCalc ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              ($$sum
                  (MultiplicandOnesDigitTimesMultiplierOnesDigitCalc ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                  (MultiplicandTensDigitTimesMultiplierOnesDigitCalc ?MultiplicandTensDigit ?MultiplierOnesDigit)
              )
          )
       )

  A1-p (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (= (TwoByOneMultProv ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (+
                  (MultiplicandOnesDigitTimesMultiplierOnesDigitProv ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                  (MultiplicandTensDigitTimesMultiplierOnesDigitProv ?MultiplicandTensDigit ?MultiplierOnesDigit)
              )
          )
       )

  A2-c (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandOnesDigitTimesMultiplierOnesDigitCalc ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              ($$product ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
       )

  A2-p (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandOnesDigitTimesMultiplierOnesDigitProv ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (* ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
       )

  A3-c (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandTensDigitTimesMultiplierOnesDigitCalc ?MultiplicandTensDigit ?MultiplierOnesDigit)
              ($$product ($$product ?MultiplicandTensDigit 10 ) ?MultiplierOnesDigit)
          )
       )

  A3-p (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandTensDigitTimesMultiplierOnesDigitProv ?MultiplicandTensDigit ?MultiplierOnesDigit)
              (* (* ?MultiplicandTensDigit 10 ) ?MultiplierOnesDigit)
          )
       )

  }

 :answer-variables [?x]

 :answers-expected ( )

 :goal  (and
            (=
                (TwoByOneMultCalc 1 2 2 )
                24
            )
            (=
                (TwoByOneMultProv 1 2 2 )
                ?x
            )
        )
}

