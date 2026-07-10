// Filename: Day13.java
public class Day13 {
    /**
     * Problem: Linked List and Stack Concepts

     */
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    /**
     * Problem: Insert at End of Linked List

     */
    public static Node insertAtEnd(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * Problem: Find Intersection of Two Linked Lists

     */
    public static Node getIntersectionNode(Node headA, Node headB) {
        int lenA = length(headA);
        int lenB = length(headB);

        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private static int length(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    /**
     * Problem: Basic Stack Implementation

     */
    public static class Stack {
        private final int[] arr;
        private int top;

        public Stack(int size) {
            arr = new int[size];
            top = -1;
        }

        public void push(int value) {
            if (top == arr.length - 1) {
                System.out.println("Stack overflow");
                return;
            }
            arr[++top] = value;
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack underflow");
                return -1;
            }
            return arr[top--];
        }

        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return arr[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public int size() {
            return top + 1;
        }
    }

    /**
     * Problem: Next Greater Element

     */
    public static int[] nextGreater(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = -1;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    result[i] = arr[j];
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Problem: Previous Greater Element

     */
    public static int[] previousGreater(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = -1;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    result[i] = arr[j];
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Problem: Next Smaller Element

     */
    public static int[] nextSmaller(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = -1;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    result[i] = arr[j];
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Problem: Previous Smaller Element

     */
    public static int[] previousSmaller(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = -1;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    result[i] = arr[j];
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Problem: Stock Span

     */
    public static int[] stockSpan(int[] prices) {
        int[] span = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int count = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (prices[j] <= prices[i]) {
                    count++;
                } else {
                    break;
                }
            }
            span[i] = count;
        }

        return span;
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node headA = null;
        Node headB = null;

        for (int value : new int[]{1, 2, 3, 4, 5}) {
            headA = insertAtEnd(headA, value);
        }

        for (int value : new int[]{9, 8, 3, 4, 5}) {
            headB = insertAtEnd(headB, value);
        }

        Node intersection = getIntersectionNode(headA, headB);
        System.out.println("Intersection of two linked lists:");
        if (intersection != null) {
            System.out.println("Common node starts at value: " + intersection.data);
        } else {
            System.out.println("No intersection");
        }

        System.out.println("\nBasic stack demo:");
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top: " + stack.peek());
        System.out.println("Pop: " + stack.pop());

        int[] arr = {4, 5, 2, 25, 7, 3, 8};
        System.out.println("\nNext greater: ");
        printArray(nextGreater(arr));
        System.out.println("Previous greater: ");
        printArray(previousGreater(arr));
        System.out.println("Next smaller: ");
        printArray(nextSmaller(arr));
        System.out.println("Previous smaller: ");
        printArray(previousSmaller(arr));

        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        System.out.println("Stock span: ");
        printArray(stockSpan(prices));
    }
}