(ns midenfy.core
  (:require 
   [clojure.tools.cli :refer [parse-opts]]
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
    (empty? arguments)
    (let [ast [:S [:list [:symbol "+"] [:int "1"] [:int "2"]]]]
      (println (-> ast compile format ((partial apply str)))))
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
