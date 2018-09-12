
{
:name Test-0-only-equals-0
:assumptions
  {A1 (forall (?x) (not (= 0 (S ?x))))
   A2 (forall (?x ?y) (if (= (S ?x) (S ?y)) (= ?x ?y) ))
   A3 (forall (?x) (= (add ?x 0) ?x))
   A4 (forall (?x ?y) (= (add ?x (S ?y)) (add (S ?x) ?y)))
   A5 (forall (?x) (= (mult ?x 0) 0))
   A6 (forall (?x ?y) (= (mult ?x (S ?y)) (add (mult ?x ?y) ?x)))}

 :goal (forall x (not (= (S x) 0)))
}

{
:name Test-Addition
:assumptions
  {A1 (forall (?x) (not (= 0 (S ?x))))
   A2 (forall (?x ?y) (if (= (S ?x) (S ?y)) (= ?x ?y) ))
   A3 (forall (?x) (= (add ?x 0) ?x))
   A4 (forall (?x ?y) (= (add ?x (S ?y)) (add (S ?x) ?y)))
   A5 (forall (?x) (= (mult ?x 0) 0))
   A6 (forall (?x ?y) (= (mult ?x (S ?y)) (add (mult ?x ?y) ?x)))}

 :goal (= (add (S(S 0)) (S 0) ) (S(S(S 0))))
}

{
:name Test-Multiplication
:assumptions
  {A1 (forall (?x) (not (= 0 (S ?x))))
   A2 (forall (?x ?y) (if (= (S ?x) (S ?y)) (= ?x ?y) ))
   A3 (forall (?x) (= (add ?x 0) ?x))
   A4 (forall (?x ?y) (= (add ?x (S ?y)) (add (S ?x) ?y)))
   A5 (forall (?x) (= (mult ?x 0) 0))
   A6 (forall (?x ?y) (= (mult ?x (S ?y)) (add (mult ?x ?y) ?x)))}

 :goal (= (mult (S(S 0)) (S(S 0)) ) (S(S(S(S 0)))) )
}

{
:name Test-Multiplication-Longer
:assumptions
  {A1 (forall (?x) (not (= 0 (S ?x))))
   A2 (forall (?x ?y) (if (= (S ?x) (S ?y)) (= ?x ?y) ))
   A3 (forall (?x) (= (add ?x 0) ?x))
   A4 (forall (?x ?y) (= (add ?x (S ?y)) (add (S ?x) ?y)))
   A5 (forall (?x) (= (mult ?x 0) 0))
   A6 (forall (?x ?y) (= (mult ?x (S ?y)) (add (mult ?x ?y) ?x)))}

 :goal (= (mult (S(S(S(S(S 0))))) (S(S(S(S(S 0))))) ) (S(S(S(S(S(S(S(S(S(S(S(S(S(S(S(S(S(S(S(S(S(S(S(S(S 0))))))))))))))))))))))))) )
}

{
:name Test-Multiplication-Answer-Extraction
:assumptions
  {A1 (forall (?x) (not (= 0 (S ?x))))
   A2 (forall (?x ?y) (if (= (S ?x) (S ?y)) (= ?x ?y) ))
   A3 (forall (?x) (= (add ?x 0) ?x))
   A4 (forall (?x ?y) (= (add ?x (S ?y)) (add (S ?x) ?y)))
   A5 (forall (?x) (= (mult ?x 0) 0))
   A6 (forall (?x ?y) (= (mult ?x (S ?y)) (add (mult ?x ?y) ?x)))}

:answer-variables [?x]

:answers-expected ( )

:goal (= (mult ?x (S(S(S 0))) ) (S(S(S(S(S(S 0)))))) )
}

{
:name Test-BA-Intro-1
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

  BA1 (forall (?x) (not (= 0 (S ?x))))
  BA2 (forall (?x ?y) (if (= (S ?x) (S ?y)) (= ?x ?y) ))
  BA3 (forall (?x) (= (+ ?x 0) ?x))
  BA4 (forall (?x ?y) (= (+ ?x (S ?y)) (+ (S ?x) ?y)))
  BA5 (forall (?x) (= (* ?x 0) 0))
  BA6 (forall (?x ?y) (= (* ?x (S ?y)) (add (* ?x ?y) ?x)))

  }


 :goal  (=
            (TwoByOneMult 1 2 2)
            (+
                (* 2 2)
                (* (* 1 10) 2)
            )
        )
}

{
:name Test-BA-Intro-Successor-Conversion
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

  A2  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (* ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
      )

  A3  (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              (* (* ?MultiplicandTensDigit (S(S(S(S(S(S(S(S(S(S 0)))))))))) ) ?MultiplierOnesDigit)
          )
      )

  BA1 (forall (?x) (not (= 0 (S ?x))))
  BA2 (forall (?x ?y) (if (= (S ?x) (S ?y)) (= ?x ?y) ))
  BA3 (forall (?x) (= (+ ?x 0) ?x))
  BA4 (forall (?x ?y) (= (+ ?x (S ?y)) (+ (S ?x) ?y)))
  BA5 (forall (?x) (= (* ?x 0) 0))
  BA6 (forall (?x ?y) (= (* ?x (S ?y)) (add (* ?x ?y) ?x)))

  }


 :goal  (=
            (TwoByOneMult (S 0) (S(S 0)) (S(S 0)))
            (+
                (* (S(S 0)) (S(S 0)) )
                (* (* (S 0) (S(S(S(S(S(S(S(S(S(S 0)))))))))) ) (S(S 0)) )
            )
        )
}

