(defproject storm/storm-kestrel "0.7.2-snap2"
  :source-path "src/clj"
  :java-source-path "src/jvm"
  :javac-options {:debug "true" :fork "true"}
  :dependencies []
  :dev-dependencies [[storm "0.7.0"]
                     [org.clojure/clojure "1.2.0"]
                     [org.clojure/clojure-contrib "1.2.0"]]
  :jvm-opts ["-Djava.library.path=/usr/local/lib:/opt/local/lib:/usr/lib"]
)
