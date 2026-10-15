class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        boolean[] visit = new boolean[101];
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            Arrays.fill(visit, false);
            int u = 0;

            for (int j = i; j < n; j++) {
                if (!visit[nums.get(j)]) {
                    visit[nums.get(j)] = true;
                    u++;
                }

                ans += u * u;
            }
        }

        return ans;
    }
}