public class PalindromeCheckerAPP {

    public static void main(String[] args) {
        // UC1:
        System.out.println("=====================================");
        System.out.println(" Welcome to Palindrome Checker App ");
        System.out.println(" Version: 1.0.0 ");
        System.out.println("=====================================");

        // UC2:
        String wordUC2 = "madam";  // String Literal
        String reversedUC2 = new StringBuilder(wordUC2).reverse().toString();
        boolean isPalindromeUC2 = wordUC2.equals(reversedUC2);

        System.out.println("Input text : " + wordUC2);
        System.out.println("Is it a palindrome: " + isPalindromeUC2);

        // UC3:
        String wordUC3 = "level";
        String reversedUC3 = "";

        for (int i = wordUC3.length() - 1; i >= 0; i--) {
            reversedUC3 = reversedUC3 + wordUC3.charAt(i);
        }
        boolean isPalindromeUC3 = wordUC3.equals(reversedUC3);

        System.out.println("Input text : " + wordUC3);
        System.out.println("Is it a palindrome: " + isPalindromeUC3);

        // UC4:
        String wordUC4 = "radar";
        char[] chars = wordUC4.toCharArray();
        boolean isPalindromeUC4 = true;

        int left = 0;
        int right = chars.length - 1;

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
    }
}
