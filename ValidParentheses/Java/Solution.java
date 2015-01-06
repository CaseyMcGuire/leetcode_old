package ValidParentheses.Java;
import Testing.Java.*;
import java.util.*;

class Solution{

    public static boolean isValid(String s){
	if(s == null || s.length() == 0) return true;
	if(s.length() % 2 != 0) return false;
	Deque<Character> stack = new ArrayDeque<>();
	for(int i = 0; i < s.length(); i++){
	    if(isRightFacingParen(s.charAt(i))){
		stack.push(s.charAt(i));
	    }else{
		if(stack.isEmpty()) return false;
		char leftParen = stack.pop();
		if(!areMatchingParens(leftParen, s.charAt(i))) return false;
	    }
	}
	return stack.isEmpty();
    }
    
    private static boolean isRightFacingParen(char paren){
	return paren == '(' || paren == '{' || paren == '[';
    }
    
    private static boolean areMatchingParens(char leftParen, char rightParen){
	switch(leftParen){
	case '(': 
	    return rightParen == ')';
	case '{':
	    return rightParen == '}';
	case '[':
	    return rightParen == ']';
	default:
	    throw new IllegalArgumentException();
	}
    }

}
