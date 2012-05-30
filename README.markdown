Library to use Kestrel as a spout from within Storm.

This spout uses Kestrel's Thrift API which became available as of Kestrel 2.2. 

## Spout usage

The `KestrelThriftSpout` in this library reads messages off of one or more Kestrel servers. When using the spout, it is recommended that you increase the parallelism of the spout to increase the rate at which you can read messages from Kestrel. 

The spout deals gracefully with any errors coming from Kestrel. It will blacklist Kestrel servers for 60 seconds if there is an error or timeout. After the 60 seconds is up, it will try that server again.

By default, `KestrelThriftSpout` emits 1-tuples containing a byte array as its output. You can provide a `Scheme` to the KestrelSpout to deserialize those byte arrays into a tuple structure of your choosing. This library comes with a `StringScheme` that will UTF-decode the byte arrays into Java strings.

## Maven

storm-kestrel is hosted on the Clojars maven repo. To include it as a dependency in your project, add Clojars as a Maven repository to your pom.xml with the following snippet:

```xml
<repository>
  <id>clojars.org</id>
  <url>http://clojars.org/repo</url>
</repository>
```

Then, you can add storm-kestrel as a dependency like so:

```xml
<dependency>
  <groupId>storm</groupId>
  <artifactId>storm-kestrel</artifactId>
  <version>0.7.2-SNAPSHOT</version>
</dependency>
```

## Previous versions

Previous versions of this spout required a fork of Kestrel, since it modified the memcached protocol used for communication to enable guaranteed message processing. It is highly recommended you upgrade to Kestrel 2.2 and the latest version of this spout.
