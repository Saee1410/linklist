public class palindrome {
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

    //slow fast approach
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;//+1
            fast = fast.next.next;//+2
        }
        return slow;//slow is middle node
    }
    public boolean checkPalindrome() {
        if(head == null || head.next != null){
            return true;
        }
       //step1- find mid
       Node midNode = findMid(head);

       //step 2- reverse 2nd half
       Node prev = null;
       Node curr = midNode;
       Node next;
       while(curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
       }
       Node right = prev; // right half head
       Node left = head;
       //step3- check left half and right half
       while(right != null) {
        if(left.data != right.data) {
            return false;
        }
        left = left.next;
        right = right.next;
       }
       return true;
    }

    public static void main(String[] args) {
        palindrome ll = new palindrome();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(1);
        // ll.add(2, 9);
        ll.print();
        System.out.println(size);
        System.out.println(ll.checkPalindrome());
    }
}
