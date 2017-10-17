package com.interview.problems.hard;


import java.util.Arrays;
import java.util.List;

public class PrintNestedLists {

    /**
     * Given a List, print all it's elements inorder including nested lists. The purpose of this excercise is
     * the use of recursion and know when to stop.
     *
     * If the list is empty, print Empty List.
     *
     * @param receivedList - Created list within the main method.
     */

    private static void printList(List<Object> receivedList) {

        if (receivedList.size() == 0){
            System.out.println("Empty List");
        }

        for (Object element : receivedList) {
            if (element instanceof List) {
                printList((List<Object>) element);
            }

            if (!(element instanceof List) && !element.toString().equals("")) {
                System.out.println(element);
            }
        }

    }


    public static void main(String[] args) {
        List<Object> inputList = Arrays
                .asList("a", "b", "c", Arrays.asList("d", "e", "f", Arrays.asList("h", "i", "j")), "k", "l");

        printList(inputList);
    }
}
