(ns colorcipher.config)

(def config {:config/max-guesses 8
             :config/color-set [:red :green :orange :blue :yellow :purple]
             :config/sequence-length 4})

(defn max-guesses
  [config]
  (:config/max-guesses config))

(defn color-set
  [config]
  (:config/color-set config))

(defn sequence-length
  [config]
  (:config/sequence-length config))
