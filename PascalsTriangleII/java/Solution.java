import java.util.*;
public class Solution {
    
    public List<Integer> getRow(int rowIndex) {
	LinkedList<Integer> curRow = new LinkedList<Integer>();
	curRow.add(1);
	for(int i = 0 ; i < rowIndex ; i++) {
	    LinkedList<Integer> nextRow = new LinkedList<Integer>();
	    
	    nextRow.add(1);
	    for(int j = 0 ; j < curRow.size() - 1 ; j++) {
		nextRow.add(curRow.get(j) + curRow.get(j + 1));
	    }
	    nextRow.add(1);
	    curRow = nextRow;
	}
	return curRow;
    }

    public static void runTest(List<Integer> actual, List<Integer> expected) {
	if(actual.equals(expected)) {
	    System.out.println("PASS");
	} else {
	    System.out.println("FAIL. Expected: " + expected + " Actual: " + actual);
	}
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	runTest(s.getRow(0), Arrays.asList(1));
	runTest(s.getRow(1), Arrays.asList(1,1));
	runTest(s.getRow(2), Arrays.asList(1,2,1));
    }
}
