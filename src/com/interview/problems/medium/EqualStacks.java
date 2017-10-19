package com.interview.problems.medium;


import java.util.stream.IntStream;

public class EqualStacks {

    /**
     * You have three stacks of cylinders where each cylinder has the same diameter, but they may vary in height. You
     * can change the height of a stack by removing and discarding its topmost cylinder any number of times.
     *
     * Find the maximum possible height of the stacks such that all of the stacks are exactly the same height. This
     * means you must remove zero or more cylinders from the top of zero or more of the three stacks until they're all
     * the same height, then print the height. The removals must be performed in such a way as to maximize the height.
     *
     * Note: An empty stack is still a stack.
     *
     * @param firstStack - First Stack containing numbers.
     * @param secondStack - Second Stack containing numbers.
     * @param thirdStack - Third Stack containing numbers.
     * @return - Biggest equal height.
     */

    private static int equalStacks(int firstStack[], int secondStack[], int thirdStack[]) {
        int firstSum = IntStream.of(firstStack).sum();
        int secondSum = IntStream.of(secondStack).sum();
        int thirdSum = IntStream.of(thirdStack).sum();

        int firstOffset = 0;
        int secondOffset = 0;
        int thirdOffset = 0;

        while (firstSum != secondSum || firstSum != thirdSum || secondSum != thirdSum) {
            if (firstSum > secondSum && firstSum > thirdSum && firstOffset < firstStack.length) {
                firstSum = firstSum - firstStack[firstOffset];
                firstOffset++;
            }
            else if(secondSum > thirdSum && secondOffset < secondStack.length) {
                secondSum = secondSum - secondStack[secondOffset];
                secondOffset++;
            }
            else if(thirdOffset < thirdStack.length) {
                thirdSum = thirdSum - thirdStack[thirdOffset];
                thirdOffset++;
            }

        }

        return firstSum;
    }


    public static void main(String[] args) {
        int h1[] = {1, 1, 1, 1, 2};
        int h2[] = {3, 7};
        int h3[] = {1, 3, 1};

        System.out.println(equalStacks(h1, h2, h3));

        int h4[] = {1, 1, 1, 1, 1};
        int h5[] = {3, 2};
        int h6[] = {1, 3, 1};

        System.out.println(equalStacks(h4, h5, h6));
    }


}
