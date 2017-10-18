package com.interview.problems.medium;

import java.util.Stack;
import java.util.regex.Pattern;

public class BalancedBrackets {

    /**
     * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ]. Two brackets are
     * considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing
     * bracket (i.e., ), ], or }) of the exact same type There are three types of matched pairs of brackets: [], {}, and
     * ().
     *
     * Given strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced,
     * print YES on a new line; otherwise, print NO on a new line.
     *
     * @param brackets String with brackets
     * @return True or False
     */
    private static boolean balancedBrackets(String brackets) {
        Stack<Character> stack = new Stack<>();
        int length = brackets.length();

        for (int i = 0; i < length; i++) {
            if (Pattern.matches("[\\[\\{\\(]", brackets.substring(i, i + 1))) {
                stack.push(brackets.charAt(i));
            } else if (Pattern.matches("[\\]\\}\\)]", brackets.substring(i, i + 1))) {
                char openBracket = stack.pop();
                int asciiOffset = 2;

                if (openBracket == '(') {
                    asciiOffset = 1;
                }

                if (openBracket != brackets.charAt(i) - asciiOffset) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(balancedBrackets("{{[[()]]}}[[[[") ? "YES" : "NO");
        System.out.println(balancedBrackets("{{[[(())]]}}") ? "YES" : "NO");
        System.out.println(balancedBrackets("{[(])}") ? "YES" : "NO");
    }
}
