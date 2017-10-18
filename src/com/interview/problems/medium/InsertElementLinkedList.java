package com.interview.problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertElementLinkedList {

    private static class Node {

        public Node next = null;
        public Node previous = null;
        public Object data;

        public Node() {
        }

        public Node(Node next, Object data) {
            this.previous = this.next;
            this.next = next;
            this.data = data;
        }
    }

    private static Node insertElement(Node head, String data, int iPosition){
        if (head == null){
            head = new Node(null, data);
            return head;
        }

        if (head.next == null){
            head.next = new Node(null, data);
            return head;
        }

        if (iPosition == 0){
            Node newNode = new Node(head, data);
            head = newNode;
            return head;
        }

        else{
            Node aux = head;

            while(aux != null){
                iPosition = iPosition - 1;
                if (iPosition < 1){
                    Node newNode = new Node(aux.next, data);
                    aux.next = newNode;
                    return head;
                }
                aux = aux.next;
            }
            System.out.println("Out of index");
        }
        return head;
    }

    public static void main(String[] args) {
        List<Node> nodeList = new ArrayList<Node>();

        Node head = new Node(new Node(new Node(null,"c"), "b"), "a");

        head = insertElement(head, "d", 4);

        do {
            System.out.println(head.data);
            head = head.next;
        } while(head != null);
    }

}
