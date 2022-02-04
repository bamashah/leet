package stack;

import java.util.Stack;

/*
 * Given a stack of integers of size n, you have to sort it using only push and pop operations.
 * You are not allowed to copy the numbers in auxiliary array and sort it and then push back in array.
 * 
 * The solution here is the first pop all the elements out of the stack and store them in the memory heap,
 * Then do insertion sort
 */
public class PushAndPopSort {
	
	static void sort(Stack<Integer> stack) {
		if (!stack.isEmpty()) {
			int temp = stack.pop();
			sort(stack);
			insert(stack, temp);
		}
	}
	
	static void insert(Stack<Integer> stack, int element) {
		if (stack.isEmpty() || (element < stack.peek())) {
			stack.push(element);
		} else {
			int temp = stack.pop();
			insert (stack, element);
			stack.push(temp);
		}
		
		//print(stack);
	}

	static void print(Stack<Integer> stack) {
		System.out.println (stack);		
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(7);
		stack.push(4);
		stack.push(9);
		stack.push(1);
		stack.push(2);
		print(stack);
		sort(stack);
		print(stack);
	}

}
