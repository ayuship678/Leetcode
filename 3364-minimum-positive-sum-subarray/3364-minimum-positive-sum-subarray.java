class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int sum = Integer.MAX_VALUE;

        for(int i=l; i<=r; i++) {
            int sub = 0;
            for(int j=0; j<nums.size(); j++) {
                sub += nums.get(j);

                if(j >= i) {
                    sub -= nums.get(j-i);
                }

                if(j >= i-1 && sub > 0) {
                    sum = Math.min(sum, sub);
                }
            }
        }
        return sum == Integer.MAX_VALUE ? -1 : sum;
    }
}