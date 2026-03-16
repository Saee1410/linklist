public class merge {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
     
    public void addFrist(int data) {

      //  step1:- create new node
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        //step2:- newNode next = head
        newNode.next = head; //link

        //step3 - head = newNode
        head = newNode;
    }
    
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode; //link
        tail = newNode;
    }
    public void print() {
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" -->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data){//add in middle
        if(idx == 0){
            addFrist(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while(i < idx-1){
            temp = temp.next;
            i++;
        }
        //i = indx-1, temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
}

private Node getMid(Node head){
    Node slow = head;
    Node fast = head.next;

    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow; //mid node
    
}

private Node merge(Node head1, Node head2){
    Node mergedLL = new Node(-1);
    Node temp = mergedLL;
    while(head1 != null && head2 != null){
        if(head1.data <= head2.data){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }else {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
    }

    while(head1 != null){
        temp.next = head1;
        head1 = head1.next;
        temp = temp.next;
    }

    while(head2 != null){
        temp.next = head2;
        head2 = head2.next;
        temp = temp.next;
    }

    return mergedLL.next;
}
    public Node mergeSort(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        //find mid
        Node mid = getMid(head);
        //left & right half Ms
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //merge
        return merge(newLeft, newRight);


    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFrist(1);
        ll.addFrist(2);
        ll.addFrist(3);
        ll.addFrist(4);
        ll.addFrist(5);
        ll.print();

        merge m = new merge();
        head = m.mergeSort(head);
        ll.print();
    }
}
