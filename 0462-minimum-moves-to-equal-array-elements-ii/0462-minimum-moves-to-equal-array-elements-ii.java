class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int mid = nums[n / 2];
        int res = 0;
        for(int x : nums) res += Math.abs(x - mid);
        return res; 
    }
}