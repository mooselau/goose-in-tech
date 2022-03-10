package leetcode;

/**
 * 1. Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * link: https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

	public static void main(String[] args) {
		TwoSum tim = new TwoSum();
		int[] ret = tim.solve();
		p("Index is: \n");
		for (int i : ret) {
			p(i + " ");
		}
	}

	public int[] solve() {
		int[] nums = {2, 11, 15, 7};
		int target = 26;
		return way0(nums, target);
	}

	/*
	 * For you to write
	 */
	public int[] way0(int[] nums, int target) {
		return null;
	}

	/*
	 * This is standard solution to this problem
	 */
	public int[] standardWay(int[] array, int target) {
		return Answers.twoSum(array, target);
	}

	private static void p(String msg) {
		System.out.print(msg + "");
	}

}
