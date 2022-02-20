package leetcode.sorting;

public class InsertSorting {
    public static void main(String[] args) {
        InsertSorting tester = new InsertSorting();
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
        for (int i = 0; i < raw.length; i++) {
            int a = raw[i];
            int pos = 0;
            for (int j = 0; j < i; j++) {
                int b = raw[j];
                if (a > b) {
                    pos = j + 1;
                } else if (a < b) {
                    pos = j;
                    break;
                } else {
                    pos = j;
                }
            }
            for (int z = i - 1; z >= pos; z--) {
                raw[z + 1] = raw[z];
            }
            raw[pos] = a;
        }
        return raw;
    }

    // use binary search
    public int[] way1(int[] raw) {
        return raw;
    }

    /*
     * This is standard solution to this problem
     */
    public int[] standardWay(int[] array) {
        return Answers.insertSort(array);
    }

    public void p(String msg) {
        System.out.print(msg);
    }
}
