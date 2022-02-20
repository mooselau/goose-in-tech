package leetcode;

/**
 * 26. Remove Duplicates from Sorted Array
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return
 * the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1)
 * extra memory.
 * <p>
 * Example 1:
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the returned length.
 * <p>
 * Example 2:
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4
 * respectively.
 * It doesn't matter what values are set beyond the returned length.
 * <p>
 * Clarification:
 * Confused why the returned value is an integer but your answer is an array?
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 * <p>
 * Internally you can think of this:
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 * <p>
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 */
public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray tim = new RemoveDuplicatesfromSortedArray();
        int ret = tim.removeDuplicates();
        tim.p("length: " + ret);
    }

    /*
     * Function entry in Leet Code
     */
    public int removeDuplicates() {
//        int[] nums = {1, 2, 2, 3, 4, 5};
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
      int[] nums = {1};
        int len = way1(nums);
        for (int a : nums) {
            p(a + " ");
        }
        return len;
    }

    /*
     * For you to write
     */
    public int way1(int[] nums) {
    	return 0;
    }

    /*
     * This is standard solution to this problem
     */
    public int standardWay(int[] nums) {
        return Answers.RemoveDuplicatesfromSortedArray(nums);
    }

    public void p(String msg) {
        System.out.print(msg);
    }
}

