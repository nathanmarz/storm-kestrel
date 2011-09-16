Library to use Kestrel as a spout from within Storm. It also has an adapter to allow a DRPC server to enqueue DRPC requests to Kestrel. 

## Spout usage

The `KestrelSpout` in this library reads messages off of one or more Kestrel servers. When using the spout, it is recommended that you increase the parallelism of the spout to increase the rate at which you can read messages from Kestrel. 

The spout deals gracefully with any errors coming from Kestrel. It will blacklist Kestrel servers for 60 seconds if there is an error or timeout. After the 60 seconds is up, it will try that server again.

By default, `KestrelSpout` emits 1-tuples containing a byte array as its output. You can provide a `Scheme` to the KestrelSpout to deserialize those byte arrays into a tuple structure of your choosing. This library comes with a `StringScheme` that will UTF-decode the byte arrays into Java strings.

## As a DRPC adapter

`KestrelAdder` can be used with a DRPC server to allow the server to put DRPC requests onto a Kestrel queue. 
