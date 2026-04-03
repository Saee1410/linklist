public class deletell {
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void linkDelete(Node head, int M, int N){
        Node curr = head;
        while (curr != null) {
            for (int i = 1; i < M && curr != null; i++) {
                curr = curr.next;
            }

            if (curr == null) {
                return;
            }

            Node t = curr.next;
            for (int i = 1; i <= N && t != null; i++){
                t = t.next;
            }
            curr.next = t;
            curr = t;

        }

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
        deletell list = new deletell();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        System.out.println("Original List:");
        list.printList(head);

        int M = 2, N = 2;
        list.linkDelete(head, M, N);

        System.out.println("Modified List after deleting " + N + " nodes after every " + M + " nodes:");
        list.printList(head);
    }
}
