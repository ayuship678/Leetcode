class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] freq = new ArrayList[nums.length + 1];

        for(int i = 0; i <= nums.length; i++) {
            freq[i] = new ArrayList<>();
        }

       for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();
            freq[frequency].add(entry.getKey());
        }
        
        int[] res = new int[k];

        int ind = 0;
        for(int i = freq.length - 1; i >= 0; i--) {
            for(int num : freq[i]){
                res[ind++] = num;
                if(ind == k) {
                    return res;
                }
            }
        }

        return new int[0];
    }
}