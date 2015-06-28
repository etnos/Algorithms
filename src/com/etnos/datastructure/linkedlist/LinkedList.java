package com.etnos.datastructure.linkedlist;

import com.etnos.datastructure.model.Node;

/**
 * Custom implementation of a Linked List
 */
public class LinkedList {

    private Node next;
//    int size = 0;

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        int value = 1;
        while (value < 6) {
            linkedList.add(new Node(value++));
        }

        linkedList.print();
    }

    public void add(Node next) {
        if (this.next == null) {
            this.next = next;
        } else {
            this.next.next = next;
            this.next = this.next.next;
        }
    }

    public void print() {
        if (next != null) {
            Node iterator = next;
            System.out.println();
            while (iterator != null) {
                System.out.print(" value " + iterator.value);
                iterator = iterator.next;
            }
            System.out.println();
        }
    }

}
