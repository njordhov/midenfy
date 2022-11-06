(ns midenfy.compiler-test
  (:require 
   [cljs.test :refer (deftest is)]
   [clojure.string :as string]
   [shadow.resource :as rc]
   [midenfy.compiler :as compiler
    :refer [compile]]))
   
(deftest addition-test
  (is (= (compile [:S [:list [:symbol "+"] [:int "1"] [:int "2"]]])
         [:masm/begin 
          [:masm/push [:masm/int "1"]]
          [:masm/push [:masm/int "2"]]
          [:masm/checked_add]])     
      "Compile (+ 1 2)"))
