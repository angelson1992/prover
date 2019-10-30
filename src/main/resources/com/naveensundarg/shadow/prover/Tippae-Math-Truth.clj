
{
:name Test-ValidityInheritance-with-2LayerChoiceList-WIP
:assumptions
  {

;; A1 and its subsections explicitly state the definition of the various types of TwoByOneMult steps
;; along with stating that it is fine to directly replace those steps with their broken down versions.

  A1   (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (Define  (TwoByOneMult ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (Addition
                  (MultiplicandOnesDigitTimesMultiplierOnesDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
                  (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              )
          )
       )

  A1-2 (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (Define (TwoByOneMultErr1 ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
              (Addition
                  (MultiplicandTensDigitTimesMultiplicandOnesDigit ?MultiplicandTensDigit ?MultiplicandOnesDigit)
                  (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              )
          )
       )

  A1-3 (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          (Define (TwoByOneMultErr2 ?MultiplicandTensDigit ?MultiplicandOnesDigit ?MultiplierOnesDigit)
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
              (Multiplication ?MultiplicandOnesDigit ?MultiplierOnesDigit)
          )
      )

  A3  (forall (?MultiplicandTensDigit ?MultiplierOnesDigit)
          (Define
              (MultiplicandTensDigitTimesMultiplierOnesDigit ?MultiplicandTensDigit ?MultiplierOnesDigit)
              (Multiplication (Multiplication ?MultiplicandTensDigit 10) ?MultiplierOnesDigit)
          )
      )

  A4  (forall (?MultiplicandTensDigit ?MultiplicandOnesDigit)
          (Define
              (MultiplicandTensDigitTimesMultiplicandOnesDigit ?MultiplicandTensDigit ?MultiplicandOnesDigit)
              (Multiplication ?MultiplicandTensDigit ?MultiplicandOnesDigit)
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

 :answer-variables [?option, ?definition, ?validity]

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
            (Optionally (TwoByOneMultAttempt 1 5 5) ?option) ;;This represents the questions being analysed and is not optional
            (Define ?option ?definition)
            (Validity ?definition ?validity)
        )

}