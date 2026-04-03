public class OddEvenLL {
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public Node segregateEvenOdd(Node head) {
        if (head == null || head.next == null) {
            return head;
        }   

        Node evenHead = new Node(0);
        Node oddHead = new Node(0);

        Node even = evenHead;
        Node odd = oddHead;
        Node current = head;

        while (current != null) {
            if (current.data % 2 == 0) {
                even.next = current;
                even = even.next;
            } else {
                odd.next = current;
                odd = odd.next;
            }
            current = current.next;
        }

        even.next = oddHead.next;
        odd.next = null;

        return evenHead.next;

    }
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        OddEvenLL list = new OddEvenLL();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        System.out.println("Original List:");
        list.printList(head);

        Node segregatedHead = list.segregateEvenOdd(head);

        System.out.println("Segregated List (Even followed by Odd):");
        list.printList(segregatedHead); 
    }
}
