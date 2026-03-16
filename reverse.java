public class reverse {
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

    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public static void main(String[] args) {
        reverse ll = new reverse();
        ll.print();
        ll.addFrist(1);
        ll.print();
        ll.addFrist(2);
        ll.print();
        ll.addFrist(3);
        ll.print();
        ll.addLast(4);
        ll.add(2, 9);
        ll.print();
        System.out.println(size);

        ll.reverse();
        ll.print();

    }
}
