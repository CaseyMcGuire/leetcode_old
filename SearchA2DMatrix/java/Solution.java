import java.util.*;
public class Solution {
    
    //O(n) time
    public boolean searchMatrix(int[][] matrix, int target) {
	int row = 0;
	//O(n)
	for(int i = 0 ; i < matrix.length ; i++){
	    if(matrix[i][0] > target){
		row = i - 1;
		break;
	    }
            row = i;
	}
	if(row < 0) return false;
	//O(lg n)
	int result = Arrays.binarySearch(matrix[row], target);
	return result >= 0;
    }

    public static void main(String[] args) {
	Solution solution = new Solution();
	int[][] m1 = new int[][] {
	    {1, 3, 5, 7},
	    {10, 11, 16, 20},
	    {23, 30, 34, 50}
	};
	System.out.println(solution.searchMatrix(m1, 3));
	
    }
}
