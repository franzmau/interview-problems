package com.interview.problems.easy;

public class Palindrome {

    /**
     * Given a string S return True if its a "Palindrome", False if its not.
     *
     * @param word String to check.
     * @return True if its a palindrome, False if its not.
     */
    private static boolean isPalindrome(String word) {
        int length = word.length();
        for (int i = 0; i < length/2; i++) {
            if (word.charAt(i) != word.charAt(length-(i+1))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("kayak"));
        System.out.println(isPalindrome("armando"));
        System.out.println(isPalindrome("tattarrattat"));
    }
}
