class Solution {
    public long minOperations(int[] nums, int x, int k) {
        //inc or dec elements in order to make subaarray elemetns equal
        //for a given subarray number of incs or decs (ops) to make all equal is dependent on value making all equal to. [Sum(Abs(num-val))].
        //this sum of differences is minimized at median, so for a given subarray, always choose to make values equal to a median of the subarray (med for odd len, any number betwee l and r med for ev)
        //so can get the cost for a fixed subarrray of sz x.
        //can use a dp array that holds the miin ops to make j eq x subarrays up to the current index i, and use this alongside sliding window for the current subarray
        //note: since subarrays must be non-overlapping, also need to hold the value of the previous "x-equal subarray" end in the dp state
        //let dp[i][j][s] = min ops to make j x-equal subarrays in window up to i with last ending at j. 
        //holding window and last end seems redundant, can just hold wiindow up to i and deduce prev itr from there 
        //dp[i][j] = min ops to make j x-equal subarrays from prefiix [0, i-1]
        //dp[i][j] = MIN(dp[i-1][j], dp[i-x][j-1] + absDev from median [i-x, i).
        //need way to compute absDev from median in an efficient sliding window.
        //question is once have first median and abs dev, how to modify upon adding one val and removing another (sliding the window)
        //since am getting new median after one change, similar to median of data stream, where maintain two heaps. 
        //however, need to also remove element, not just add like in datastream. 
        //heap removal is O(N), so maybe use two treesets instead which allow log(n) for removal 
        //to get abs deviation, maintian an abs deviation of the left set from median as well as the right. 
        //once a new value is added. 
        int n = nums.length;
        long[][] dp = new long[n+1][k+1];
        for(int i = 0; i <= n; i++) {
            for(int j = 1; j <= k; j++) dp[i][j] = (1L << 40); //put infinity as base case for forming non-zero counts of arrs.
        }
        //use int[] for treeset to pair val with index to allow for dupe vals in set.
        TreeSet<int[]> leftSet = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        TreeSet<int[]> rightSet = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);

        
        for(int i = 0; i < x; i++) {
            leftSet.add(new int[]{nums[i], i});
            rightSet.add(leftSet.pollLast());
            if(leftSet.size() < rightSet.size()) {
                leftSet.add(rightSet.pollFirst());
            }
        }

        //dev = sum(rightSet) - sum(leftSet) + med*(leftSet.size()-rightSet.size()) (for left dev += med-num, right dev += num-med so get formula by taking out const meds leaving sums)
        long rSum = 0, lSum = 0;
        for(int[] num : leftSet) lSum += num[0];
        for(int[] num : rightSet) rSum += num[0];
        
        for(int i = x; i <= n; i++) {
            long dev = rSum - lSum + (long)(leftSet.last()[0])*(leftSet.size()-rightSet.size());
            for(int sz = 1; sz <= k; sz++) {
                dp[i][sz] = Math.min(dp[i-1][sz], dev + dp[i-x][sz-1]);
            }
            if(i == n) break;
            //now need to process adding nums[i], removing nums[i-x], and change effects on median and dev.
            int[] add = new int[]{nums[i], i}, del = new int[]{nums[i-x], i-x};
            if(leftSet.contains(del)) {
                lSum -= del[0];
                leftSet.remove(del);
            } else {
                rSum -= del[0];
                rightSet.remove(del);
            }
            
            leftSet.add(add);
            lSum += add[0] - leftSet.last()[0];
            rSum += leftSet.last()[0];
            rightSet.add(leftSet.pollLast());
            
            if(leftSet.size() < rightSet.size()) {
                rSum -= rightSet.first()[0];
                lSum += rightSet.first()[0];
                leftSet.add(rightSet.pollFirst());
            }
        }

        return dp[n][k];
        
    }
}