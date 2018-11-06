{
:name Test-ValidityInheritance-with-ChoiceList
:assumptions
  {
;; The A1-# assertions define three different top level paths to multiple two digit number by one digit numbers.
;; The ones with Err in their name are meant to represent paths that include wrong options.
;; Note: the plus sign, "+" automatically transforms into "$$sum" in the proofs and solution

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

;; A2-4 are currently not being used for anything.

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

;; A5-8 are assertions meant to represent the correctness of lowest level steps. The general reasoning below is
;; that Validity can either be valid or invalid, e.g. (Validity ?x valid) or (Validity ?x invalid). The first part
;; of these statements simply states that the part is correct, the second part allows for the base statement to be
;; replaced by the assertion of its validity or invalidity.

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

;; A9-# and 10-# are assertions meant to allow for validity to be tracked through the combination of the individual
;; part's own validity. Intuitively, a combination of adding or multiplying two steps is only valid if both steps
;; are also valid.

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

;; A11-13 are assertions meant to represent when an option has problem has several potential paths. I'm essentially
;; using it to allow me to have several potential answers for queries.

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