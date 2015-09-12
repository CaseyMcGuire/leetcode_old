import java.util.*;
public class Solution {

    //runs in O(n lg(k)) where n is size of input array and k is size of window
    public int[] maxSlidingWindow(int[] nums, int k) {
	if(nums == null || nums.length == 0 || k <= 0) {
	    return new int[]{};
	}

	int[] maxWindow = new int[nums.length - k + 1];
	//the current window
	final Deque<Integer> curWindow = new LinkedList<>();
	//A map of current nums in the window to their frequency in the window 
	final TreeMap<Integer, Integer> numsToFrequencies = new TreeMap<>();

	int index = 0;
	for(;index < k ; index++) {
	    final Integer curNum = nums[index];
	    curWindow.addLast(curNum);
	    Integer curVal = numsToFrequencies.get(curNum);
	    if(curVal == null) {
		numsToFrequencies.put(curNum, 1);
	    } else {
		numsToFrequencies.put(curNum, curVal + 1);
	    }
	}

	for(int i = 0 ; i < maxWindow.length ; i++) {
	    //get the max node for this window and put it in its place

	    Integer maxNumInWindow = numsToFrequencies.lastKey();
	    maxWindow[i] = maxNumInWindow;

	    if(index < nums.length) {
		//move the window over 1
		Integer toRemove = curWindow.removeFirst();
		Integer frequencyOfNumInWindow = numsToFrequencies.get(toRemove);
		if(frequencyOfNumInWindow == 1) {
		    numsToFrequencies.remove(toRemove);
		} else {
		    numsToFrequencies.put(toRemove, frequencyOfNumInWindow - 1);
		}

		Integer newEnd = nums[index];
		curWindow.addLast(newEnd);
		
		Integer curFrequency = numsToFrequencies.get(newEnd);
		if(curFrequency == null) {
		    numsToFrequencies.put(newEnd, 1);
		} else {
		    numsToFrequencies.put(newEnd, curFrequency + 1);
		}
		index++;
	    }
	}
	return maxWindow;
    }

    public static void main(String[] args) {
	int[] test = {1,3,1,2,0,5};
	Solution s = new Solution();
	test = s.maxSlidingWindow(test, 3);
	for(int i : test) {
	    System.out.print(i + ", ");
	}
    }
}
