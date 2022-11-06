(ns midenfy.core-test
  (:require 
   [cljs.test :refer (deftest is)]
   [clojure.string :as string]
   [shadow.resource :as rc]
   [midenfy.core :as midenfy 
    :refer [midenfy]]))
   
(deftest positive-test
  (is (= true true)
      "Always true"))

(deftest addition-test
  (is (= (midenfy [:S [:symbol "+"] [:int "1"] [:int "2"]])
         [:begin [:push 1 2] [:checked_add]])      
      "Compile (+ 1 2)"))