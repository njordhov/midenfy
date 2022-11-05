(ns midenfy.core
  (:require 
   [clojure.tools.cli :refer [parse-opts]]))

(def cli-options
  [[nil "--version"]
   ["-h" "--help"]])

(defn main [& args]
  (let [{:keys [arguments options summary errors] :as opts}
        (parse-opts args cli-options)]
    (cond 
      (some? (:help options))
      (do 
        (println "Compiler for the Polygon Miden VM")
        (println "Usage: midenfy [options] file*")
        (println "Options:")
        (println summary)))))
