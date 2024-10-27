(ns colorcipher.logic)

(defn generate-solution
  "Given a set of colors and the length of the sequence,
  genereate a unique solution sequence"
  [color-set sequence-length]
  (->> color-set
       shuffle
       (take sequence-length)))
