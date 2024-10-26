(ns colorecipher-state-test
  (:require [clojure.test :refer [deftest is testing]]
            [colorcipher.state :refer [initial-state update-state]]))

(deftest test-initial-state
  (testing "Creating an initial game state creates starting point with the solution"
    (let [solution [:red :blue :green :yellow]]
      (is (= {:solution solution
              :attempts []
              :feedback []
              :history []
              :guesses 0
              :max-guesses 8
              :current-round 1} (initial-state solution))))))

(deftest test-updating-state
  (testing "Updating the game state adds a new guess and feedback and updates history and guess count numbers"
    (let [state (initial-state [:red :blue :green :yellow])
          guess [:purple :orange :red :yellow]
          feedback {:black 1 :white 1}
          updated-state (update-state state guess feedback)]
      (is (= (conj (:attempts state) guess) (:attempts updated-state)))
      (is (= (conj (:feedback state) feedback) (:feedback updated-state)))
      (is (= (conj (:history state) {:attempt guess :feedback feedback}) (:history updated-state)))
      (is (= (inc (:guesses state)) (:guesses updated-state)))
      ;; The max guess count does not change during update
      (is (= (:max-guesses state) (:max-guesses updated-state)))
      (is (= (inc (:current-round state)) (:current-round updated-state))))))