{
:name Test-BA-Basic-Math-1
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

  A2  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (* ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
      )

  A3  (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              (* (* ?MultiplicandTensDigit (S(S(S(S(S(S(S(S(S(S 0)))))))))) ) ?MultiplierOnesDigit)
          )
      )

  A4 (forall (?x) (not (= 0 (S ?x))))
  A5 (forall (?x ?y) (if (= (S ?x) (S ?y)) (= ?x ?y) ))
  A6 (forall (?x) (= (+ ?x 0) ?x))
  A7 (forall (?x ?y) (= (+ ?x (S ?y)) (+ (S ?x) ?y)))
  A8 (forall (?x) (= (* ?x 0) 0))
  A9 (forall (?x ?y) (= (* ?x (S ?y)) (+ (* ?x ?y) ?x)))

  }


 :goal  (=
            (TwoByOneMult (S 0) (S(S 0)) (S(S 0)) )
            (+
                (S(S(S(S 0))))
                (* (* (S 0) (S(S(S(S(S(S(S(S(S(S 0)))))))))) ) (S(S 0)) )
            )
        )
}

{
:name Test-BA-Basic-Math-2
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

  A2  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (* ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
      )

  A3  (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              (* (* ?MultiplicandTensDigit (S(S(S(S(S(S(S(S(S(S 0)))))))))) ) ?MultiplierOnesDigit)
          )
      )

  A4 (forall (?x) (not (= 0 (S ?x))))
  A5 (forall (?x ?y) (if (= (S ?x) (S ?y)) (= ?x ?y) ))
  A6 (forall (?x) (= (+ ?x 0) ?x))
  A7 (forall (?x ?y) (= (+ ?x (S ?y)) (+ (S ?x) ?y)))
  A8 (forall (?x) (= (* ?x 0) 0))
  A9 (forall (?x ?y) (= (* ?x (S ?y)) (+ (* ?x ?y) ?x)))

  }


 :goal  (=
            (TwoByOneMult (S 0) (S(S 0)) (S(S 0)) )
            (+
                (S(S(S(S 0))))
                (* (S(S(S(S(S(S(S(S(S(S 0)))))))))) (S(S 0)) )
            )
        )
}

{
:name Test-BA-Basic-Math-3
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

  A2  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (* ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
      )

  A3  (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              (* (* ?MultiplicandTensDigit (S(S(S(S(S(S(S(S(S(S 0)))))))))) ) ?MultiplierOnesDigit)
          )
      )

  A4 (forall (?x) (not (= 0 (S ?x))))
  A5 (forall (?x ?y) (if (= (S ?x) (S ?y)) (= ?x ?y) ))
  A6 (forall (?x) (= (+ ?x 0) ?x))
  A7 (forall (?x ?y) (= (+ ?x (S ?y)) (+ (S ?x) ?y)))
  A8 (forall (?x) (= (* ?x 0) 0))
  A9 (forall (?x ?y) (= (* ?x (S ?y)) (+ (* ?x ?y) ?x)))

  }


 :goal  (=
            (TwoByOneMult (S 0) (S(S 0)) (S(S 0)) )
            (+
                (S(S(S(S 0))))
                (S(S(S(S(S(S(S(S(S(S(S(S(S(S(S(S(S(S(S(S 0))))))))))))))))))))
            )
        )
}

{
:name Test-BA-Basic-Math-4
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

  A2  (forall (?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (* ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
      )

  A3  (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (=
              (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              (* (* ?MultiplicandTensDigit (S(S(S(S(S(S(S(S(S(S 0)))))))))) ) ?MultiplierOnesDigit)
          )
      )

  A4 (forall (?x) (not (= 0 (S ?x))))
  A5 (forall (?x ?y) (if (= (S ?x) (S ?y)) (= ?x ?y) ))
  A6 (forall (?x) (= (+ ?x 0) ?x))
  A7 (forall (?x ?y) (= (+ ?x (S ?y)) (+ (S ?x) ?y)))
  A8 (forall (?x) (= (* ?x 0) 0))
  A9 (forall (?x ?y) (= (* ?x (S ?y)) (+ (* ?x ?y) ?x)))

  }


 :goal  (=
            (TwoByOneMult (S 0) (S(S 0)) (S(S 0)) )
            (S(S(S(S(S(S(S(S(S(S(S(S(S(S(S(S(S(S(S(S(S(S(S(S 0))))))))))))))))))))))))
        )
}