import java.util.Arrays;

public class Day5 {
    /**
     * Problem: Prefix Sum and Balance Problems
     * Description: Demonstrates prefix sums, range sums, suffix sums, equilibrium index, and pivot index techniques.
     * Time Complexity: Varies by example
     * Space Complexity: Varies by example
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        int[] prefix = prefixSum(arr);
        System.out.println("Prefix sum: " + Arrays.toString(prefix));

        int left = 1;
        int right = 3;
        System.out.println("Range sum (" + left + ", " + right + "): " + rangeSum(prefix, left, right));

        int[] suffix = suffixSum(arr);
        System.out.println("Suffix sum: " + Arrays.toString(suffix));

        int[] eqArr = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println("Equilibrium index: " + equilibriumIndex(eqArr));

        int[] pivotArr = {1, 7, 3, 6, 5, 6};
        System.out.println("Pivot index: " + pivotIndex(pivotArr));
    }

    /**
     * Problem: Prefix Sum Array
     * Description: Builds an array where each element stores the sum of all previous values.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    private static int[] prefixSum(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        return prefix;
    }

    /**
     * Problem: Range Sum Query
     * Description: Answers the sum of a subarray in O(1) time using a prefix sum array.
     * Time Complexity: O(1)
     * Space Complexity: O(n)
     */
    private static int rangeSum(int[] prefix, int left, int right) {
        if (left == 0) {
            return prefix[right];
        }
        return prefix[right] - prefix[left - 1];
    }

    /**
     * Problem: Suffix Sum Array
     * Description: Builds an array where each value stores the sum of elements to its right.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    private static int[] suffixSum(int[] arr) {
        int[] suffix = new int[arr.length];
        suffix[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + arr[i];
        }
        return suffix;
    }

    /**
     * Problem: Equilibrium Index
     * Description: Finds an index where the sum of elements to the left equals the sum to the right.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private static int equilibriumIndex(int[] arr) {
        int total = 0;
        for (int num : arr) {
            total += num;
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            total -= arr[i];
            if (leftSum == total) {
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }

    /**
     * Problem: Pivot Index
     * Description: Finds an index where the sum of the left side equals the sum of the right side.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private static int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = total - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}