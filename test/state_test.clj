(ns state-test
  (:require [clojure.test :refer [deftest is testing]]
            [colorcipher.state :refer [initial-state update-state]]))

(deftest test-initial-state
  (testing "Creating an initial default state should return a new state with default values"
    (let [solution [:red :blue :green :yellow]
          new-state (initial-state solution)]
      (is (= {:solution solution
              :attempts []
              :feedback []
              :history []
              :guesses 0
              :max-guesses 8
              :current-round 1} new-state))))
  (testing "Creating a new state with custom values should return a new state with those values"
    (let [solution [:maroon :navy :olive :lime]
          new-state (initial-state solution 10)]
      (is (= {:solution solution
              :attempts []
              :feedback []
              :history []
              :guesses 0
              :max-guesses 10
              :current-round 1} new-state)))))

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

