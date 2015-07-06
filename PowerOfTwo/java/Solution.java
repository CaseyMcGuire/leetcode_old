class Solution {
    public static boolean isPowerOfTwo(int n) {
	if(n < 0) return false;
	return Integer.toBinaryString(Math.abs(n))
	    .chars()
	    .filter(x -> x == '1')
	    .count() == 1;
    }

    public static void main(String[] args) {
	System.out.println(isPowerOfTwo(2));
    }
}
