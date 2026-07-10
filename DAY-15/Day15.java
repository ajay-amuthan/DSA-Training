
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Day15 {
    /**
     * Problem: Valid Parentheses
 \
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        return stack.isEmpty();
    }

    /**
     * Problem: Generate All Subsequences
  
     */
    public static void subSequences(int index, String s, String current, List<String> result) {
        if (index == s.length()) {
            result.add(current);
            return;
        }

        subSequences(index + 1, s, current + s.charAt(index), result);
        subSequences(index + 1, s, current, result);
    }

    /**
     * Problem: Power Set of a String

     */
    public static List<String> powerSet(String s) {
        List<String> result = new ArrayList<>();
        subSequences(0, s, "", result);
        Collections.sort(result);
        return result;
    }

    /**
     * Problem: Generate All Subsets
    
     */
    public static void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }
    }

    /**
     * Problem: Subsets of an Array
 
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(0, nums, current, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Valid parentheses: " + isValid("(){}[]"));
        System.out.println("Valid parentheses: " + isValid("([)]"));

        List<String> powers = powerSet("abc");
        System.out.println("Power set: " + powers);

        int[] nums = {1, 2, 3};
        List<List<Integer>> subSets = subsets(nums);
        System.out.println("Subsets: " + subSets);
    }
}