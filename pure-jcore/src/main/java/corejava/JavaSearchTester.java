package corejava;

public class JavaSearchTester {
	
	public static void main(String[] args) {
		JavaSearchTester tester = new JavaSearchTester();
		tester.binarySearch();
	}
	
	public void binarySearch() {
		int[] array = {1, 2, 3, 4, 5, 6};
		int target = 7;
		doSearching(array, 0, array.length - 1, target);
	}
	
	private boolean doSearching(int[] array, int left, int right, int target) {
		
		// special case
		if (right < left) {
			p("target is not found, as right < left");
			return false;
		}
		
		int mid = (left + right) / 2;
		
		p("mid: " + mid);
		if (array[mid] == target) {
			p("Target found.");
			return true;
		} else if (array[mid] > target) {
			p("target is smaller than mid");
			return doSearching(array, left, mid - 1, target);
		} else if (array[mid] < target) {
			p("target is larger than mid");
			return doSearching(array, mid + 1, right, target);
		}
		
		p("target is not found.");
		return false;
	}
	
	private void p(String msg)  {
		System.out.println(msg);
	}
}
