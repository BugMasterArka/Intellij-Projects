public class PoisonousPlants {
    static Node head;
    static void display(){
        if(head==null){
            System.out.println("Empty list");
            return;
        }
        Node c =head;
        while(c!=null){
            System.out.print(c.value+" -> ");
            c=c.next;
        }
        System.out.println();
    }
}
