package stringsPalindrome;

public class Palindrome {

    public static void main(String[] args) {
        String palindrome = "aba";

        System.out.println(palindrome.length());
        System.out.println(isPalindromeTraditionalApproach(palindrome.toLowerCase()));
        System.out.println(isPalindromeTwoPointerApproach(palindrome.toLowerCase()));
        System.out.println(isPalindromeRecursiveApproach(0, 2, palindrome));
    }

    public static boolean isPalindromeTraditionalApproach(String candidate) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = candidate.length() - 1; i >= 0; i--) {
            stringBuilder.append(candidate.charAt(i));
        }

        return stringBuilder.toString().equals(candidate);
    }

    public static boolean isPalindromeTwoPointerApproach(String candidate) {
        int start = 0, end = candidate.length() - 1;

        while (start < end) {
            if (candidate.charAt(start) != candidate.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static boolean isPalindromeRecursiveApproach(int start, int end, String candidate) {
        if (start >= end) {
            return true;
        }

        if (candidate.charAt(start) != candidate.charAt(end)) {
            return false;
        }
        return isPalindromeRecursiveApproach(start + 1, end - 1, candidate);
    }
}
