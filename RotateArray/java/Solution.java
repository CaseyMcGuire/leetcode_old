import java.util.*;

public class Solution {

    public void rotate(int[] nums, int k) {
	if(nums == null) return;
	if(k > nums.length) k %= nums.length;
	Deque<Integer> queue = new LinkedList<>();
	for(int i = 0, index = nums.length - k ; i < nums.length ; i++, index++) {
	    if(index == nums.length) index = 0;
	    queue.addLast(nums[index]);
	}
	for(int i = 0 ; !queue.isEmpty() ; i++) {
	    nums[i] = queue.removeFirst();
	}
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] temp = {1,2,3,4,5,6,7};
	s.rotate(temp, 3);
	Arrays.stream(temp).forEach(System.out::print);
    }
}
