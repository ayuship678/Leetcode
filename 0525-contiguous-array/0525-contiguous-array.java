import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, -1);
        
        int prefixSum = 0;
        int maxLen = 0;
        
        for (int i = 0; i < nums.length; i++) {
            prefixSum += (nums[i] == 1) ? 1 : -1;
            
            if (prefixMap.containsKey(prefixSum)) {
                maxLen = Math.max(maxLen, i - prefixMap.get(prefixSum));
            } else {
                prefixMap.put(prefixSum, i);
            }
        }
        
        return maxLen;
    }
}