public class Partition {
    public LinkedList partition(LinkedList ll,int key){
        Node cur = ll.head;
        ll.tail=ll.head;
        while(cur!=null){
            Node next = cur.next;
            if(cur.value<key){
                cur.next=ll.head;
                ll.head=cur;
            }else{
                ll.tail.next=cur;
                ll.tail=cur;
            }
            cur = next;
        }
        return ll;
    }
}

// Node partition = ll.head;
// while(partition!=null){
//     if(partition.value==key)
//         break;
//     partition = partition.next;
// }
// LinkedList l2 = new LinkedList();
// l2.createLL(partition.value);
// Node c = ll.head;
// while(c!=null){
//     if(c.value<partition.value){
//         Node temp = new Node();
//         temp.value = c.value;
//         temp.next = l2.head;
//         l2.head = temp;
//         l2.size++;
//     }else if(c.value>=partition.value && c!=partition){
//         Node temp = new Node();
//         temp.value = c.value;
//         l2.tail.next = temp;
//         l2.tail = temp;
//         l2.size++;
//     }
//     c = c.next;
// }
// return l2;