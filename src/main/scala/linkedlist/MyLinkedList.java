package linkedlist;

/**
 * @Author: xck
 * @File: MyLinkedList
 * @Time: 17:32 2019/4/30
 */
public class MyLinkedList {
    Node root;
    Node head;
    Node tail;
    int size;
    class Node{
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }

        public Node() {
        }
    }
    /** Initialize your data structure here. */
    public MyLinkedList() {
        root = new Node(-1);
        head = root;
        tail = root;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= size) return -1;
        Node temp = root;
        int i = 0;
        while(i < index ){
            temp = temp.next;
            i++;
        }
        return temp.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        size++;
        if(root.val == -1) {
            root.val = val;
            return;
        }
        Node newRoot = new Node(val);
        newRoot.next = root;
        root = newRoot;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        size++;
        if(root.val == -1) {
            root.val = val;
            return;
        }
        tail.next = new Node(val);
        tail = tail.next;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        size++;
        int i = 0;
        Node temp = root;
        while(i < index - 1){
            temp = temp.next;
            i++;
        }
        Node next = temp.next;
        Node t = new Node(val);
        temp.next = t;
        t.next = next;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        int i = 0;
        Node temp = root;
        while(i < index - 2){
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
        System.out.println(linkedList.get(1));
        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
        System.out.println(linkedList.get(1));
    }

}

