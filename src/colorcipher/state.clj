(ns colorcipher.state)

(defn initial-state
  [solution]
  {:solution solution
   :attempts []
   :feedback []
   :history []
   :guesses 0
   :max-guesses 8
   :current-round 1})

(defn update-state
  [state guess feedback]
  (let [new-attempts (conj (:attempts state) guess)
        new-feedback (conj (:feedback state) feedback)
        new-history (conj (:history state) {:attempt guess :feedback feedback})]
    {:solution (:solution state)
     :attempts new-attempts
     :feedback new-feedback
     :history new-history
     :guesses (inc (:guesses state))
     :max-guesses (:max-guesses state)
     :current-round (inc (:current-round state))}))
