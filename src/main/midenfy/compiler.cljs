(ns midenfy.compiler)

(defn form-symbol [exp]
  (if (and (= :list (first exp))
           (= :symbol (first (second exp))))
    (second (second exp))))

(defmulti compile-form first)

(defmulti compile-call form-symbol)

(defn push-arg [exp]
  (case (first exp)
    :int [:masm/push [:masm/int (second exp)]]))

(defmethod compile-call :default [exp]
  nil)

(defmethod compile-call "+" [exp]
  (let [args (rest (rest exp))]
    (concat 
      (map push-arg args) 
      (list [:masm/checked_add]))))

(defmethod compile-call "-" [exp]
  (let [args (rest (rest exp))]
    (concat 
      (map push-arg args) 
      (list [:masm/checked_sub]))))

(defmethod compile-call "*" [exp]
  (let [args (rest (rest exp))]
    (concat 
      (map push-arg args) 
      (list [:masm/checked_mul]))))

(defmethod compile-call "/" [exp]
  (let [args (rest (rest exp))]
    (concat 
      (map push-arg args) 
      (list [:masm/checked_div]))))

(defmethod compile-form :default [form]
  nil)

(defmethod compile-form :list [form]
  (compile-call form))

(defmethod compile-form :toplevel [form]
  (mapcat compile-form (rest form)))

(defmethod compile-form :S [form]
  (into [:masm/begin]
        (mapcat compile-form (rest form))))

(defn compile [form]
  (compile-form form))
