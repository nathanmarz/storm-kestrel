package backtype.storm.drpc;

import backtype.storm.spout.KestrelClient;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONValue;


public class KestrelAdder implements SpoutAdder {
    KestrelClient _client;

    public KestrelAdder(String host, String port) {
        try {
            _client = new KestrelClient(host, Integer.parseInt(port));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(String function, String jsonArgs, String returnInfo) {
        Map val = new HashMap();
        val.put("args", jsonArgs);
        val.put("return", returnInfo);
        try {
            _client.queue(function, JSONValue.toJSONString(val));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
