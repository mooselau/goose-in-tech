package leetcode;

public class Nomura {
    public static void main(String[] args) {
        Nomura n = new Nomura();
        n.entrypoint();
    }

    public void entrypoint() {
        int[] a = {3, 5, 6, 3, 3, 5};
        p(solution3(a) + "");
//        for (int t : a) {
//            p(t + "");
//        }
    }

    public int solution3(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    if (count >= 1000000000) {
                        // largest count
                        return 1000000000;
                    }
                    count ++;
                }
            }
        }
        return count;
    }

    /**
     * int[] a = {6, 10, 6, 9, 7, 8};
     * @param nums
     * @return
     */
    public int solution2(int[] nums) {
        int maxLen = 0;
        int tempLenAbove = 0; // find [a, a+1]
        int tempLenBelow = 0; // find [a-1, a]
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            tempLenAbove = getQuasiconstantLength(a, a + 1, nums);
            tempLenBelow = getQuasiconstantLength(a-1, a, nums);
            if (tempLenAbove > maxLen) {
                maxLen = tempLenAbove;
            } else if (tempLenBelow > maxLen) {
                maxLen = tempLenBelow;
            }
        }
        return maxLen;
    }

    private int getQuasiconstantLength(int small, int great, int[] nums) {
        int tempLen = 0;
        for (int j = 0; j < nums.length; j++) {
            int b = nums[j];
            if (b == small || b == great) {
                tempLen ++;
            }
        }
        return tempLen;
    }

    /**
     * //        int[] a = {30, 20, 10};
     * //        int[] a = {2, 2, 2, 2, 1, 2, -1, 2, 1, 2, 3};
     *
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        int index = 0;
        int maxLen = 1;
        int tempIndex = 0;
        int tempLen = 1;
        boolean continuing = false;
        for (int i = 0; i < nums.length - 1; ) {
            if (nums[i + 1] > nums[i]) {
                if (!continuing) {
                    tempIndex = i;
                    continuing = true;
                }
                tempLen++;
                i++;
            } else {
                if (continuing) {
                    continuing = false;
                }
                if (tempLen > maxLen) {
                    maxLen = tempLen;
                    index = tempIndex;
                }
                tempIndex = 0;
                tempLen = 1;
                i++;
            }
        }
        // last judge
        if (continuing) {
            if (tempLen > maxLen) {
                maxLen = tempLen;
                index = tempIndex;
            }
        }
        return index;
    }

    /**
     * //        int[] a = {1, 3, 6, 4, 1, 2};
     * //        int[] a = {1, 2, 3};
     *
     * @param nums
     * @return
     */
    public int solutionTest(int[] nums) {
        int target = 0;
        sort(nums);
        for (int i = 1; i <= 1000000; i++) {
            if (i > nums.length) {
                target = i;
                break;
            }
            if (!bs(0, nums.length - 1, i, nums)) {
                target = i;
                break;
            }
        }
        return target;
    }

    private int[] sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int max = 0;
            for (int j = 0; j < (len - i); j++) {
                int a = arr[j];
                int b = arr[max];
                if (a > b) {
                    max = j;
                }
            }
            int pos = len - 1 - i;
            if (pos != max) {
                int temp = arr[max];
                arr[max] = arr[pos];
                arr[pos] = temp;
            }
        }
        return arr;
    }

    private boolean bs(int left, int right, int target, int[] nums) {
        int middle = (left + right) / 2;
        int midValue = nums[middle];
        if (midValue == target) {
            return true;
        }
        if (left == right) {
            return false;
        }
        if (midValue > target) {
            return bs(left, middle, target, nums);
        } else {
            return bs(middle + 1, right, target, nums);
        }
    }

    private void p(String msg) {
        System.out.println(msg);
    }
}
