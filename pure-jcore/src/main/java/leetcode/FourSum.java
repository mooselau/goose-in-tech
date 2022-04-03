package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Advanced version of TwoSum.
 * 1. all combinations to calculate the target value with two indexes, put in the result 2d array;
 * 2. all combinations to calculate the target value with three indexes, put in the result 2d array;
 * 3. all combinations to calculate the target value with four indexes, put in the result 2d array;
 * 4. each combination has to be unique, no duplicate index in all groups;
 */
public class FourSum {

    public static void main(String[] args) {
        FourSum tim = new FourSum();
        int[][] ret = tim.entrypoint();
        p("Index is: \n");

        int len1 = ret.length;
        p("[ ");
        for (int i = 0; i < len1; i++) {
            int len2 = ret[i].length;
            p("[");
            for (int j = 0; j < len2; j++) {
                p(ret[i][j] + "");
                if (j != len2 - 1) {
                    p(" ");
                }
            }
            p("] ");
        }
        p("]");
    }

    public int[][] entrypoint() {
        int[] nums = { -3, -2, -1, 1, 3, 5, 11, 12 };
        int target = 7;
        // int[] nums = { -2, 2, 11, 15, 7 };
        // int target = 9;

        return fourSumsAll(nums, target);
        // return threeSumsAll(nums, target);
        // return twoSumsAll(nums, target);
        // return new int[][] {};
    }

    /**
     * all combinations with four indexes in 2d array.
     */
    public int[][] fourSumsAll(int[] nums, int target) {
        int len = nums.length;

        List<List<int[]>> resultList = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            int four = nums[i];
            int threeSumsTarget = target - four;
            for (int j = i + 1; j < len - 1; j++) {
                int third = nums[j];
                int pairTarget = threeSumsTarget - third;

                List<int[]> listOf4Indexes = fourSums_WithGivenIndexes(nums, pairTarget, j, i);
                if (!listOf4Indexes.isEmpty()) {
                    resultList.add(listOf4Indexes);
                }
            }
        }

        return convertListTo2dArrayWithEachOf4Elements(resultList);
    }

    /**
     * all combinations in list of three indexes in 1d array
     */
    public List<int[]> fourSums_WithGivenIndexes(int[] nums, int target, int thirdIndex, int fourIndex) {
        int len = nums.length;
        if (thirdIndex >= len) {
            throw new IllegalArgumentException(String.format("Wrong FROMINDEX[%d]", thirdIndex));
        }

        // store 1d arrays
        List<int[]> resultList = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int fromIndex = thirdIndex + 1;
        for (int i = fromIndex; i < len; i++) {
            int current = nums[i];
            int compliment = target - current;

            if (hashMap.containsKey(compliment)) {
                resultList.add(new int[] { fourIndex, thirdIndex, hashMap.get(compliment), i });
            } else {
                hashMap.put(current, i);
            }
        }
        return resultList;
    }

    /**
     * Convert List of int[4] to 2d array with each containing 4 elements.
     */
    private int[][] convertListTo2dArrayWithEachOf4Elements(List<List<int[]>> fullList) {
        int totalSize = 0;
        for (List<int[]> subList : fullList) {
            totalSize += subList.size();
        }

        int[][] results = new int[totalSize][4];
        int i = 0;
        for (List<int[]> subList : fullList) {
            for (int[] pair : subList) {
                results[i][0] = pair[0];
                results[i][1] = pair[1];
                results[i][2] = pair[2];
                results[i][3] = pair[3];
                i++;
            }
        }

        return results;
    }

    /**
     * all combinations with three indexes in 2d array.
     */
    public int[][] threeSumsAll(int[] nums, int target) {
        int len = nums.length;

        List<List<int[]>> resultList = new ArrayList<>();
        for (int i = 0; i < len - 1; i++) {
            int third = nums[i];
            int pairTarget = target - third;

            List<int[]> listOf3Indexes = threeSums_WithGivenIndex(nums, pairTarget, i);
            resultList.add(listOf3Indexes);
        }

        return convertListTo2dArrayWithEachOf3Elements(resultList);
    }

    /**
     * Convert List of int[3] to 2d array with each containing 3 elements.
     */
    private int[][] convertListTo2dArrayWithEachOf3Elements(List<List<int[]>> fullList) {
        int totalSize = 0;
        for (List<int[]> subList : fullList) {
            totalSize += subList.size();
        }

        int[][] results = new int[totalSize][3];
        int i = 0;
        for (List<int[]> subList : fullList) {
            for (int[] pair : subList) {
                results[i][0] = pair[0];
                results[i][1] = pair[1];
                results[i][2] = pair[2];
                i++;
            }
        }

        return results;
    }

    /**
     * all combinations in list of three indexes in 1d array
     */
    public List<int[]> threeSums_WithGivenIndex(int[] nums, int target, int givenIndex) {
        int len = nums.length;
        if (givenIndex >= len) {
            throw new IllegalArgumentException(String.format("Wrong FROMINDEX[%d]", givenIndex));
        }

        // store 1d arrays
        List<int[]> resultList = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int fromIndex = givenIndex + 1;
        for (int i = fromIndex; i < len; i++) {
            int current = nums[i];
            int compliment = target - current;

            if (hashMap.containsKey(compliment)) {
                resultList.add(new int[] { givenIndex, hashMap.get(compliment), i });
            } else {
                hashMap.put(current, i);
            }
        }
        return resultList;
    }

    /**
     * all combinations with two indexes in 2d array
     */
    public int[][] twoSumsAll(int[] nums, int target) {
        // store 1d arrays
        List<int[]> resultList = new ArrayList<>();
        int len = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int current = nums[i];
            int compliment = target - current;

            if (hashMap.containsKey(compliment)) {
                resultList.add(new int[] { hashMap.get(compliment), i });
            } else {
                hashMap.put(current, i);
            }
        }

        // convert list of int[] to 2d array
        return convertListTo2dArrayWithEachOf2Elements(resultList);
    }

    /**
     * Convert List of int[2] to 2d array with each containing 2 elements.
     */
    private int[][] convertListTo2dArrayWithEachOf2Elements(List<int[]> list) {
        int[][] results = new int[list.size()][2];
        int i = 0;
        for (int[] pair : list) {
            results[i++] = pair;
        }
        return results;
    }

    private static void p(String msg) {
        System.out.print(msg + "");
    }

}
