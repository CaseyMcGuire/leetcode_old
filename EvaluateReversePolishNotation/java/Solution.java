import java.util.*;
public class Solution {

    public int evalRPN(String[] tokens) {
	final Deque<String> stack = new LinkedList<>();
	final Set<String> operators = new HashSet<>();
	operators.add("+");
	operators.add("-");
	operators.add("/");
	operators.add("*");

	for(final String s : tokens) {
	    if(operators.contains(s)) {
		final String right = stack.pop();
		final String left = stack.pop();
		stack.push(performOp(s, left, right));
	    } else {
		stack.push(s);
	    }
	}
	return Integer.parseInt(stack.pop());
    }

    private String performOp(String op, String e1, String e2) {
	final Integer expOne = Integer.parseInt(e1);
	final Integer expTwo = Integer.parseInt(e2);

	switch(op) {
	case "/":
	    return (expOne/expTwo) + "";
	case "+":
	    return (expOne + expTwo) + "";
	case "-":
	    return (expOne - expTwo) + "";
	case "*":
	    return (expOne * expTwo) + "";
	default:
	    throw new RuntimeException("Unsupported Operation");
	}
    }

}
