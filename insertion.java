public class insertion {
    static class Node {
        int data;
        Node next;
        Node (int d) {
            data = d;
            next = null;
        }
    }

    public Node getIntersectionNode(Node head1, Node head2) {
        if(head1 == null || head2 == null) return null;

        int len1 = getLength(head1);
        int len2 = getLength(head2);

        while (len1 > len2) {
            head1 = head1.next;
            len1--;
        }

        while (len2 > len1) {
            head2 = head2.next;
            len2--;
        }

        while (head1 != head2){
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }
    private int getLength(Node head) {
        int len = 0;
        Node temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;   
        }
        return len;

    }
    public static void main(String[] args) {
        insertion list = new insertion();
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        Node head2 = new Node(9);
        head2.next = head1.next.next; // Intersection at node with value 3

        Node intersectionNode = list.getIntersectionNode(head1, head2);
        if (intersectionNode != null) {
            System.out.println("Intersection at node with value: " + intersectionNode.data);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
