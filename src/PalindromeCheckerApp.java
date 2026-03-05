import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        // UC1:
        System.out.println("=====================================");
        System.out.println(" Welcome to Palindrome Checker App ");
        System.out.println(" Version: 1.0.0 ");
        System.out.println("=====================================");

        // UC2: StringBuilder reverse
        String wordUC2 = "madam";
        String reversedUC2 = new StringBuilder(wordUC2).reverse().toString();
        boolean isPalindromeUC2 = wordUC2.equals(reversedUC2);
        System.out.println("Input text : " + wordUC2);
        System.out.println("Is it a palindrome: " + isPalindromeUC2);

        // UC3: Manual reverse with loop
        String wordUC3 = "level";
        String reversedUC3 = "";
        for (int i = wordUC3.length() - 1; i >= 0; i--) {
            reversedUC3 = reversedUC3 + wordUC3.charAt(i);
        }
        boolean isPalindromeUC3 = wordUC3.equals(reversedUC3);
        System.out.println("Input text : " + wordUC3);
        System.out.println("Is it a palindrome: " + isPalindromeUC3);

        // UC4: Two-pointer technique
        String wordUC4 = "radar";
        char[] chars = wordUC4.toCharArray();
        boolean isPalindromeUC4 = true;
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                isPalindromeUC4 = false;
                break;
            }
            left++;
            right--;
        }
        System.out.println("Input : " + wordUC4);
        System.out.println("Is it a palindrome: " + isPalindromeUC4);

        // UC5: Using Stack
        String wordUC5 = "noon";
        Stack<Character> stack = new Stack<>();
        for (char c : wordUC5.toCharArray()) {
            stack.push(c);
        }
        String reversedUC5 = "";
        while (!stack.isEmpty()) {
            reversedUC5 = reversedUC5 + stack.pop();
        }
        boolean isPalindromeUC5 = wordUC5.equals(reversedUC5);
        System.out.println("Input : " + wordUC5);
        System.out.println("Is it a palindrome: " + isPalindromeUC5);

        // UC6: Using Queue + Stack
        String wordUC6 = "civic";
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stackUC6 = new Stack<>();
        for (char c : wordUC6.toCharArray()) {
            queue.add(c);
            stackUC6.push(c);
        }
        boolean isPalindromeUC6 = true;
        while (!queue.isEmpty()) {
            char fromQueue = queue.remove();
            char fromStack = stackUC6.pop();
            if (fromQueue != fromStack) {
                isPalindromeUC6 = false;
                break;
            }
        }
        System.out.println("Input : " + wordUC6);
        System.out.println("Is it a palindrome: " + isPalindromeUC6);

        // UC7: Using Deque
        String wordUC7 = "refer";
        Deque<Character> deque = new LinkedList<>();
        for (char c : wordUC7.toCharArray()) {
            deque.addLast(c);
        }
        boolean isPalindromeUC7 = true;
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();
            if (front != rear) {
                isPalindromeUC7 = false;
                break;
            }
        }
        System.out.println("Input: " + wordUC7);
        System.out.println("Is it a palindrome: " + isPalindromeUC7);

        // UC8: Linked List Based Palindrome Checker
        String wordUC8 = "level";
        boolean isPalindromeUC8 = isPalindromeLinkedList(wordUC8);
        System.out.println("Input : " + wordUC8);
        System.out.println("Is Palindrome?: " + isPalindromeUC8);
    }


    private static Node buildLinkedList(String word) {
        Node head = null, tail = null;
        for (char c : word.toCharArray()) {
            Node newNode = new Node(c);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    // UC8 palindrome check
    private static boolean isPalindromeLinkedList(String word) {
        Node head = buildLinkedList(word);
        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secondHalf = reverseList(slow);


        Node firstHalf = head;
        Node tempSecond = secondHalf;
        while (tempSecond != null) {
            if (firstHalf.data != tempSecond.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }
        return true;
    }

    private static Node reverseList(Node head) {
        Node prev = null, current = head, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}