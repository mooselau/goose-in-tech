package leetcode.sorting;

public class Answers {
	
	/* in ascend order */
	
	/*
	 * Time Complexity: O(n^2), Space Complexity: O(1). 
	 */
	public static int[] bubbleSort(int[] arr) {
		int len = arr.length;
		// for n times, one correct number at one time
		for(int i=0; i<len; i++) {
			// for m times, each time traverse from the 0 to (length - 1 - i).
			for (int j=0; j<(len - 1 - i); j++) {
				int a = arr[j];
				int b = arr[j + 1];
				
				if (a > b) {
					// swap
					swap(arr, j, j+1);
				}
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] raw = {3, 1, 5, 0, 6, 12, 79, 48, 50, 98, -1};
		int[] ret = insertSort(raw);
		for (int i : ret) {
			System.out.print(i + " ");
		}
	}
	
	/*
	 * Selection Sort has almost same logic but different perspective from bubble sort.
	 * Time: O(n^2), Space: O(1).
	 */
	public static int[] selectionSort(int[] arr) {
		int len = arr.length;
		// for n times, one correct number at one time
		for (int i=0; i<len; i++) {
			int max = 0;
			// for m times, each time traverse from the 0 to the (length -1 -i).
			for (int j=0; j<(len - i); j++) {
				int a = arr[j];
				int b = arr[max];
				if (a > b) {
					max = j;
				}
			}
			// swap max and the position
			int pos = len - 1 - i;
			if (pos != max) {
				swap(arr, max, pos);
			}
		}
		return arr;
	}
	
	/*
	 * Like playing cards.
	 * Time: O(n^2), Space: O(1);
	 */
	public static int[] insertSort(int[] arr) {
		int len = arr.length;
		// for (n-1) times, one correct number at each time
		for (int i=1; i<len; i++) {
			int curr = arr[i];
			/* sorted array part is from 0 to (i-1) */
			int insertPos = i;
			for (int j=0; j<i; j++) {
				int a = arr[j];
				int b = arr[j + 1];
				// special case
				if (j == 0 && curr < a) {
					insertPos = 0;
					break;
				}
				// normal case
				if (curr >= a && curr < b) {
					insertPos = j + 1;
					break;
				}
			}
			/* right shift the part from insert position to (i-1) */
			for (int j=i; j>insertPos; j--) {
				arr[j] = arr[j-1];
			}
			/* insert */
			arr[insertPos] = curr;
		}
		return arr;
	}
	
	public static int[] mergeSort(int[] array) {
		divideAndConquer(array, 0, array.length - 1);
		return array;
	}

	private static void divideAndConquer(int[] arr, int start, int end) {
		int left = start, right = end;
		int mid = (left + right) / 2; // mid is the middle of total (left, right)
		if (start < end) {
			// sort left side
			divideAndConquer(arr, left, mid);
			// sort right side
			divideAndConquer(arr, mid + 1, right);
			// merge two sorted arrays
			merge(arr, left, right, mid);
		}
	}

	private static void merge(int[] arr, int left, int right, int mid) {
		// Firstly, making two temp arrays
		int lenL = mid - (left - 1);
		int[] tempL = new int[lenL];
		int tempIndex = 0;
		// NOTE: this could be [left, mid]
		for (int i=left; i<=mid; i++) {
			tempL[tempIndex ++] = arr[i];
		}

		int lenR = right - mid;
		int[] tempR = new int[lenR];
		tempIndex = 0;
		// NOTE: this could be [mid+1, right]
		for (int i=mid+1; i<=right; i++) {
			tempR[tempIndex ++] = arr[i];
		}

		// Secondly, sort these two sub sorted arrays
		int index = left;
		boolean aEnd = false, bEnd = false;
		for (int i=0, j=0; !aEnd || !bEnd;) {
			aEnd = (i>=lenL);
			bEnd = (j>=lenR);

			// this means A must NOT ends, B must ends, or, a is smaller than b only if they both not end.
			if ((!aEnd && bEnd) || (!aEnd && !bEnd) && (tempL[i] <= tempR[j])) {
				arr[index ++] = tempL[i ++];
			} else if ((aEnd && !bEnd) || (!aEnd && !bEnd) && (tempL[i] > tempR[j])) {
				arr[index ++] = tempR[j ++];
			}
		}
	}

	public static int[] quickSort(int[] array) {
		return new int[] {};
	}

	public static int[] sortedArraysMerge(int[] array1, int[] array2) {
		return sortSortedArrays(array1, array2);
	}

	/*
	 * Time: O(n), Space: O(n).
	 */
	private static int[] sortSortedArrays(int[] a, int[] b) {
		int lena = a.length;
		int lenb = b.length;

		int[] c = new int[lena + lenb];
		// a < b
		if (a[lena - 1] < b[0]) {
			for (int i = 0; i < lena; i++) {
				c[i] = a[i];
			}
			for (int j = 0; j < lenb; j++) {
				c[j + lena] = b[j];
			}
			return c;
		}
		// a > b
		if (a[0] > b[lenb - 1]) {
			for (int i = 0; i < lenb; i++) {
				c[i] = b[i];
			}
			for (int j = 0; j < lena; j++) {
				c[j + lenb] = a[j];
			}
			return c;
		}
		// otherwise
		int x = 0;
		int y = 0;
		for (int z = 0; z < c.length; z++) {
			if (x < lena && y < lenb) {
				c[z] = (a[x] > b[y]) ? b[y++] : a[x++];
			} else if (x >= lena) {
				c[z] = b[y++];
			} else {
				c[z] = a[x++];
			}
		}
		return c;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
