public class Heap {
    int[] arr=null;
    int sizeOfTree;

    Heap(int size){
        this.arr = new int[size+1];
        sizeOfTree = 0;
    }

    public boolean isEmpty(){
        return sizeOfTree==0;
    }

    public boolean isFull(){
        return sizeOfTree== arr.length-1;
    }

    public Integer peek(){
        if(isEmpty()){
            System.out.println("empty");
            return null;
        }
        return arr[1];
    }

    public int sizeOfHeap(){
        return sizeOfTree;
    }

    public void levelOrder(){
        if(isEmpty()){
            System.out.println("empty");
            return;
        }
        for(int i=1;i<=sizeOfTree;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public void heapifyBottomToTop(int index,String type){
        if(index<=1)
            return;
        int parent = index/2;
        if(type.equalsIgnoreCase("min")){
            if(arr[index]<arr[parent]){
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }
        else if(type.equalsIgnoreCase("max")){
            if(arr[index]>arr[parent]){
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }

        heapifyBottomToTop(parent,type);
    }

    public void insert(int value,String type){
        if(isFull()){
            System.out.println("full");
            return;
        }
        arr[++sizeOfTree]=value;

        heapifyBottomToTop(sizeOfTree,type);
    }

    public void heapifyTopToBottom(int index, String type){
        int left = index*2;
        int right = (index*2)+1;
        int swapChild=0;
        if(left>sizeOfTree)
            return;
        if(type.equalsIgnoreCase("max")){
            if(sizeOfTree==left){
                if(arr[left]>arr[index]){
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            }else {
                if(arr[left]>arr[right]){
                    swapChild = left;
                }else if(arr[right]>arr[left]){
                    swapChild = right;
                }
                if(arr[swapChild]>arr[index]){
                    int temp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = temp;
                }
            }
        }
        else if(type.equalsIgnoreCase("min")){
            if(sizeOfTree==left){
                if(arr[left]<arr[index]){
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            }else {
                if(arr[left]<arr[right]){
                    swapChild = left;
                }else if(arr[right]<arr[left]){
                    swapChild = right;
                }
                if(arr[swapChild]<arr[index]){
                    int temp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = temp;
                }
            }
        }
        heapifyTopToBottom(swapChild,type);
    }

    public int extractHead(String type){
        if(isEmpty()){
            System.out.println("empty");
            return -1;
        }
        int removed = arr[1];
        arr[1] = arr[sizeOfTree--];
        heapifyTopToBottom(1,type);
        return removed;
    }

    public void deleteHeap(){
        arr=null;
        System.out.println("heap deleted");
    }

    public static void main(String[] args) {
        Heap h = new Heap(5);
//        h.insert(10,"min");
//        h.insert(5,"min");
//        h.insert(15,"min");
//        h.insert(1,"min");
//        h.levelOrder();
//        System.out.println(h.extractHead("min"));
//        h.levelOrder();

        h.insert(10,"max");
        h.insert(5,"max");
        h.insert(15,"max");
        h.insert(1,"max");
        h.levelOrder();
        System.out.println(h.extractHead("max"));
        h.levelOrder();
    }
}
