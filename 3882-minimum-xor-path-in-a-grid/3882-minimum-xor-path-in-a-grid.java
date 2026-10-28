class Solution {
    int res = Integer.MAX_VALUE;
    int[] dr = {1,0};
    int[] dc = {0,1};
    public int minCost(int[][] grid) {

        boolean[][][] dp = new boolean[grid.length][grid[0].length][1024];
        
        maxXor(grid,0,0,0,dp);
        return res==Integer.MAX_VALUE?0:res;
    }

    public void maxXor(int[][] grid,int row,int col,int temp,boolean[][][] dp){

        temp = temp^grid[row][col];
        if(dp[row][col][temp])
            return;
        
        
        dp[row][col][temp] = true;
        
        if(row==grid.length-1&&col==grid[0].length-1){
            res = Math.min(res,temp);
            return;
        }

        for(int i=0;i<2;i++){
            int newr = dr[i]+row;
            int newc = dc[i]+col;
            if(newr<0||newr>=grid.length||newc<0||newc>=grid[0].length)
               continue;
            
            maxXor(grid,newr,newc,temp,dp);
        }

    }
}