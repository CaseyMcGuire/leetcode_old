public class Solution{
    /*
      Assuming that A and B are sorted and that A has enough room for the elements in B,
      merge B into A.

      @param A An array filled with values up to index m and whose length is m + n
      @param m The number of values in A
      @param B An array of size n
      @param n The length of the second array
     */
    public static void merge(int A[], int m, int B[], int n){
	int i = m - 1;
	int j = n - 1;
	int k = A.length - 1;
	
	while(k >= 0){
	    
	    if(i < 0){
		A[k] = B[j];
		j--;
	    }
	    else if(j < 0){
		A[k] = A[i];
		i--;
	    }
	    else if(A[i] > B[j]){
		A[k] = A[i];
		i--;
	    }else{//A[i] < B[j]
		A[k] = B[j];
		j--;
	    }
	    k--;
	}
    }
}
