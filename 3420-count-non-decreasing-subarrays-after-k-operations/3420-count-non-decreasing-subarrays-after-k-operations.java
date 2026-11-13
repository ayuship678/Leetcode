class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        long cost = 0;
        
        int[] dq = new int[n];
        int head = 0;
        int tail = -1;
        
        int j = n - 1; 
        
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            
            while (head <= tail && nums[dq[tail]] < num) {
                int l = dq[tail--];
                int r = (head <= tail) ? dq[tail] : j + 1;
                cost += (long) (r - l) * (num - nums[l]);
            }
            
            dq[++tail] = i;
            
            while (cost > k) {
                cost -= nums[dq[head]] - nums[j];
                if (dq[head] == j) {
                    head++;
                }
                j--;
            }
            
            ans += (j - i + 1);
        }
        
        return ans;
    }
}