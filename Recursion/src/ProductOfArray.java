public class ProductOfArray {
    public int productofArray(int A[], int N)
    {
        if(N==0)
            return A[0];
        return A[N-1]*productofArray(A,N-1);
    }
}
