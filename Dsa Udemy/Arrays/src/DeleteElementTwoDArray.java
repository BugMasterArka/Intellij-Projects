class TwoDimensionalArray5{
    int[][] arr=null;

    public TwoDimensionalArray5(int rows,int columns){
        arr=new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j]=Integer.MIN_VALUE;
            }
        }
    }

    public void insert(int row, int col, int val){
        try{
            if(arr[row][col]==Integer.MIN_VALUE){
                arr[row][col]=val;
                System.out.println("inserted");
            }else
                System.out.println("occupied");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("invalid index");
        }
    }

    public void access(int row, int col){
        try{
            System.out.println(arr[row][col]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("invalid index");
        }
    }

    public void traverse(){
        for(int i=0;i<arr.length;i++){
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void search(int key){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j]==key){
                    System.out.println("found");
                    return;
                }
            }
        }
        System.out.println("not found");
    }

    public void delete(int row, int col){
        try {
            System.out.println(arr[row][col]);
            arr[row][col]=Integer.MIN_VALUE;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("invalid index");
        }
    }
}
public class DeleteElementTwoDArray {
}
