class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if((sum&1)==1)return false;
        int target=sum/2;
        int dp[][]=new int[n][target+1];
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=target;j++){
                int notTake=dp[i-1][j];
                int take=0;
                if(j>=nums[i])take=dp[i-1][j-nums[i]];

                dp[i][j]=take|notTake;
            }
        }
        return dp[n-1][target]==1;
    }
}