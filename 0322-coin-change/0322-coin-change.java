class Solution {

    private int[][] dp;

    private int solve(int[] coins, int amt, int n, int idx) {

        if (amt == 0) return 0;
        if (idx == n) return (int)1e9;

        if (dp[idx][amt] != -1)
            return dp[idx][amt];

        int notTake = solve(coins, amt, n, idx + 1);

        int take = (int)1e9;
        if (amt >= coins[idx])
            take = 1 + solve(coins, amt - coins[idx], n, idx);

        return dp[idx][amt] = Math.min(notTake, take);
    }

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;

        dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);

        int ans = solve(coins, amount, n, 0);

        return ans >= 1e9 ? -1 : ans;
    }
}