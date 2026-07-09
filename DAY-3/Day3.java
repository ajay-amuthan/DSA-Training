import java.util.Arrays;
import java.util.HashSet;

public class Day3 {
    /**
     * Problem: Array Manipulation and Partitioning
     * Description: Demonstrates classic array problems such as two-sum detection, duplicate removal, zero movement, and partitioning by sign or value.
     * Time Complexity: Varies by example
     * Space Complexity: Varies by example
     */
    public static void main(String[] args) {
        int[] arr1 = {2, 7, 11, 15};
        int target = 9;
        System.out.println("Two sum exists: " + twoSum(arr1, target));

        int[] arr2 = {1, 1, 2, 2, 3, 4, 4};
        int newLength = removeDuplicates(arr2);
        System.out.print("After removing duplicates: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

        int[] arr3 = {0, 1, 0, 3, 12};
        moveZeroes(arr3);
        System.out.println("Move zeroes: " + Arrays.toString(arr3));

        int[] arr4 = {-1, 2, -3, 4, -5, 6};
        negativeFirst(arr4);
        System.out.println("Negative first: " + Arrays.toString(arr4));

        int[] arr5 = {-1, 2, -3, 4, -5, 6};
        positiveFirst(arr5);
        System.out.println("Positive first: " + Arrays.toString(arr5));

        int[] arr6 = {0, 1, 1, 0, 1, 0, 0, 1};
        segregateZeroOne(arr6);
        System.out.println("Segregate 0s and 1s: " + Arrays.toString(arr6));

        int[] arr7 = {2, 0, 1, 2, 1, 0, 1, 2};
        segregateZeroOneTwo(arr7);
        System.out.println("Segregate 0s, 1s and 2s: " + Arrays.toString(arr7));
    }

    /**
     * Problem: Two Sum Check
     * Description: Determines whether the array contains two numbers that sum to the target.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    private static boolean twoSum(int[] arr, int target) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                System.out.println("Pair found: " + complement + " " + num);
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    /**
     * Problem: Remove Duplicates from Sorted Array
     * Description: Keeps the first occurrence of each value and overwrites the rest in-place.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private static int removeDuplicates(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[index]) {
                index++;
                arr[index] = arr[i];
            }
        }
        return index + 1;
    }

    /**
     * Problem: Move Zeroes to the End
     * Description: Reorders the array so all non-zero values appear first.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private static void moveZeroes(int[] arr) {
        int index = 0;
        for (int num : arr) {
            if (num != 0) {
                arr[index++] = num;
            }
        }
        while (index < arr.length) {
            arr[index++] = 0;
        }
    }

    /**
     * Problem: Move Negative Numbers to the Front
     * Description: Reorders the array so negative numbers appear before non-negative values.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private static void negativeFirst(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            while (left < right && arr[left] < 0) {
                left++;
            }
            while (left < right && arr[right] >= 0) {
                right--;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
    }

    /**
     * Problem: Move Positive Numbers to the Front
     * Description: Reorders the array so positive numbers appear before negative values.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private static void positiveFirst(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            while (left < right && arr[left] >= 0) {
                left++;
            }
            while (left < right && arr[right] < 0) {
                right--;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
    }

    /**
     * Problem: Segregate 0s and 1s
     * Description: Rearranges the array so all zeroes come before ones.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private static void segregateZeroOne(int[] arr) {
        int countZero = 0;
        for (int num : arr) {
            if (num == 0) {
                countZero++;
            }
        }

        for (int i = 0; i < countZero; i++) {
            arr[i] = 0;
        }
        for (int i = countZero; i < arr.length; i++) {
            arr[i] = 1;
        }
    }

    /**
     * Problem: Segregate 0s, 1s and 2s
     * Description: Rearranges the array into groups of 0, 1, and 2.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private static void segregateZeroOneTwo(int[] arr) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int num : arr) {
            switch (num) {
                case 0 -> count0++;
                case 1 -> count1++;
                default -> count2++;
            }
        }

        int index = 0;
        while (count0-- > 0) {
            arr[index++] = 0;
        }
        while (count1-- > 0) {
            arr[index++] = 1;
        }
        while (count2-- > 0) {
            arr[index++] = 2;
        }
    }
}