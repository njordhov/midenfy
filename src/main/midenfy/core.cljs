(ns midenfy.core
  (:require 
   [clojure.tools.cli :refer [parse-opts]]
   [cljs-node-io.core :as io 
    :refer [slurp]]
   [clariform.ast.parser :as clarity]
   [midenfy.compiler :as compiler 
    :refer [compile]]
   [midenfy.formatter :as formatter 
    :refer [format]]))

(def cli-options
  [[nil "--version"]
   ["-h" "--help"]])

(defn execute [{:keys [arguments options summary errors] :as opts}]
  (cond
    (some? errors)
    (println errors)
    (some? (:help options))
    (do 
      (println "Compiler for the Polygon Miden VM")
      (println "Usage: midenfy [options] filepath")
      (println "Options:")
      (println summary))
    :else
    (let [code (slurp (first arguments))
          ast (clarity/parse-robust code)]
      (println (-> ast compile format ((partial apply str)))))))

(defonce command (atom nil))

(defn main [& args]
  (let [opts (parse-opts args cli-options)]
    (reset! command opts)
    (try
      (execute opts)
      (catch :default e
        (println e)))))

(defn ^:dev/after-load activate! []
  (println "# Executing command:" @command)
  (execute @command))
