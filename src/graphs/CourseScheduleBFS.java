package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 */
public class CourseScheduleBFS {
	
	/*
	 * Solution using Kahn’s algorithm for Topological Sorting
	 * The first node in the topological ordering will be the node that doesn't have any incoming edges. 
	 * Essentially, any node that has an in-degree of 0 can start the topologically sorted order. 
	 * If there are multiple such nodes, their relative order doesn't matter and they can appear in any order.
	 */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
    	Map<Integer, List<Integer>> adjacencyList = new HashMap<Integer, List<Integer>>();
    	int[] indegree = new int[numCourses];
        
    	// create the adjacency list
        for (int i = 0; i < prerequisites.length; i++) {
            int[] pair = prerequisites[i];
            int course = pair[0];
            int prereq = pair[1];
            indegree[prereq]++;
            
            if (adjacencyList.containsKey(course)) {
            	adjacencyList.get(course).add(prereq);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(prereq);
                adjacencyList.put(course, list);
            }
                        
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
		List<Integer> visited = new ArrayList<Integer>();
        
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        
        while (!q.isEmpty()) {
            int c = q.remove();
            visited.add(c);
                
            List<Integer> prereqs = adjacencyList.get(c);
            if (prereqs == null) continue;
            
            for (int p : prereqs) {
            	indegree[p] = Math.max(0, indegree[p]-1);
                if (indegree[p] == 0)
                    q.add(p);                 
            }
            
        }        
        
        if (visited.size() == numCourses) {
        	Collections.reverse(visited);
        	System.out.println(visited);
            return true;
        } else
            return false;  // there was a cycle
    }

	public static void main(String[] args) {
		int courses[][] = {{1,0},{2,0},{0,3},{3,4},{4,5},{4,6},{6,7},{7,5}};
		//int courses[][] = {{1,0}};
		System.out.println(canFinish(8, courses));
	}

}






