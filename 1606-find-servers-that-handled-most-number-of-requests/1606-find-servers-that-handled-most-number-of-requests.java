
import java.util.*;

class Solution {
    public List<Integer> busiestServers(
        int k, int[] arrival, int[] load
    ) {

        // Available servers
        TreeSet<Integer> available = new TreeSet<>();

        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        // Busy servers: [finishTime, serverId]
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        // Number of requests handled by each server
        int[] count = new int[k];

        // Process requests
        for (int i = 0; i < arrival.length; i++) {

            // 1. Release servers whose requests are completed
            while (!busy.isEmpty() &&
                   busy.peek()[0] <= arrival[i]) {

                long[] server = busy.poll();

                available.add((int) server[1]);
            }

            // If all servers are busy, drop the request
            if (available.isEmpty()) {
                continue;
            }

            // 2. Find the next available server
            int start = i % k;

            Integer server = available.ceiling(start);

            // Wrap around if necessary
            if (server == null) {
                server = available.first();
            }

            // 3. Assign request to the selected server
            available.remove(server);

            count[server]++;

            long finishTime = (long) arrival[i] + load[i];

            busy.offer(new long[]{finishTime, server});
        }

        // 4. Find maximum requests handled
        int maxRequests = 0;

        for (int c : count) {
            maxRequests = Math.max(maxRequests, c);
        }

        // 5. Collect busiest servers
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == maxRequests) {
                result.add(i);
            }
        }

        return result;
    }
}