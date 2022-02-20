package leetcode.sorting;

public class ClassicSearching {

    public static void main(String[] args) {
        ClassicSearching searching = new ClassicSearching();
        int ret = searching.doSearch();
        p("Position is at: " + ret);
    }

    public int doSearch() {
        int[] rawArray = {3, 1, 5, 0, 6, 12, 79, 48, 50, 98, -1};
        int target = -1;
        return way1(rawArray, target);
    }

    /**
     * Linear search
     *
     * @param target
     * @return
     */
    private int way0(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        throw new RuntimeException("Target value not found!");
    }

    /**
     * Binary search
     *
     * @param target
     * @return
     */
    private int way1(int[] array, int target) {
        return binarySearch(0, array.length - 1, target, array);
    }

    private int binarySearch(int left, int right, int target, int[] array) {
        int middle = (left + right) / 2;
        int midValue = array[middle];
        if (midValue == target) {
            return middle;
        }
        if (left == right) {
            throw new RuntimeException("Target value not found!");
        }
        if (midValue > target) {
            return binarySearch(left, middle, target, array);
        } else {
            return binarySearch(middle + 1, right, target, array);
        }
    }

    public static void p(String msg) {
        System.out.print(msg + " ");
    }

}
