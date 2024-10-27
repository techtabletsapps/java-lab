class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}


class CircularLinkedList {
    Node head = null;
    Node tail = null;

    public void insert(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void display() {
        if(head != null) {
            System.out.println("Head: " + head.data);
            System.out.println("Tail: " + tail.data);
            System.out.print("Nodes: ");
            Node current = head;
            do {
                System.out.print(current.data + " ");
                current = current.next;
            } while(current != head);
            System.out.println();
        }
    }
}



public class SurveillanceSystem {
    public static void main(String[] args) {
        CircularLinkedList cList = new CircularLinkedList();
        
        // Adding data to the list
        cList.insert(Integer.parseInt(args[0]));
        cList.insert(Integer.parseInt(args[1]));
        cList.insert(Integer.parseInt(args[2]));
        cList.insert(Integer.parseInt(args[3]));
        
        // Display the circular linked list
        cList.display();
    }
}