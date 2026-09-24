class Solution {
    // ---- Approach 2 helper: top-down string DP (lexicographically smallest) ----
    private static String[][] memoStr;
    private static String scs(int i, int j, String s1, String s2) {
        if (memoStr[i][j] != null) return memoStr[i][j];
        if (i == 0) return memoStr[0][j] = s2.substring(0, j);
        if (j == 0) return memoStr[i][0] = s1.substring(0, i);
        char a = s1.charAt(i - 1);
        char b = s2.charAt(j - 1);
        if (a == b) {
            return memoStr[i][j] = scs(i - 1, j - 1, s1, s2) + a;
        }
        String cand1 = scs(i - 1, j, s1, s2) + a; // take from s1
        String cand2 = scs(i, j - 1, s1, s2) + b; // take from s2
        // choose shorter; if tie, choose lexicographically smaller
        if (cand1.length() != cand2.length()) {
            return memoStr[i][j] = (cand1.length() < cand2.length()) ? cand1 : cand2;
        }
        return memoStr[i][j] = (cand1.compareTo(cand2) <= 0) ? cand1 : cand2;
    }

    public static String shortestCommonSupersequence(String str1, String str2) {
        // ===== Approach 1: length table + backtrack (fast) =====
        int m = str1.length(), n = str2.length();
        // 1) Build SCS length table
        int[][] dp = new int[m + 1][n + 1];
        for (int r = 0; r <= m; r++) {
            dp[r][0] = r;
        }
        for (int c = 0; c <= n; c++) {
            dp[0][c] = c;
        }
        for (int i = 1; i <= m; i++) {
            char c1 = str1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = str2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        // 2) Backtrack to build SCS (from end to start)
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            char a = str1.charAt(i - 1);
            char b = str2.charAt(j - 1);
            if (a == b) {
                sb.append(a);
                i--;
                j--;
            } else if (dp[i - 1][j] < dp[i][j - 1]) {
                sb.append(a);
                i--;
            } else {
                sb.append(b);
                j--;
            }
        }
        // append leftovers
        while (i > 0) sb.append(str1.charAt(--i));
        while (j > 0) sb.append(str2.charAt(--j));
        return sb.reverse().toString();

        
    }
}
