public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //have to keep track of which number goes to which index
        Map<Integer, Integer> numToIndex = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++){
            numToIndex.put(numbers[i], i);
        }
        for(int i = 0; i < numbers.length; i++){
            int remainder = target - numbers[i];
            Integer otherIndex = numToIndex.get(remainder);
            if(otherIndex != null && otherIndex.intValue() != i){
                return i > otherIndex.intValue() ? new int[]{otherIndex.intValue() + 1, i + 1} : new int[]{i + 1, otherIndex.intValue() + 1};
            }
            
        }
        return null;
    }
}