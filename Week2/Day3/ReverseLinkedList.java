class LinkedListNode {

    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }
    public String printList(LinkedListNode temp) {
        String result ="";

        while( temp != null ){
            result = result + " " + temp.value;
            temp = temp.next;
        }
        return result;
    }
}


public class ReverseLinkedList {
    public LinkedListNode reverse(LinkedListNode head ) {
        LinkedListNode curr=head;
        LinkedListNode prev=null;
        LinkedListNode next=null;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
        //System.out.println(head.value);
        return head;
    }


    public static void main(String[] args) {
        ReverseLinkedList obj = new ReverseLinkedList();

        LinkedListNode a = new LinkedListNode(1);
        LinkedListNode b = new LinkedListNode(2);
        LinkedListNode c = new LinkedListNode(3);
        LinkedListNode d = new LinkedListNode(4);
        LinkedListNode e = new LinkedListNode(5);
        LinkedListNode f = new LinkedListNode(6);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        LinkedListNode newHead = obj.reverse(a);

        System.out.println("Reversed Linked List is : "+newHead.printList(newHead));
    }

}
