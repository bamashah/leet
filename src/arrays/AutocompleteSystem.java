package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author bamas
 *
 */
public class AutocompleteSystem {
    HashMap<String,Integer> map = new HashMap<> ();

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++)
            map.put(sentences[i], times[i]);
    }
    
    public List < String > input(char c) {
        String cur_sent = "";
        
        List<String> res = new ArrayList<> ();
        
        if (c == '#') {
            map.put(cur_sent, map.getOrDefault(cur_sent, 0) + 1);
            cur_sent = "";
        } else {
            List<Node> list = new ArrayList<> ();
            cur_sent += c;
            
            for (String key: map.keySet())
                if (key.indexOf(cur_sent) == 0) {
                    list.add(new Node(key, map.get(key)));
                }
            
            Collections.sort(list);
            
            for (int i = 0; i < Math.min(3, list.size()); i++)
                res.add(list.get(i).sentence);
        }
        
        return res;
    }

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Node implements Comparable<Node> {
    String sentence;
    int times;

    Node(String st, int t) {
        sentence = st;
        times = t;
    }

	@Override
	public int compareTo(Node n) {
		if (n.times == this.times) {
			return this.sentence.compareTo(n.sentence);
		} else if (this.times > n.times)
			return -1; // sort descending order
		else
			return 1;
	}
}

