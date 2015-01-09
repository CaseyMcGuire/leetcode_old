import java.util.*;

public class Solution{

    /*
      Given an array of ints, return a List containing all subsets of that array.
     */
    public static List<List<Integer>> subsets(int[] S){
	List<List<Integer>> masterList = new ArrayList<>();
	//subsets must be sorted
	Arrays.sort(S);
	List<Integer> set = intArrayToList(S);

	masterList.add(new ArrayList<Integer>());//add the empty set

	for(int sizeOfSubset = 1; sizeOfSubset <= S.length; sizeOfSubset++){
	    addSubsets(masterList,new ArrayList<Integer>(), sizeOfSubset, 0, set);
	}
	return masterList;
    }

    
    /*
      Recursively add subsets to the master list of subsets.

      @param master The list that contains all the subsets.
      @param runningSet The elements in the current subset given the level of recursion
      @param sizeOfSubset The size of the subset we're currently adding to the list
      @param startVal The value that the inner loop should start on
      @param The original set of integers
     */
    private static void addSubsets(List<List<Integer>> master, List<Integer> runningSet, int sizeOfSubset, int startVal, List<Integer> wholeSet){
	for(int i = startVal; i < wholeSet.size(); i++){
	    runningSet.add(wholeSet.get(i));

	    if(sizeOfSubset == 1){
		ArrayList<Integer> curSubset = new ArrayList<Integer>();
		curSubset.addAll(runningSet);
		master.add(curSubset);
	    }else{
		addSubsets(master, runningSet, sizeOfSubset- 1, i + 1, wholeSet);

	    }
	    runningSet.remove(runningSet.size() - 1);
	}
    }

    /*
      Given an int array, returns a List containing the values in that array in the same order
     */
    public static List<Integer> intArrayToList(int[] array){
	List<Integer> list = new ArrayList<Integer>();
	for(int i: array){
	    list.add(i);
	}
	return list;
    }

    public static void main(String[] args){
	System.out.println(subsets(new int[]{1,2}));
	System.out.println(subsets(new int[]{1,2,3}));
	System.out.println(subsets(new int[]{1,2,3,4}));
    }

}
