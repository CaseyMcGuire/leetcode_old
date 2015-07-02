import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
class Solution {

    //works but too slow
    public static boolean containsDuplicate(int[] nums) {
	return Arrays.stream(nums)
	             .parallel()
	             .distinct()
	             .count() != nums.length;
    }

    public static boolean containsDuplicate2(int[] nums) {
	Set<Integer> numbers = new HashSet<>();
	for(int i : nums) {
	    if(numbers.contains(i)) return false;
	    else numbers.add(i);
	}
	return true;
    }

    public static void main(String[] args) {
	System.out.println(containsDuplicate(new int[]{1,1,2,3}));
    }
}
