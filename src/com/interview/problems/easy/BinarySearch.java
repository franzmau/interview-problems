package com.interview.problems.easy;

public class BinarySearch {

    /**
     * Binary Search is one of the most popular search algorithm. Given a sequence of sorted integers
     * find the number, N, using Binary Search. Return True if found and False if not.
     *
     * @param sequence Sequence of sorted integers
     * @param numberToFind Number to find
     * @param low Low offset
     * @param high High offset
     * @return True or False
     */
    private static boolean binarySearch(int[] sequence, int numberToFind, int low, int high) {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            if (sequence[mid] == numberToFind) {
                return true;
            }

            if (sequence[mid] > numberToFind) {
                return binarySearch(sequence, numberToFind, low, mid - 1);
            } else {
                return binarySearch(sequence, numberToFind, mid + 1, high);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] sequence = {2, 3, 10, 18, 20, 26, 38, 39, 41, 44, 47, 51, 52, 55, 57, 59, 68, 76, 79, 89};

        System.out.println(binarySearch(sequence, 20, 0, sequence.length - 1));
        System.out.println(binarySearch(sequence, 89, 0, sequence.length - 1));
        System.out.println(binarySearch(sequence, 75, 0, sequence.length - 1));
    }
}
