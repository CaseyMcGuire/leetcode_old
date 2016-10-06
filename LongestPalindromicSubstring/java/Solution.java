public class Solution {

    public String longestPalindrome(String s) {
        int currentWindowSize = s.length();
        while(true) {
            int currentWindowEnd = currentWindowSize;
            for (int i = 0; currentWindowEnd <= s.length(); currentWindowEnd++, i++) {
                if (isPalindrome(s, i, currentWindowEnd)) {
                    return s.substring(i, currentWindowEnd);
                }
            }
            currentWindowSize--;
        }
    }

    

    private boolean isPalindrome(String str, int start, int substringLength) {
        for (int i = start, j = substringLength - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
