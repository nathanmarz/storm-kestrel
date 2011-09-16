(defproject storm/storm-kestrel "0.5.0"
  :java-source-path "src/jvm"
  :javac-options {:debug "true" :fork "true"}
  :dependencies []
  :dev-dependencies [[storm "0.0.3-SNAPSHOT"]]
  :jvm-opts ["-Djava.library.path=/usr/local/lib:/opt/local/lib:/usr/lib"]
)
