package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {
    Map<String, TreeMap<Integer, String>> map;
    
    /** Initialize your data structure here. */
    public TimeBasedKeyValueStore() {
        map = new HashMap<String, TreeMap<Integer, String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            TreeMap<Integer, String> treemap = map.get(key);
            treemap.put(timestamp, value);
        } else {
            TreeMap<Integer, String> treemap = new TreeMap<Integer, String>();
            treemap.put(timestamp, value);
            map.put(key, treemap);
        }
    }
    
    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            TreeMap<Integer, String> treemap = map.get(key);
            Integer ts = treemap.floorKey(timestamp);
            if (ts == null)
                return "";
            else
                return treemap.get(ts);
        } else
            return "";
    }
    
	public static void main(String[] args) {
		TimeBasedKeyValueStore kv = new TimeBasedKeyValueStore();   
		kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1   
		System.out.println(kv.get("foo", 1));  // output "bar"   
		System.out.println(kv.get("foo", 3)); // output "bar" since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 ie "bar"   
		kv.set("foo", "bar2", 4);   
		System.out.println(kv.get("foo", 4)); // output "bar2"   
		System.out.println(kv.get("foo", 5)); //output "bar2"   
	}

}
