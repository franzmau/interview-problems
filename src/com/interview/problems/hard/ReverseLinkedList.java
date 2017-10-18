package com.interview.problems.hard;

public class ReverseLinkedList {

    /**
     * Reverse a linkedlist without the use of another data structure. Pointers must be used in order to solve the
     * problem.
     *
     *          1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
     *          6 -> 5 -> 4 -> 3 -> 2 -> 1 -> null
     *
     *
     * @param head - Receives the head of the generated linked list.
     * @return linked list.
     */

    private static Node reverseLinkedList(Node head) {
        boolean first = false;
        if (head == null) {
            return head;
        }

        Node hNext = null;

        if (head.next != null) {
            hNext = head.next;
            head.next = null;
        }


        while (hNext != null) {
            Node temp = hNext.next;
            hNext.next = head;
            head = hNext;
            hNext = temp;
        }

        return head;
    }



    private static class Node {

        int key;
        Node next;

        public Node(int key) {
            this.key = key;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node = head;

        for (int i = 2; i < 7; i++) {
            node.next = new Node(i);
            node = node.next;
        }

        head = reverseLinkedList(head);
    }
}
