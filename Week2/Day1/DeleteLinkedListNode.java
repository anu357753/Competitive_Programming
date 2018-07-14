import java.util.*;
class LinkedlistNode {

    public String value;
    public LinkedlistNode next;

    public LinkedlistNode(String value) {
        this.value = value;
    }



    @Override
    public String toString(){
        String result = value;
        LinkedlistNode temp=next;
        while(temp!=null){
            result = result+" "+ temp.value;
            temp = temp.next;
        }
        return result;
    }
}
public class DeleteLinkedListNode {
    public void deleteNode(LinkedlistNode x){
        // If X is the last element . As its not possible to free the node in Java I made it null.
        if (x.next==null) {
            x.value = null;
            x=null;

        }
        else if (x.next!=null) {
            LinkedlistNode t =x.next;
            x.value = t.value;
            x.next = t.next;
        }
    }

    public static void main(String[] args) {

        LinkedlistNode a = new LinkedlistNode("A");
        LinkedlistNode b = new LinkedlistNode("B");
        LinkedlistNode c = new LinkedlistNode("C");

        DeleteLinkedListNode obj = new DeleteLinkedListNode();
        a.next = b;
        b.next = c;

        System.out.println(a.toString());

        obj.deleteNode(b);
        System.out.println(a.toString());



    }
}
