

import java.util.HashMap;
import java.util.Map;

public class Day7 {
    /**
     * Problem: Range Sum Query 2D

     */
    static class NumMatrix {
        private final int[][] prefix;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                prefix = new int[0][0];
                return;
            }

            int rows = matrix.length;
            int cols = matrix[0].length;
            prefix = new int[rows + 1][cols + 1];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    prefix[i + 1][j + 1] = matrix[i][j]
                            + prefix[i][j + 1]
                            + prefix[i + 1][j]
                            - prefix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (prefix.length == 0 || prefix[0].length == 0) {
                return 0;
            }
            return prefix[row2 + 1][col2 + 1]
                    - prefix[row1][col2 + 1]
                    - prefix[row2 + 1][col1]
                    + prefix[row1][col1];
        }
    }

    /**
     * Problem: Subarray Sum Equals K

     */
    public static int subarraySumEqualsK(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;
            int needed = prefixSum - k;
            count += prefixCount.getOrDefault(needed, 0);
            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    /**
     * Problem: Longest Subarray With Sum K

     */
    public static int longestSubarrayWithSumK(int[] nums, int k) {
        Map<Integer, Integer> firstSeen = new HashMap<>();
        firstSeen.put(0, -1);

        int prefixSum = 0;
        int longest = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int needed = prefixSum - k;
            if (firstSeen.containsKey(needed)) {
                longest = Math.max(longest, i - firstSeen.get(needed));
            }
            firstSeen.putIfAbsent(prefixSum, i);
        }
        return longest;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 3, 2}
        };

        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println("2D range sum query: " + numMatrix.sumRegion(1, 1, 2, 3));
        System.out.println("2D range sum query: " + numMatrix.sumRegion(0, 0, 3, 3));

        int[] nums = {1, 1, 1};
        System.out.println("Subarray sum equals K: " + subarraySumEqualsK(nums, 2));

        int[] arr = {1, 2, 1, 0, 1, 1, 1};
        System.out.println("Longest subarray with sum K: " + longestSubarrayWithSumK(arr, 3));
    }
}