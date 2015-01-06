package ValidParentheses.Java;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Testing.Java.*;

public class TestCase{
    
    @Test
    public void edgeTest(){
	assertTrue(Solution.isValid(""));
	assertTrue(Solution.isValid(null));
    }
    
    @Test
    public void oddTest(){
	assertFalse(Solution.isValid("(()"));
	assertFalse(Solution.isValid("(()))"));
	assertFalse(Solution.isValid("[](){(}"));
    }

    @Test
    public void easyTrueTest(){
	assertTrue(Solution.isValid("()"));
	assertTrue(Solution.isValid("[]"));
	assertTrue(Solution.isValid("{}"));
	assertTrue(Solution.isValid("(){}"));
	assertTrue(Solution.isValid("()[]"));
	assertTrue(Solution.isValid("{}()"));
	assertTrue(Solution.isValid("{}[]"));
	assertTrue(Solution.isValid("[]()"));
	assertTrue(Solution.isValid("[]{}"));
	assertTrue(Solution.isValid("{}[]()"));
	assertTrue(Solution.isValid("{}()[]"));
	assertTrue(Solution.isValid("[](){}"));
	assertTrue(Solution.isValid("[]{}()"));
	assertTrue(Solution.isValid("()[]{}"));
	assertTrue(Solution.isValid("(){}[]"));
    }

    @Test
    public void easyFalseTest(){
	assertFalse(Solution.isValid("({)}"));
	assertFalse(Solution.isValid("[{]}"));
	assertFalse(Solution.isValid("([)]"));
	assertFalse(Solution.isValid("{[}]"));
	assertFalse(Solution.isValid("({{})}"));
	assertFalse(Solution.isValid("([{]})"));

    }


}
