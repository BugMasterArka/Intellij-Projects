import java.util.HashSet;

public class Intersection {

//    using a hashset to check for same node
    Node findIntersection(LinkedList llA, LinkedList llB){
        HashSet<Node> set = new HashSet<>();
        Node c1 = llA.head;
        while(c1!=null){
            set.add(c1);
            c1=c1.next;
        }
        Node c2 = llB.head;
        while(c2!=null){
            if(!set.add(c2))
                return c2;
            c2=c2.next;
        }
        return null;
    }

//    skipping extra part of longer list and iterating them together
    Node getKthNode(Node ll, int size){
        int index=0;
        while(index!=size && ll!=null){
            ll=ll.next;
            index++;
        }
        return ll;
    }

    Node findIntersection2(LinkedList llA, LinkedList llB){
        if(llA.tail!=llB.tail)
            return null;
        Node longer = null;
        Node shorter = null;
        if(llA.size>llB.size){
            longer=llA.head;
            shorter=llB.head;
        }else{
            longer=llB.head;
            shorter=llA.head;
        }
        longer = getKthNode(longer,Math.abs(llA.size- llB.size));
        while(shorter!=longer){
            shorter=shorter.next;
            longer=longer.next;;
        }
        return longer;
    }
}
