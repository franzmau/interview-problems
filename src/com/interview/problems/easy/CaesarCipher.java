package com.interview.problems.easy;

public class CaesarCipher {

    /**
     * Julius Caesar protected his confidential information by encrypting it in a cipher. Caesar's cipher rotated every
     * letter in a string by a fixed number, K, making it unreadable by his enemies. Given a string, S, and a number, K,
     * encrypt and print the resulting string.
     *
     * Note: The cipher only encrypts letters; symbols, such as -, remain unencrypted.
     *
     * Example: S = "middle-Outz"; K = 2; result = "okffng-Qwvb"
     *
     * @param word String to encrypt
     * @param offset Number of times to rotate the string
     * @return String containing the encrypted word
     */
    private static String cipher(String word, int offset) {
        StringBuilder result = new StringBuilder();
        int length = word.length();

        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    c = (char) (65 + ((c + offset - 65) % 26));
                } else {
                    c = (char) (97 + ((c + offset - 97) % 26));
                }
            }
            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(cipher("middle-Outz", 2));
    }
}
