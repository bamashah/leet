package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * Find all subsets of an array of numbers
 * 
 * There is also an iterative solution under arrays.
 */
public class Subsets {
	static List<List<Integer>> list = new ArrayList<>();

	public static List<List<Integer>> subsets(int[] nums) {
		recurse (0, nums, new ArrayList<>());
		return list;
	}

	public static void recurse (int start, int[] nums, List<Integer> arr) {
		if (start == nums.length) {
			list.add(arr);
			return;
		}

		recurse (start + 1, nums, new ArrayList(arr));
		arr.add(nums[start]);
		recurse (start + 1, nums, new ArrayList(arr));
	}
		
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		List<List<Integer>> list = subsets(arr);
		System.out.println(list);
	}

}
