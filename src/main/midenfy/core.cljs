(ns midenfy.core
  (:require 
   [clojure.tools.cli :refer [parse-opts]]))

(def cli-options
  [[nil "--version"]
   ["-h" "--help"]])

(defn execute [{:keys [arguments options summary errors] :as opts}]
  (cond
    (some? errors)
    (println errors)
    (empty? arguments)
    (println "Hello")
    (or (some? (:help options))
        (and (empty? arguments) (empty? options)))
    (do 
      (println "Compiler for the Polygon Miden VM")
      (println "Usage: midenfy [options] file*")
      (println "Options:")
      (println summary))))

(defonce command (atom nil))

(defn main [& args]
  (let [opts (parse-opts args cli-options)]
    (reset! command opts)
    (execute opts)))

(defn ^:dev/after-load activate! []
  (println "# Executing command:" @command)
  (execute @command))
