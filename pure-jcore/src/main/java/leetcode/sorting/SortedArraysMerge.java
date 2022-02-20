package leetcode.sorting;

public class SortedArraysMerge {

    public static void main(String[] args) {
        SortedArraysMerge tester = new SortedArraysMerge();
        int[] c = tester.doSorting();
        for (int i : c) {
            tester.p(i + " ");
        }
    }

    public int[] doSorting() {
        int[] a = {1, 5, 7, 9};
        int[] b = {2, 3, 6, 11};

//        int[] a = {1, 2, 4, 5};
//        int[] b = {6, 11, 15};

//        int[] a = {12, 14, 18};
//        int[] b = {6, 7, 9, 11};
        return way0(a, b);
    }

    public int[] way0(int[] a, int[] b) {
        return null;
    }

    /*
     * This is standard solution to this problem
     */
    public int[] standardWay(int[] array1, int[] array2) {
        return Answers.sortedArraysMerge(array1, array2);
    }

    private void p(String msg) {
        System.out.print(msg);
    }
}
