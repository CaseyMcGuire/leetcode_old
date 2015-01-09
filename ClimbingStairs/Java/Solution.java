import java.util.*;

public class Solution{

    /*
      Given staircase with n steps and given the fact you can only climb 1 or 2 steps at a time,
      return the number of distinct ways you can climb to the top.
     */
    public static int climbStairs(int n){
	if(n == 1 || n == 0) return 1;
        List<Integer> staircase = new ArrayList<>();
        staircase.add(1);
        staircase.add(1);
        for(int i = 2; i <= n; i++){
            staircase.add(staircase.get(i - 1) + staircase.get(i - 2));   
        }
        return staircase.get(staircase.size() - 1);
    }

}
