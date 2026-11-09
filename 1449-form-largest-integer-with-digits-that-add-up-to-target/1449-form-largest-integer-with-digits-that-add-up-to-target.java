
import java.util.*;

class Solution {

    public String largestNumber(int[] cost, int target) {

        int[] dp = new int[target + 1];

        Arrays.fill(dp, -100000);

        dp[0] = 0;

        for (int t = 1; t <= target; t++) {

            for (int d = 1; d <= 9; d++) {

                int c = cost[d - 1];

                if (t >= c && dp[t - c] != -100000) {

                    dp[t] = Math.max(
                        dp[t],
                        1 + dp[t - c]
                    );
                }
            }
        }

        if (dp[target] < 0) {
            return "0";
        }

        StringBuilder ans = new StringBuilder();

        int remaining = target;

        for (int d = 9; d >= 1; d--) {

            int c = cost[d - 1];

            while (remaining >= c &&
                   dp[remaining] == 1 + dp[remaining - c]) {

                ans.append(d);

                remaining -= c;
            }
        }

        return ans.toString();
    }
}
