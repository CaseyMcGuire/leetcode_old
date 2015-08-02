import java.util.*;
class Solution {

    public static boolean isAnagram(String s, String t) {
	if(s == null || t == null || s.length() != t.length() ) return false;

	char[] ar1 = s.toCharArray();
	char[] ar2 = t.toCharArray();
	Arrays.sort(ar1);
	Arrays.sort(ar2);

	for(int i = 0 ; i < s.length() ; i++) {
	    if(ar1[i] != ar2[i]) return false;
	}
	return true;
    }

}
