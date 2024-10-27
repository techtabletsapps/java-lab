class DLLNode {
    String data;
    DLLNode previous;
    DLLNode next;

    public DLLNode(String data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    private DLLNode head;
    private DLLNode tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void insert(String transaction) {
        DLLNode newNode = new DLLNode(transaction);

        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.previous = tail;
        tail.next = newNode;
        tail = newNode;
    }

    public int total() {
        int total = 0;
        DLLNode current = head;
        while (current!= null) {
            if (current.data.startsWith("W")) {
                int dollarIndex = current.data.indexOf("$");
                int amount = Integer.parseInt(current.data.substring(dollarIndex + 1));
                total += amount;
            }
            current = current.next;
        }
        return total;
    }



    // Method to print list data from head to tail
    public void printList() {
        DLLNode current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("END");
    }
}

public class DLL {
    public static void main(String[] args) {
        // Create a new DoublyLinkedList instance
        DoublyLinkedList transactionList = new DoublyLinkedList();
        for (int i = 0; i < 4; i++) {
            transactionList.insert(args[i]);
        }
        transactionList.insert(args[4]);
        int total = transactionList.total();

        // Print the current list
        transactionList.printList();
        System.out.println("Total: $" + total);
    }

}
