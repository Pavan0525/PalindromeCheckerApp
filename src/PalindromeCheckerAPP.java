import java.util.Stack;

public class PalindromeCheckerAPP {

    public static void main(String[] args) {
        // UC1: Welcome message
        System.out.println("=====================================");
        System.out.println(" Welcome to Palindrome Checker App ");
        System.out.println(" Version: 1.0.0 ");
        System.out.println("=====================================");

        // UC2: Hardcoded palindrome check using StringBuilder reverse
        String wordUC2 = "madam";
        String reversedUC2 = new StringBuilder(wordUC2).reverse().toString();
        boolean isPalindromeUC2 = wordUC2.equals(reversedUC2);

        System.out.println("Input text : " + wordUC2);
        System.out.println("Is it a palindrome: " + isPalindromeUC2);

        // UC3: Palindrome check using manual reverse with loop
        String wordUC3 = "level";
        String reversedUC3 = "";
        for (int i = wordUC3.length() - 1; i >= 0; i--) {
            reversedUC3 = reversedUC3 + wordUC3.charAt(i);
        }
        boolean isPalindromeUC3 = wordUC3.equals(reversedUC3);

        System.out.println("Input text : " + wordUC3);
        System.out.println("Is it a palindrome: " + isPalindromeUC3);

        // UC4: Palindrome check using character array and two-pointer technique
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

        System.out.println("Input text : " + wordUC4);
        System.out.println("Is it a palindrome: " + isPalindromeUC4);

        // UC5: Palindrome check using Stack
        String wordUC5 = "noon";
        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (char c : wordUC5.toCharArray()) {
            stack.push(c);
        }

        // Pop characters to build reversed string
        String reversedUC5 = "";
        while (!stack.isEmpty()) {
            reversedUC5 = reversedUC5 + stack.pop();
        }

        boolean isPalindromeUC5 = wordUC5.equals(reversedUC5);

        System.out.println("Input  : " + wordUC5);
        System.out.println("Is it a palindrome: " + isPalindromeUC5);
    }
}
