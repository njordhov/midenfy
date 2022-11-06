(ns midenfy.formatter)

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
      (list (indent level "begin\n"))
      (mapcat (partial format (+ 1 level))
              (rest ast))
      (list (indent level "end\n")))
     :masm/push
     (->> 
      (rest ast)
      (map #(case (first %) :masm/int (second %)))
      (apply str "push.")
      (indent level)
      (linebreak))
     (cond
       (keyword? (first ast))
       (indent level (linebreak (name (first ast))))
       :else (list (pr-str ast))))))
