package graphs;

import java.util.ArrayList;
import java.util.List;

import graphs.GraphNode;

/*
 * A node in a graph
 */
public class GraphNode {
	char val;
	List<GraphNode> connections;
	boolean visited;
	List<Character> path;
	
	public GraphNode(char val) {
		this.val = val;
		connections = new ArrayList<GraphNode>();
		visited = false;
		path = new ArrayList<Character>();		
	}

	public void addConnection (GraphNode connection) {
		connections.add(connection);
	}
	
}
