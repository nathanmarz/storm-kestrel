rm -rf gen-javabean
rm -rf jvm/net/lag/kestrel/thrift
thrift7 --gen java:beans,hashcode,nocamel kestrel.thrift
mv gen-javabean/net/lag/kestrel/thrift jvm/net/lag/kestrel/thrift
rm -rf gen-javabean
