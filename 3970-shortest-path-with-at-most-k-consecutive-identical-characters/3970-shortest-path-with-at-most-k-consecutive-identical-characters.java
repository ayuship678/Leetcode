class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[] {edge[1], edge[2]});
        }

        char[] arr = labels.toCharArray();

        int[][] dp = new int[n][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        dp[0][1] = 0;
        pq.offer(new int[] {0, 1, 0}); // cost, freq, node

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int cost = curr[0];
            int freq = curr[1];
            int node = curr[2];

            if (node == n - 1) {
                return cost;
            }

            if (cost > dp[node][freq]) {
                continue;
            }

            for (int[] next : graph.get(node)) {
                int nextNode = next[0];
                int weight = next[1];

                int nextFreq = 1;
                if (arr[node] == arr[nextNode]) {
                    nextFreq += freq;
                }

                if (nextFreq > k) {
                    continue;
                }

                int nextCost = cost + weight;

                if (nextCost < dp[nextNode][nextFreq]) {
                    dp[nextNode][nextFreq] = nextCost;
                    pq.offer(new int[] {nextCost, nextFreq, nextNode});
                }
            }
        }

        return -1;
    }
}