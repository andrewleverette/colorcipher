(ns colorcipher-test.state-test
  (:require [clojure.test :refer [deftest is testing]]
            [colorcipher.state :refer [initial-state update-state]]))

(deftest test-initial-state
  (testing "Creating an initial default state should return a new state with default values"
    (let [solution [:red :blue :green :yellow]
          new-state (initial-state solution)]
      (is (= {:state/solution solution
              :state/attempts []
              :state/feedback []
              :state/history []
              :state/guesses 0
              :state/current-round 1} new-state)))))

(deftest test-updating-state
  (testing "Updating the game state adds a new guess and feedback and updates history and guess count numbers"
    (let [state (initial-state [:red :blue :green :yellow])
          guess [:purple :orange :red :yellow]
          feedback {:black 1 :white 1}
          updated-state (update-state state guess feedback)]
      (is (= (conj (:state/attempts state) guess) (:state/attempts updated-state)))
      (is (= (conj (:state/feedback state) feedback) (:state/feedback updated-state)))
      (is (= (conj (:state/history state) {:history/attempt guess :history/feedback feedback})
             (:state/history updated-state)))
      (is (= (inc (:state/guesses state)) (:state/guesses updated-state)))
      (is (= (inc (:state/current-round state)) (:state/current-round updated-state))))))

