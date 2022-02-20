package leetcode.sorting;

public class BubbleSorting {

    public static void main(String[] args) {
        BubbleSorting tester = new BubbleSorting();
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
        return Answers.bubbleSort(array);
    }

    public void p(String msg) {
        System.out.print(msg);
    }
}
