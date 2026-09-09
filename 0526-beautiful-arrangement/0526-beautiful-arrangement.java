
class Solution {
    private boolean okay(int a, int b) {
        return a % b == 0 || b % a == 0;
    }
    public int countArrangement(int n) {
        List<Integer> A = new ArrayList<>();
        for(int i = 0; i < n; i++) A.add(i + 1);
        Set<List<Integer>> visited = new HashSet<>();
        Deque<List<Integer>> Q = new LinkedList<>();
        visited.add(A);
        Q.add(A);
        while(!Q.isEmpty()) {
            A = Q.poll();
            for(int i = 0; i < n; i++) {
                for(int j = i + 1; j < n; j++) {
                    if(okay(A.get(i), j + 1) && okay(A.get(j), i + 1)) {
                        List<Integer> next = new ArrayList<>(A);
                        next.set(i, A.get(j));
                        next.set(j, A.get(i));
                        if(visited.add(next)) {
                            Q.add(next);
                        }
                    }
                }
            }
        }
        return visited.size();
    }
}