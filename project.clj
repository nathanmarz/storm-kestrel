(defproject storm/storm-kestrel "0.7.0-SNAPSHOT"
  :source-path "src/clj"
  :java-source-path "src/jvm"
  :javac-options {:debug "true" :fork "true"}
  :dependencies [[kestrel-thrift-java-bindings "2.2.0"]]
  :dev-dependencies [[storm "0.7.0-SNAPSHOT"]]
  :jvm-opts ["-Djava.library.path=/usr/local/lib:/opt/local/lib:/usr/lib"]
)
