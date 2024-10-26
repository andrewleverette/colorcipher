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
  (let [{attempts :attempts
         last-feedback :feedback
         history  :history
         guesses  :guesses
         current-round :current-round} state]
    (assoc state
           :attempts (conj attempts guess)
           :feedback (conj last-feedback feedback)
           :history (conj history {:attempt guess :feedback feedback})
           :guesses (inc guesses)
           :current-round (inc current-round))))

(def s (initial-state [:red :blue :green :yellow]))

(def u (update-state s [:purple :orange :red :yellow] {:black 1 :white 1}))

u
