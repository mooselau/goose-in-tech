package leetcode;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 * 
 * @author MooseLiu
 *
 */
public class MedianofTwoSortedArrays {
	
	public static void main(String[] args) {
		MedianofTwoSortedArrays mtsa = new MedianofTwoSortedArrays();
		int[] nums0 = {2, 1, 6, 4, 3, 5, 0};
		int[] nums1 = {1, 2};
		int[] nums2 = {3, 4};
//		mtsa.selectionSort(nums0);
		//double m = mtsa.findMedianSortedArrays(nums1, nums2);
		//System.out.println("Median: " + m);
		mtsa.doSearch(new int[] {1,2,3,5,6,7,8}, 6);
	}
	
	public void doSearch(int[] nums, int target) {
		// binary search
		binarySearch(nums, target, 0, nums.length - 1);
	}
	
	// time complexity: O(log2(m))
	public void binarySearch(int[] nums, int target, int low, int high) {
		
		int mid = (low + high) / 2;
		if (target > nums[mid]) {
			low = mid + 1;
		} else if (target < nums[mid]) {
			high = mid - 1;
		} else {
			System.out.println("target found, ind: " + mid);
			return ;
		}
		
		binarySearch(nums, target, low, high);
	}
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
    	int len1 = nums1.length, len2 = nums2.length;
    	int totalLen = len1 + len2;
    	int[] arr = new int[totalLen];
    	
    	// combine
    	int ind = 0;
    	for (int i=0;i<nums1.length;i++) {
    		arr[ind ++] = nums1[i];
    	}
    	for (int j=0;j<nums2.length;j++) {
    		arr[ind ++] = nums2[j];
    	}
    	
    	printArray(arr);
    	// sort
    	sortArray(arr);
    	
    	// calc
    	double median = 0;
    	if (totalLen % 2 == 0) {
    		int mid1 = arr[totalLen / 2];
    		int mid2 = arr[totalLen / 2 - 1];
    		median = (mid1 + mid2) * 1.0 / 2;
    	} else {
    		median = arr[totalLen / 2] * 1.0;
    	}
    	
		return median;
		
    }
    
    public void sortArray(int[] arr) {
    	bubbleSort(arr);
    }
    
    // time complexity: O(n^2)
    // select the greatest or the smallest
    public void selectionSort(int[] arr) {
    	int ind = 0, temp = 0, len = arr.length;
    	for (int i=0;i<arr.length;i++) { // loop for all - 1 largest nums
    		ind = 0;
    		for (int j=0;j<arr.length - i;j++) { // for all - i largest position
    			if (arr[j] > arr[ind]) {
    				ind = j;
    			}
    		}
    		
    		// swap the value
    		temp = arr[ind];
    		arr[ind] = arr[len - i -1]; 
    		arr[len - i - 1] = temp;
    	}
    	printArray(arr);
    }
    
    // Time complexity: O(n^2)
    public void bubbleSort(int[] arr) {
    	
    	int temp = 0;
    	for (int i=0;i<arr.length;i++) { // loop for n times
    		for (int j=0;j<arr.length - 1 - i;j++) { // loop for finding the largest
    			if ( arr[j] > arr[j+1]) {
    				temp = arr[j];
    				arr[j] = arr[j+1];
    				arr[j+1] = temp;
    			}
    		}
    	}
    	printArray(arr);
    }

	public void printArray(int[] nums) {
		for (int anum : nums) {
			System.out.print(anum + " ");
		}
		System.out.println();
	}
    
}
