class LinkedlistNode {

    public String value;
    public LinkedlistNode next;

    public LinkedlistNode(String value) {
        this.value = value;
    }

}


public class KthLastNode {

    public LinkedlistNode kthToLastNode(int k,LinkedlistNode start){

        int count = k;
        LinkedlistNode end = start;
        try{
            while(count>0){
                count--;
                end = end.next;
            }
        }
        catch(NullPointerException e){
            System.out.println("The k value is greater than Linkedlist");
            return null;
        }

        while(end!=null){
            end = end.next;
            start = start.next;
        }

        return start;
    }

    public static void main(String[] args) {

        LinkedlistNode a = new LinkedlistNode("Angel Food");
        LinkedlistNode b = new LinkedlistNode("Bundt");
        LinkedlistNode c = new LinkedlistNode("Cheese");
        LinkedlistNode d = new LinkedlistNode("Devil's Food");
        LinkedlistNode e = new LinkedlistNode("Eccles");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        KthLastNode obj = new KthLastNode();

        LinkedlistNode result = obj.kthToLastNode(4, a);
        if (result!=null) {
            System.out.println("Kth node is :"+result.value);
        }else {
            System.out.println("None");
        }
    }
}
