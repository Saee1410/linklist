public class swap {
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    Node head;

    public void swapNodes(int x, int y) {
        if (x == y) return;

        Node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        if (currX == null || currY == null) return;

        if (prevX != null) {
            prevX.next = currY;
        } else {
            head = currY;
        }

        if (prevY != null) {
            prevY.next = currX;
        } else {
            head = currX;
        }

        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    public void printList() {
        Node tNode = head;
        while (tNode != null){
            System.out.print(tNode.data + "->");
            tNode = tNode.next;
        }
        System.out.println("null");
    }

    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public static void main(String[] args) {
        swap list = new swap();
        list.push(7);
        list.push(6);
        list.push(5);
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);

        System.out.println("Linked List before swapping:");
        list.printList();

        int x = 3, y = 5;
        list.swapNodes(x, y);

        System.out.println("Linked List after swapping " + x + " and " + y + ":");
        list.printList();   
    }
}
