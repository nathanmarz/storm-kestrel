(defproject storm-kestrel "0.0.2-SNAPSHOT"
  :java-source-path "src/jvm"
  :javac-options {:debug "true" :fork "true"}
  :dependencies []
  :uberjar-exclusions [#"META-INF.*"]
  :dev-dependencies [[storm "0.0.2-SNAPSHOT"]]
  :jvm-opts ["-Djava.library.path=/usr/local/lib:/opt/local/lib:/usr/lib"]
)
