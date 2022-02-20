package leetcode.sorting;

public class SelectionSorting {
    public static void main(String[] args) {
        SelectionSorting tester = new SelectionSorting();
        int[] ret = tester.doSorting();
        for (int i : ret) {
            tester.p(i + " ");
        }
    }

    private int[] doSorting() {
        int[] rawArray = {8, 1, 5, 0, 3, 2};
        return way0(rawArray);
    }

    /*
     * For you to write
     */
    public int[] way0(int[] raw) {
        return raw;
    }

    /*
     * This is standard solution to this problem
     */
    public int[] standardWay(int[] array) {
        return Answers.selectionSort(array);
    }

    public void p(String msg) {
        System.out.print(msg);
    }
}
