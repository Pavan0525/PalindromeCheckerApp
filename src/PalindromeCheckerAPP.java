/*public class PalindromeCheckerAPP {
    public static void main(String[] args) {
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 1.0");
        System.out.println("System initialized successfully.");

    }
}*/
   public class PalindromeCheckerAPP {


    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println(" Welcome to Palindrome Checker App ");
        System.out.println(" Version: 1.0.0 ");
        System.out.println("=====================================");
        String word = "madam";
        String reversed = new StringBuilder(word).reverse().toString();
        if (word.equals(reversed)) {
            System.out.println(" The word \"" + word + "\" is a palindrome.");
        } else {
            System.out.println(" The word \"" + word + "\" is NOT a palindrome.");
        }
    }
}
