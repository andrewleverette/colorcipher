(ns colorcipher-test.logic-test
  (:require [clojure.test :refer [deftest is testing]]
            [colorcipher.logic :refer [generate-solution]]))

(deftest validate-generate-solution
  (testing "Generating a solution returns sequnce correct length with unique colors from colors set"
    (let [colors [:red :green :orange :blue :yellow :purple]
          length 4
          generated-solution-sets (map set (repeatedly 100 #(generate-solution colors length)))]
      (is (every? #(= length (count %)) generated-solution-sets)))))
