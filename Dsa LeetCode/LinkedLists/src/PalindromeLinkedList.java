//problem: https://leetcode.com/problems/palindrome-linked-list/

import java.util.Stack;

public class PalindromeLinkedList {
    static Node head;
    public static boolean isPalindrome(Node head) {
        if(head==null || head.next==null)
            return true;
        // Node a = head;
        // while(a.next!=null){
        //     Node c = a;
        //     while(c.next.next!=null){
        //         c=c.next;
        //     }
        //     if(a.val!=c.next.val)
        //         return false;
        //     a=a.next;
        //     c.next=null;
        // }
        // return true;

        int len = 0;
        Node c = head;
        while(c!=null){
            len++;
            c=c.next;
        }
        c = head;
        int i=0;
        Stack<Integer> s = new Stack<>();
        while(true){
            if(i<len/2){
                s.push(c.val);
                i++;
                c=c.next;
                continue;
            }
            if(s.pop()!=c.val)
                return false;
            if(s.empty())
                break;
            i++;
            c=c.next;
        }
        return true;
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(0);
        head.next.next = new Node(1);
//        head.next.next.next = new Node(1);
        System.out.println(isPalindrome(head));
    }
}
