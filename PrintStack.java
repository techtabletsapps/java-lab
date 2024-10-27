import java.util.*;

// A Node represents a single element in the stack
class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

// Stack class implementing a stack using a linked list
class Stack {
    private Node top;



    // Method to parse alerts and push incidents to the stack
    public void parseAlerts(String[] alerts) {
        for (String alert : alerts) {
            if (!alert.startsWith("!")) {
                push(alert);
            }
        }
    }

    // Method to push a new incident onto the stack
    private void push(String data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    // Method to print the nodes in the stack
    public void printStack() {
        if (isEmpty()) {
            System.out.println("No incidents to report.");
        } else {
            Node current = top;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }
    }


    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }
}

// Main class to demonstrate the Stack operations
public class PushStack {
    public static void main(String[] args) {
        Stack incidentStack = new Stack();
        String[] incidents = parseArgs(args);

        incidentStack.parseAlerts(incidents);
        
        System.out.println("Incident Stack Empty: " + incidentStack.isEmpty());
        incidentStack.printStack();
    }

    public static String[] parseArgs(String arguments[]) {
        ArrayList<String> incidents = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        int index = 0;

        for (int i = 0; i < arguments.length; i++) {
            if (!arguments[i].equals(":")) {
                sb.append(arguments[i]);
                sb.append(" ");

                if (i + 1 == arguments.length) {
                    incidents.add(sb.toString().trim());
                }
            } else {
                incidents.add(sb.toString().trim());
                sb.setLength(0);
            }
        }

        String[] incidentsArray = new String[incidents.size()];
        incidentsArray = incidents.toArray(incidentsArray);
        return incidentsArray;

    }
}