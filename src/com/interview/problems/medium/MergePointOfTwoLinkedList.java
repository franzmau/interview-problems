package com.interview.problems.medium;

import java.util.HashMap;

public class MergePointOfTwoLinkedList {

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    /**
     * Given pointers to the head nodes of 2 linked lists that merge together at some point
     * find the Node where the two lists merge. It is guaranteed that the two head Nodes
     * will be different, and neither will be NULL.
     *
     * [List #1] a--->b--->c
     *                      \
     *                       x--->y--->z--->NULL
     *                      /
     *      [List #2] p--->q
     *
     * @param headA Head pointer to List #1
     * @param headB Head pointer to List #2
     * @return value of the Merge Point
     */
    private static int findMergeNode(Node headA, Node headB) {
        HashMap<Node, Integer> map = new HashMap<>();
        Node node = headA;
        do {
            map.put(node, node.data);
            node = node.next;
        } while (node != null);

        node = headB;
        do {
            Integer value = map.get(node);
            if (value != null) {
                return value;
            }
            node = node.next;
        } while (node != null);

        return -1;
    }

    public static void main(String[] args) {
        Node merge = new Node(3);
        Node headA = new Node(10);
        Node headB = new Node(20);

        Node tempNode = headA;
        for(int i = 11; i <= 13; i++) {
            tempNode.next = new Node(i);
            tempNode = tempNode.next;
        }
        tempNode.next = merge;
        tempNode = headB;

        for (int i = 21; i <= 25; i++) {
            tempNode.next = new Node(i);
            tempNode = tempNode.next;
        }
        tempNode.next = merge;

        System.out.println(findMergeNode(headA, headB));
    }
}
