package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class StackUsingArrayList {

    /** initialize your data structure here. */
    List<Integer> list;
    List<Integer> min;
    
    
    public StackUsingArrayList() {
        list = new ArrayList<Integer>();
        min = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        list.add(x);
        
        int currentmin = getMin();
        if (x < currentmin) 
            min.add(x);
        else 
            min.add(currentmin);

    }
    
    public void pop() {
        int size = list.size();
        list.remove(size-1);
        min.remove(size-1);
    }
    
    public int top() {
        int size = list.size();
        return list.get(size-1);        
    }
    
    public int getMin() {
        int size = min.size();       
        if (size == 0)
            return Integer.MAX_VALUE;
        else
            return min.get(size-1);        
    }
	
	public static void main(String[] args) {
		StackUsingArrayList minStack  = new StackUsingArrayList();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());   // Returns -3.
		minStack.pop();
		System.out.println(minStack.top());      // Returns 0.
		System.out.println(minStack.getMin());   // Returns -2.
	}

}
