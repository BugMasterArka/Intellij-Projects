class SingleDimensionalArray4{
    int[] arr = null;

    public SingleDimensionalArray4(int size){
        arr = new int[size];
        for(int i=0;i<size;i++)
            arr[i] = Integer.MIN_VALUE;
    }

    public void insert(int loc, int val){
        try{
            if(arr[loc]==Integer.MIN_VALUE){
                arr[loc]=val;
                System.out.println("Inserted");
            }else
                System.out.println("Occupied");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Index");
        }
    }

    public void traverse(){
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }

    public void search(int key){
        for(int i=0;i< arr.length;i++){
            if(arr[i]==key){
                System.out.println("found at "+i);
                return;
            }
        }
        System.out.println("not found");
    }
}
public class SearchElement {
}
