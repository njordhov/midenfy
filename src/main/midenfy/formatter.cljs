(ns midenfy.formatter
  (:require
    [clojure.string :as string]))

(defn indent [level s]
  (str (apply str (repeat (* 2 level) " "))
       s))

(defn linebreak [s]
  (str s "\n"))
  
(defn format 
  ([ast]
   (format 0 ast))
  ([level ast]
   (case (first ast)
     :masm/begin
     (concat
      (list (indent level (linebreak "begin")))
      (mapcat (partial format (+ 1 level))
              (rest ast))
      (list (indent level (linebreak "end"))))
     :masm/push
     (->> 
      (rest ast)
      (map #(case (first %) :masm/int (second %)))
      (apply str "push.")
      (indent level)
      (linebreak))
     :masm/proc
     (concat
       (list (->> (str "proc." (string/replace (second ast) #"-" "_") ".0")
                  (indent level)
                  (linebreak)))
       (mapcat (partial format (+ 1 level))
               (rest (rest ast)))
       (list (indent level (linebreak "end"))))
     (cond
       (keyword? (first ast))
       (indent level (linebreak (name (first ast))))
       :else (list (pr-str ast))))))
