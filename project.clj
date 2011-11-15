(defproject storm/storm-kestrel "0.6.0-SNAPSHOT"
  :java-source-path "src/jvm"
  :javac-options {:debug "true" :fork "true"}
  :dependencies [[kestrel-thrift-java-bindings "0.5.0"]]
  :dev-dependencies [[storm "0.5.4"]]
  :jvm-opts ["-Djava.library.path=/usr/local/lib:/opt/local/lib:/usr/lib"]
)
