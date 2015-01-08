public class Solution {

    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        int i = 0;
        int j = s.length() - 1;
        while(true){
            while(!isAlphanumeric(s.charAt(i))){
                i++;
                if(i >= s.length()) break;
	    }
            while(!isAlphanumeric(s.charAt(j))){
                j--;
                if(j < 0) break;
            }
            if(i > j) return true;
            else if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;    
	    }
            if(i == j) break;
            i++;
            j--;
        }
        return true;
    }

    public boolean isAlphanumeric(char ch){
        return Character.isLetter(ch) || Character.isDigit(ch);
    }
}
