public class PalindromeCheckerAPP {

    public static void main(String[] args) {
        // UC1
        System.out.println("=====================================");
        System.out.println(" Welcome to Palindrome Checker App ");
        System.out.println(" Version: 1.0.0 ");
        System.out.println("=====================================");

        // UC2
        String wordUC2 = "madam";
        String reversedUC2 = new StringBuilder(wordUC2).reverse().toString();

        if (wordUC2.equals(reversedUC2)) {
            System.out.println(" UC2: The word \"" + wordUC2 + "\" is a palindrome.");
        } else {
            System.out.println(" UC2: The word \"" + wordUC2 + "\" is NOT a palindrome.");
        }
        // UC3
        String wordUC3 = "level";
        String reversedUC3 = "";
        for (int i = wordUC3.length() - 1; i >= 0; i--) {
            reversedUC3 = reversedUC3 + wordUC3.charAt(i);
        }
        if (wordUC3.equals(reversedUC3)) {
            System.out.println(" UC3: The word \"" + wordUC3 + "\" is a palindrome.");
        } else {
            System.out.println(" UC3: The word \"" + wordUC3 + "\" is NOT a palindrome.");
        }
    }
}
