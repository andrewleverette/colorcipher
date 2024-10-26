(ns colorcipher-test.logic-test
  (:require [clojure.test :refer [deftest is testing]]))

(deftest failure-test
  (testing "Failure test in logic test"
    (is (= 0 1))))
