class Solution {
    static final int MOD = 1000000007;
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long dp[][] = new long[m][n];

        for(int i = 0; i < m; i++){   
            if(grid[i][0] == 1)break;
            dp[i][0] = 1;
        }
        for(int i = 1; i < n; i++){   
            if(grid[0][i] == 1)break;
            dp[0][i] = 1;
        }


        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }

                int r = i, c= j-1;
                boolean left = true;
                long add = 0;
                while(r>=0 && c>=0){
                    if (grid[r][c] == 0) {
                        add = dp[r][c];
                        break;
                    }
                    if (left) {
                        r--;
                    }
                    else{
                        c--;
                    }
                    left = !left;
                }
                dp[i][j] = (dp[i][j]+add)%MOD;

                r = i-1; c = j;
                left = false;
                add = 0;
                while(r>=0 && c>=0){
                    if (grid[r][c] == 0) {
                        add = dp[r][c];
                        break;
                    }
                    if (left) {
                        r--;
                    }
                    else{
                        c--;
                    }
                    left = !left;
                }

                dp[i][j] = (dp[i][j]+add)%MOD;

               
            }
        }

        return (int)dp[m-1][n-1];
    }
}