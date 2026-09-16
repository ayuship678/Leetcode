class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int n = nums.length;

        // Stores each element and its frequency
        Map<Integer, Integer> map = new HashMap<>();

        // Stores the elements appearing more than n/3 times
        List<Integer> result = new ArrayList<>();

        // Step 1: Count frequency of every element
        for (int i = 0; i < n; i++) {

            int num = nums[i];

            // If the element already exists,
            // increase its frequency
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }

            // Otherwise, add it with frequency 1
            else {
                map.put(num, 1);
            }
        }

        // Step 2: Find elements appearing more than n/3 times
        for (int i = 0; i < n; i++) {

            // Check whether the element exists in the map
            // and whether its frequency is greater than n/3
            if (map.containsKey(nums[i]) &&
                map.get(nums[i]) > n / 3) {

                // Add the majority element to the result
                result.add(nums[i]);

                // Remove it to prevent duplicate additions
                map.remove(nums[i]);
            }
        }

        return result;
    }
}