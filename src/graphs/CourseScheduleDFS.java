package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 */
public class CourseScheduleDFS {
	static Map<Integer, List<Integer>> adjacencyList = new HashMap<Integer, List<Integer>>();
	static List<Integer> superVisited = new ArrayList<Integer>();
    
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        
    	// create the adjacency list
        for (int i = 0; i < prerequisites.length; i++) {
            int[] pair = prerequisites[i];
            int course = pair[0];
            int prereq = pair[1];
            
            if (adjacencyList.containsKey(course)) {
            	adjacencyList.get(course).add(prereq);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(prereq);
                adjacencyList.put(course,list);
            }           
        }
        
        Set<Integer> courses = adjacencyList.keySet();
        
        boolean ret = true;
        for (int course: courses) {
            if (!superVisited.contains(course)) {
                ret = ret && dfs(course, new HashSet<Integer>());
            }
        }
    
        System.out.println(superVisited);
        return ret;
    }
    
    // check for cycles
    private static boolean dfs (int course, Set<Integer> visited) {
        if (!visited.add(course))
            return false;
        
        
        List<Integer> prereqs = adjacencyList.get(course);
        if (prereqs == null) {
            if (!superVisited.contains(course)) 
            	superVisited.add(course);
        	
        	return true;
        }
        
        boolean ret = true;
        for (int p : prereqs)
            ret = ret && dfs (p, new HashSet<Integer>(visited));

        if (!superVisited.contains(course)) 
        	superVisited.add(course);
        
        return ret;
    }
    
	public static void main(String[] args) {
		int courses[][] = {{1,0},{2,0},{0,3},{3,4},{4,5},{4,6},{6,7},{7,5}};
		System.out.println(canFinish(8, courses));
	}

}
