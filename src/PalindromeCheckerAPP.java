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

public class PalindromeCheckerAPP {

    public static void main(String[] args) {
        // UC1: Welcome message
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
            reversedUC3 += wordUC3.charAt(i);
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
        String reversedStack = "";
        while (!stack.isEmpty()) {
            reversedStack += stack.pop();
        }
        boolean isPalindromeUC5 = wordUC5.equals(reversedStack);
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
            if (!queue.remove().equals(stackUC6.pop())) {
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
            if (deque.removeFirst() != deque.removeLast()) {
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

        // UC9: Recursive Palindrome Checker
        String wordUC9 = "deified";
        boolean isPalindromeUC9 = isPalindromeRecursive(wordUC9, 0, wordUC9.length() - 1);
        System.out.println("Input : " + wordUC9);
        System.out.println("Is Palindrome? (Recursive): " + isPalindromeUC9);

        // UC10: Case-insensitive & space-ignored palindrome
        String wordUC10 = "a man a plane a canal panama";
        boolean isPalindromeUC10 = isPalindromeIgnoreCaseSpace(wordUC10);
        System.out.println("Input : " + wordUC10);
        System.out.println("Is Palindrome? (Ignore case & spaces): " + isPalindromeUC10);
    }

    // -----------------------
    // Helper methods
    // -----------------------

    // Build linked list from string (UC8)
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

    // UC8 palindrome check using linked list
    private static boolean isPalindromeLinkedList(String word) {
        Node head = buildLinkedList(word);
        if (head == null || head.next == null) return true;

        // Find middle
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalf = reverseList(slow);

        // Compare halves
        Node firstHalf = head, tempSecond = secondHalf;
        while (tempSecond != null) {
            if (firstHalf.data != tempSecond.data) return false;
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }
        return true;
    }

    // Reverse linked list
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

    // UC9: Recursive palindrome check
    private static boolean isPalindromeRecursive(String word, int start, int end) {
        if (start >= end) return true; // base condition
        if (word.charAt(start) != word.charAt(end)) return false;
        return isPalindromeRecursive(word, start + 1, end - 1);
    }

    // UC10: Case-insensitive & space-ignored palindrome
    private static boolean isPalindromeIgnoreCaseSpace(String word) {
        String normalized = word.replaceAll("\\s+", "").toLowerCase();
        int left = 0, right = normalized.length() - 1;
        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}