
public class Solution {
    public static int hammingWeight(int n) {
	return (int) Integer.toBinaryString(n)
	                    .chars()
                 	    .filter(x -> x == '1')
	                    .count();
    }
    
    public static void main(String[] args) {
	System.out.println(hammingWeight(0));
	System.out.println(hammingWeight(1));
	System.out.println(hammingWeight(2));
    }
}
