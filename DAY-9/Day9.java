
import java.util.HashMap;
import java.util.Map;

public class Day9 {
    /**
     * Problem: Minimum Size Subarray Sum
    
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    /**
     * Problem: Max Consecutive Ones III
    
     */
    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeros = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    /**
     * Problem: Longest Substring Without Repeating Characters
    
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (lastIndex.containsKey(c)) {
                left = Math.max(left, lastIndex.get(c) + 1);
            }
            lastIndex.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    /**
     * Problem: Binary Search
    
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Problem: Order-Agnostic Binary Search
  
     */
    public static int orderAgnosticBinarySearch(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        boolean ascending = nums[left] < nums[right];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (ascending) {
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * Problem: First Occurrence in a Sorted Array
   
     */
    public static int firstOccurrence(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    /**
     * Problem: Last Occurrence in a Sorted Array
  
     */
    public static int lastOccurrence(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    /**
     * Problem: Count Occurrences in a Sorted Array
  
     */
    public static int countOccurrences(int[] nums, int target) {
        int first = firstOccurrence(nums, target);
        if (first == -1) {
            return 0;
        }
        int last = lastOccurrence(nums, target);
        return last - first + 1;
    }

    /**
     * Problem: Rotate Array by K Steps
 
     */
    public static int[] kthRotation(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return new int[0];
        }
        k %= n;
        if (k < 0) {
            k += n;
        }
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }
        return rotated;
    }

    /**
     * Problem: Search in Rotated Sorted Array
     
     */
    public static int searchInSortedRotatedArray(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Minimum size subarray sum: " + minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println("Maximum consecutive ones III: " + longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println("Longest substring without repeating characters: " + lengthOfLongestSubstring("pwwkew"));
        System.out.println("Binary search: " + binarySearch(new int[]{1, 2, 4, 5, 7, 9}, 5));
        System.out.println("Order-agnostic binary search (desc): " + orderAgnosticBinarySearch(new int[]{9, 7, 5, 4, 2, 1}, 5));
        System.out.println("First occurrence: " + firstOccurrence(new int[]{1, 2, 2, 2, 3, 4}, 2));
        System.out.println("Last occurrence: " + lastOccurrence(new int[]{1, 2, 2, 2, 3, 4}, 2));
        System.out.println("Count occurrences: " + countOccurrences(new int[]{1, 2, 2, 2, 3, 4}, 2));

        int[] rotated = kthRotation(new int[]{1, 2, 3, 4, 5}, 2);
        System.out.print("2nd rotation: ");
        for (int value : rotated) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println("Search in sorted rotated array: " + searchInSortedRotatedArray(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}