class SingleDimensionalArray1{
    int[] arr = null;

    public SingleDimensionalArray1(int size){
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
}

public class InsertionInArray {

}
