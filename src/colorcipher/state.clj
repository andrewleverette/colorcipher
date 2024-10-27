(ns colorcipher.state)

(defn initial-state
  "Create an initial state with the given solution"
  [solution]
  {:state/solution solution
   :state/attempts []
   :state/feedback []
   :state/history []
   :state/guesses 0
   :state/current-round 1})

(defn update-state
  "Update the state with the given guess and feedback"
  [state guess feedback]
  (let [{attempts :state/attempts
         last-feedback :state/feedback
         history  :state/history
         guesses  :state/guesses
         current-round :state/current-round} state]
    (assoc state
           :state/attempts (conj attempts guess)
           :state/feedback (conj last-feedback feedback)
           :state/history (conj history {:history/attempt guess :history/feedback feedback})
           :state/guesses (inc guesses)
           :state/current-round (inc current-round))))
