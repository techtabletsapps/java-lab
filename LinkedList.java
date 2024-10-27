//the linked list is a flexible and dynamic data structure

class Node {
    public String data;
    public Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    public SinglyLinkedList() {
        head = null;
    }


    // Method to insert a new node at the end of the list
    public void insert(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Method to delete a specific node and then the tail
    public void delete(String target) {
        deleteNode(target);
        deleteTail();
    }

    public void deleteNode(String target) {
        Node current = head;
        Node prev = null;

        // check the head node
        if (current != null && current.data.equals(target)) {
            head = head.next;
            return;
        }

        // iterate until end of list or found target
        while (current != null && !current.data.equals(target)) {
            prev = current;
            current = current.next;
        }
        
        // if at end of list, target not found, exit method
        if (current == null) {
          return;
        }

        // otherwise remove node
        prev.next = current.next;
    }

    public void deleteTail() {
        // check for empty list, exit method
        if (head == null) {
            return;
        }

        // if list only has head, remove it
        if (head.next == null) {
            head = null;
            return;
        }

        Node last = head;
        Node prev = null;

        // iterate so prev is second-to-last node
        while (last.next != null) {
            prev = last;
            last = last.next;
        }

        // remove last node
        prev.next = null;
    }


    // Utility method to print the linked list.
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

}

public class SLLDelete {
    public static void main(String[] args) {
        String[] values = args;
        SinglyLinkedList list = new SinglyLinkedList();

        makeList(list, values);
        list.delete(args[5]);
        list.printList();
        
    }

    public static void makeList(SinglyLinkedList list, String[] values) {
        for(int i = 0; i < 5; i++) {
            Node newNode = new Node(values[i]);
            Node temp;
            if (list.head == null) {
                list.head = newNode;
            } else {
                temp = list.head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
            
        }
    }
}
