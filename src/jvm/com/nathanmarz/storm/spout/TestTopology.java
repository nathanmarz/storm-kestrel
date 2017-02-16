package com.nathanmarz.storm.spout;

import com.nathanmarz.storm.scheme.StringScheme;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;

import java.util.Map;


public class TestTopology {
    public static class FailEveryOther extends BaseRichBolt {
        
        OutputCollector _collector;
        int i=0;
        
        @Override
        public void prepare(Map map, TopologyContext tc, OutputCollector collector) {
            _collector = collector;
        }

        @Override
        public void execute(Tuple tuple) {
            i++;
            if(i%2==0) {
                _collector.fail(tuple);
            } else {
                _collector.ack(tuple);
            }
        }
        
        @Override
        public void declareOutputFields(OutputFieldsDeclarer declarer) {
        }
    }
    
    public static void main(String[] args) throws Exception {
        TopologyBuilder builder = new TopologyBuilder();
        KestrelThriftSpout spout = new KestrelThriftSpout("localhost", 2229, "test", new StringScheme());
        builder.setSpout("spout", spout).setDebug(true);
        builder.setBolt("bolt", new FailEveryOther())
                .shuffleGrouping("spout");
        
        LocalCluster cluster = new LocalCluster();
        Config conf = new Config();
        cluster.submitTopology("test", conf, builder.createTopology());
        
        Thread.sleep(600000);
    }
}
