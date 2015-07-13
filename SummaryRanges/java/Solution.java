import java.util.*;

public class Solution {
    
    public static List<String> summaryRanges(int[] nums) {
	if(nums == null || nums.length == 0) {
	    return new ArrayList<String>();
	}

	int startRange = nums[0];
	List<String> ranges = new ArrayList<String>();

	for(int i = 1; i < nums.length; i++) {
	    if(nums[i] != nums[i-1] + 1) {
		String range;
		if(startRange == nums[i-1]) {
		    range = startRange + "";
		} else {
		    range = startRange + "->" + nums[i-1];
		}
		ranges.add(range);
		startRange = nums[i];
	    }
	}
	
	String range;
	int lastNum;
	if((lastNum = nums[nums.length - 1]) == startRange) {
	    range = startRange + "";
	} else {
	    range = startRange + "->" + lastNum;
	}
	ranges.add(range);
	return ranges;
    }

    public static void main(String[] args) {
	System.out.println(summaryRanges(new int[]{0,1,2,4,5,7}));
    }
}
