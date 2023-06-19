public class sumLists {
    public LinkedList sumLists(LinkedList l1, LinkedList l2){
        LinkedList l3 = new LinkedList();
        Node n1 = l1.head;
        Node n2 = l2.head;
        int sum=0,carry=0;
        while(n1!=null && n2!=null){
            sum=carry;
            if(n1!=null){
                sum+=n1.value;
                n1=n1.next;
            }if(n2!=null){
                sum+=n2.value;
                n2=n2.next;
            }
            carry=sum/10;
            sum=sum%10;
            l3.insertNode(sum);
        }
        return l3;
    }
}

// int upto = Math.min(l1.size, l2.size);
// Node a = l1.head;
// Node b = l2.head;
// int carry = 0;
// LinkedList result = new LinkedList();
// for(int i=0;i<upto;i++){
//     int sum= a.value+ b.value+ carry;
//     carry = sum/10;
//     if(i==0){
//         result.createLL(sum%10);
//     }else{
//         result.insertNode(sum%10);
//     }
//     a=a.next;
//     b=b.next;
// }
// if(a!=null){
//     while(a!=null){
//         int sum= a.value+ carry;
//         carry = sum/10;
//         result.insertNode(sum%10);
//         a=a.next;
//     }
//     if(carry!=0)
//         result.insertNode(carry);
// }else if(b!=null){
//     while(b!=null){
//         int sum= b.value+carry;
//         carry = sum/10;
//         result.insertNode(sum%10);
//         b=b.next;
//     }
//     if(carry!=0)
//         result.insertNode(carry);
// }
// return result;