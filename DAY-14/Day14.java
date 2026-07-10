
import java.util.Stack;

public class Day14 {
    /**
     * Problem: Largest Rectangle in Histogram
 
     */
    public static int getMaxArea(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int current = (i == n) ? 0 : arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] >= current) {
                int height = arr[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return maxArea;
    }

    /**
        * Problem: Largest Rectangle in Binary Matrix
     */
    public static int largestRectangleArea(int[] h) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int n = h.length;

        for (int i = 0; i <= n; i++) {
            int current = (i == n) ? 0 : h[i];
            while (!stack.isEmpty() && h[stack.peek()] > current) {
                int height = h[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                ans = Math.max(ans, height * width);
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return ans;
    }

    /**
     * Problem: Largest Rectangle in Binary Matrix

     */
    public static int maxArea(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return 0;
        }

        int rows = mat.length;
        int cols = mat[0].length;
        int ans = 0;
        int[] heights = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                heights[j] = mat[i][j] == 1 ? heights[j] + 1 : 0;
            }
            ans = Math.max(ans, largestRectangleArea(heights));
        }
        return ans;
    }

    /**
     * Problem: Trapping Rain Water
   
     */
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int waterTrapped = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    waterTrapped += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    waterTrapped += rightMax - height[right];
                }
                right--;
            }
        }
        return waterTrapped;
    }

    public static void main(String[] args) {
        int[] histogram = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest rectangle in histogram: " + getMaxArea(histogram));

        int[][] matrix = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };
        System.out.println("Largest rectangle in binary matrix: " + maxArea(matrix));

        int[] water = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapping rain water: " + trap(water));
    }
}