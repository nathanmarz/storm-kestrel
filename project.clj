(defproject storm/storm-kestrel "1.1.0-SNAPSHOT"
  :source-paths ["src/clj"]
  :java-source-paths ["src/jvm"]
  :javac-options {:debug "true"}
  :dependencies []
  :profiles {:dev
              {:dependencies [[storm "0.8.2"]
                              [org.clojure/clojure "1.2.0"]
                     [org.clojure/clojure-contrib "1.2.0"]],
               :jvm-opts ["-Djava.library.path=/usr/local/lib:/opt/local/lib:/usr/lib"]}}
  :min-lein-version "2.0.0")
