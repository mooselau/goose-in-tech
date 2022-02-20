package leetcode.sorting;

public class MergeSort {
    public static void main(String[] args) {
        MergeSort tester = new MergeSort();
        int[] ret = tester.doSorting();
        for (int i : ret) {
            tester.p(i + " ");
        }
    }

    private int[] doSorting() {
        int[] rawArray = {3, 1, 5, 0, 6, 12, 79, 48, 50, 98, -1};
        way0(rawArray);
        return rawArray;
    }

    /*
     * For you to write
     */
    public void way0(int[] raw) {
        divideAndConquer(0, raw.length - 1, raw);
    }


    public void divideAndConquer(int left, int right, int[] array) {
        int middle = (left + right) / 2;
        if (left < right) {
            divideAndConquer(left, middle, array);
            divideAndConquer(middle + 1, right, array);
            merge(left, middle, right, array);
        }
    }

    private void merge(int left, int middle, int right, int[] array) {
        int[] newArray = new int[right - left + 1];
        // a < b
        if (array[middle] < array[middle + 1]) {
            int z = 0;
            for (int i = left; i < right + 1; i++) {
                newArray[z++] = array[i];
            }
            copyToArray(newArray, array, left);
            return ;
        }
        // a > b
        if (array[left] > array[right]) {
            int z = 0;
            for (int i = middle + 1; i < right + 1; i++) {
                newArray[z ++] = array[i];
            }
            for (int j = left; j < middle + 1; j++) {
                newArray[z ++] = array[j];
            }
            copyToArray(newArray, array, left);
            return ;
        }
        // otherwise
        int i = left;
        int j = middle + 1;
        for (int z = 0; z < newArray.length; z++) {
            if (i <= middle && j <= right) {
                newArray[z] = (array[i] > array[j])? array[j ++] : array[i ++];
            } else if (i > middle) {
                newArray[z] = array[j ++];
            } else {
                newArray[z] = array[i ++];
            }
        }
        copyToArray(newArray, array, left);
    }

    private void copyToArray(int[] a, int[] b, int start) {
        for (int i=0; i<a.length; i++) {
            b[start + i] = a[i];
        }
    }

    /*
     * This is standard solution to this problem
     */
    public int[] standardWay(int[] array) {
        return Answers.mergeSort(array);
    }

    public void p(String msg) {
        System.out.print(msg);
    }
}
