package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a floating point number. 
 * Given some queries, return the answers. If the answer does not exist, return -1.0.
 * 
 * Given a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?  
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ]
 *
 */
public class Division {
	static Map<String, List<Pair>> adjacencyList = new HashMap<String, List<Pair>>();
	static double PROD = 0;
    
    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] retval = new double[queries.length];
        
    	// create the adjacency list
        for (int i = 0; i < equations.length; i++) {
            String[] eq = equations[i];
            String n = eq[0];
            String v = eq[1];
            
            Pair pair = new Pair (v, values[i]);
            if (adjacencyList.containsKey(n)) {
            	adjacencyList.get(n).add(pair);
            } else {
                List<Pair> list = new ArrayList<Pair>();
                list.add(pair);
                adjacencyList.put(n,list);
            }     
            
            Pair reversepair = new Pair (n, 1/values[i]);
            if (adjacencyList.containsKey(v)) {
            	adjacencyList.get(v).add(reversepair);
            } else {
                List<Pair> list = new ArrayList<Pair>();
                list.add(reversepair);
                adjacencyList.put(v,list);
            }             
        }        
        
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            PROD = -1.0;
            if (adjacencyList.containsKey(query[0]))
                recurse(query[0],query[1], new HashSet<String>(), 1.0);
            retval[i] = PROD;
        }
        
        return retval;
    }
    
    
    static private void recurse (String start, String end, Set<String> visited, double product) {
        if (start.equals(end)) {
            PROD = product;
        }
        
        if (!visited.add(start))
            return;
        
        List<Pair> nodes = adjacencyList.get(start);
        if (nodes == null) return;
        
        for (Pair node : nodes) {
            recurse (node.value, end, new HashSet<String>(visited), product*node.edge);
        }
        
    }  
	public static void main(String[] args) {
		String[][] equations = {{"a", "b"}, {"b", "c"}};
		double[] values = {2.0, 3.0};
		String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
		
		double[] result = calcEquation(equations, values, queries);
		
		for (double val : result)
			System.out.print(val + "  ");
	}

}

class Pair {
    String value;
    double edge;
    
    Pair (String value, double edge) {
        this.value = value;
        this.edge = edge;
    }   
}
