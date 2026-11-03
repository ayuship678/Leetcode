class Solution {
    public int minMoves(int[] nums) {
        int ans = 0;
        int max = 0;
        for(int num:nums){
            max = Math.max(num,max);
        }
        for(int num:nums){
            ans += max-num;
        }

        return ans;
    }
}