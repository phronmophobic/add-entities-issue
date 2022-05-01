(ns com.phronemophobic.datahike.add-entities-issue
  (:require [clojure.java.io :as io]
            [datahike.api :as d]
            [taoensso.timbre :as log]

            )
  (:gen-class))

(def schema
  [
   {:db/ident ::id
    :db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/unique :db.unique/identity}
   {:db/ident ::unread?
    :db/valueType :db.type/boolean
    :db/cardinality :db.cardinality/one}])


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (log/set-level! :warn)
  
  (let [cfg {:store {:backend :file :path (.getAbsolutePath
                                           (io/file "my-db"))}}]

    (d/create-database cfg)

    (let [conn (d/connect cfg)]
      (d/transact conn schema)
      
      (dotimes [i 10000]
        (println "entity: " i)
        (d/transact conn
                    [{::id (str i)
                      ::unread? (even? i)}])))))
