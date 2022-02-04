package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import graphs.GraphNode;

public class Graph {
		
	static void breadthFirstSearch (GraphNode root) {
		//uses iteration
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			//printQueue(queue);
			GraphNode node = queue.remove();
			
			if (!node.visited) {  //for cycle avoidance
				visit(node);
			
				if (node.connections != null) {
					for (GraphNode n : node.connections) {
						queue.add(n);
					}
				}
			}
		}
	
	}
	
	
	static void findPathBFS (GraphNode start, GraphNode end, ArrayList<GraphNode> path) {
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		start.path.add(start.val);
		queue.add(start);
		boolean found = false;
		
		while (!queue.isEmpty() && !found) {
			GraphNode node = queue.remove();			
			
			if (!node.visited) {  //for cycle avoidance
				node.visited = true;
				if (node.connections != null) {
					for (GraphNode n : node.connections) {

						if (n.path.isEmpty()) {
							n.path.addAll(node.path);
							n.path.add(n.val);
						}
						
						if (n == end) {
							System.out.println(n.path);
							found = true;
							break;
						}
						
						queue.add(n);
					}
				}
			}
		}
	}	
	
	@SuppressWarnings("unused")
	private static void printQueue (Queue<GraphNode> queue) {
		System.out.print ("Queue: ");
		for (GraphNode node : queue) {
			System.out.print(node.val + " ");
		}
		System.out.println();
	}
	
	static void depthFirstSearch (GraphNode root) {
		//uses recursion
		
		if (root != null) {
			visit(root);
			
			if (root.connections.size() > 0) {
				for (GraphNode connection : root.connections) {
					if (!connection.visited) {
						depthFirstSearch (connection);
					}
				}
			}
		}
	}

	private static void visit (GraphNode node) {
		node.visited = true;
		System.out.print (node.val + " ");
	}
	
	public static void findPathDFS (GraphNode x, GraphNode y, ArrayList<GraphNode> path) {
		// uses dfs
		path.add(x);
		x.visited = true;
		
		if (x == y) {
			for (GraphNode node : path ) {
				System.out.print(node.val + " ");
			}
			return;
		}
		
		for (GraphNode node : x.connections ) {
			ArrayList<GraphNode> a = new ArrayList<GraphNode>(path);
			if (!node.visited)
				findPathDFS(node, y, a);
		}
	}
	
	public static void main(String[] args) {

		// create the graph. see tree.png to see what the tree looks like.
		GraphNode a = new GraphNode('a');
		GraphNode b = new GraphNode('b');
		GraphNode c = new GraphNode('c');
		GraphNode d = new GraphNode('d');
		GraphNode e = new GraphNode('e');
		GraphNode f = new GraphNode('f');
		GraphNode g = new GraphNode('g');
		GraphNode h = new GraphNode('h');
		GraphNode i = new GraphNode('i');
		GraphNode j = new GraphNode('j');
		
		a.addConnection(b);
		a.addConnection(j);
		b.addConnection(c);
		b.addConnection(d);
		b.addConnection(e);
		b.addConnection(h);
		c.addConnection(i);
		c.addConnection(d);
		d.addConnection(e);
		d.addConnection(f);
		f.addConnection(g);
		g.addConnection(c);
		h.addConnection(e);
		h.addConnection(g);
		h.addConnection(j);
		i.addConnection(g);
		
		//depthFirstSearch(a);
		//breadthFirstSearch(a);
		findPathBFS(a, f, new ArrayList<GraphNode>());
		//findPathDFS(a, f, new ArrayList<GraphNode>());
	}

}
