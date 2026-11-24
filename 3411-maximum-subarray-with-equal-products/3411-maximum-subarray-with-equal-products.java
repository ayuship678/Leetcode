class Solution {
    public long findGcd(long a, long b) {
        if(b == 0) return a;
        return findGcd(b, a % b);
    }

    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for(int i=0; i<n; i++) {
            long gcd = 0;
            long lcm = 1;
            long product = 1;

            for(int j=i; j<n; j++) {
                product *= nums[j];

                gcd = findGcd(gcd, nums[j]);
                lcm = (lcm / findGcd(lcm, nums[j])) * nums[j];

                if(product == gcd * lcm) {
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }

        return maxLen;
    }
} 