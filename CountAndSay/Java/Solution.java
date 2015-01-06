
public class Solution{
    
    public static String countAndSay(int n){
	StringBuilder prev = new StringBuilder("1");
	StringBuilder next = new StringBuilder("");
	
	for(int i = 1; i < n; i++){
	    char cur = prev.charAt(0);
	    int numForCur = 1;
	    for(int j = 1; j < prev.length(); j++){
		if(cur != prev.charAt(j)){
		    next.append(numForCur);
		    next.append(cur);
		    cur = prev.charAt(j);
		    numForCur = 1;
		}else{
		    numForCur++;
		}
	    }
	    next.append(numForCur);
	    next.append(cur);
	    prev = next;
	    next = new StringBuilder();
	}
	return prev.toString();
    }

    public static void main(String[] args){
	for(int i = 0; i < 5; i++){
	    System.out.println("The " + i + "th number in the count and say sequence is " + countAndSay(i));
	}
    }

}
