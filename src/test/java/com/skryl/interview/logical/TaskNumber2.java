package com.skryl.interview.logical;

import java.util.HashSet;

/**
 * Objective: Detect loop in a linked list.
 * Description: Given a linked list, check if the linked list has a loop or not. The below diagram shows a linked list with a loop.
 */
public class TaskNumber2 {
    static class LinkedList {

        static Node head; // head of list

        /* Linked list Node*/
        static class Node {
            int data;
            Node next;
            Node(int d)
            {
                data = d;
                next = null;
            }
        }

        /* Inserts a new Node at front of the list. */
        static public void push(int new_data)
        {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
            Node new_node = new Node(new_data);

            /* 3. Make next of new Node as head */
            new_node.next = head;

            /* 4. Move the head to point to new Node */
            head = new_node;
        }

        // Returns true if there is a loop in linked
        // list else returns false.
        static boolean detectLoop(Node h)
        {
            HashSet<Node> s = new HashSet<>();
            while (h != null) {
                // If we have already has this node
                // in hashmap it means their is a cycle
                // (Because you we encountering the
                // node second time).
                if (s.contains(h))
                    return true;

                // If we are seeing the node for
                // the first time, insert it in hash
                s.add(h);

                h = h.next;
            }

            return false;
        }

        /* Driver program to test above function */
        public static void main(String[] args)
        {
            LinkedList llist = new LinkedList();

            llist.push(20);
            llist.push(4);
            llist.push(15);
            llist.push(10);

            /*Create loop for testing */
            llist.head.next.next.next.next = llist.head;

            if (detectLoop(head))
                System.out.println("Loop Found");
            else
                System.out.println("No Loop");
        }
    }

    static class GFG {

        // Link list node
        static class Node {
            int data;
            Node next;
            int flag;
        }

        static Node push(Node head_ref, int new_data)
        {

            // Allocate node
            Node new_node = new Node();

            // Put in the data
            new_node.data = new_data;

            new_node.flag = 0;

            // Link the old list of the new node
            new_node.next = head_ref;

            // Move the head to point to the new node
            head_ref = new_node;
            return head_ref;
        }

        // Returns true if there is a loop in linked
        // list else returns false.
        static boolean detectLoop(Node h)
        {
            while (h != null) {

                // If this node is already traverse
                // it means there is a cycle
                // (Because you we encountering the
                // node for the second time).
                if (h.flag == 1)
                    return true;

                // If we are seeing the node for
                // the first time, mark its flag as 1
                h.flag = 1;

                h = h.next;
            }
            return false;
        }

        // Driver code
        public static void main(String[] args)
        {

            // Start with the empty list
            Node head = null;

            head = push(head, 20);
            head = push(head, 4);
            head = push(head, 15);
            head = push(head, 10);

            // Create a loop for testing
            head.next.next.next.next = head;

            if (detectLoop(head))
                System.out.print("Loop Found");
            else
                System.out.print("No Loop");
        }
    }
    static class LinkedList2 {
        Node head; // head of list

        /* Linked list Node*/
        class Node {
            int data;
            Node next;
            Node(int d)
            {
                data = d;
                next = null;
            }
        }

        /* Inserts a new Node at front of the list. */
        public void push(int new_data)
        {
		/* 1 & 2: Allocate the Node &
				Put in the data*/
            Node new_node = new Node(new_data);

            /* 3. Make next of new Node as head */
            new_node.next = head;

            /* 4. Move the head to point to new Node */
            head = new_node;
        }

        void detectLoop()
        {
            Node slow_p = head, fast_p = head;
            int flag = 0;
            while (slow_p != null && fast_p != null
                    && fast_p.next != null) {
                slow_p = slow_p.next;
                fast_p = fast_p.next.next;
                if (slow_p == fast_p) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1)
                System.out.println("Loop Found");
            else
                System.out.println("No Loop");
        }

        /* Driver program to test above functions */
        public static void main(String[] args)
        {
            LinkedList2 llist = new LinkedList2();

            llist.push(20);
            llist.push(4);
            llist.push(15);
            llist.push(10);

            /*Create loop for testing */
            llist.head.next.next.next.next = llist.head;

            llist.detectLoop();
        }
    }

}
