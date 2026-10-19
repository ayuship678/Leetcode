import java.util.*;

class Solution {
      public List<Integer> targetIndices(int[] nums, int target) {

            // Store the target indices
            List<Integer> res = new ArrayList<>();

            // Sort the array in ascending order
            Arrays.sort(nums);

            // Traverse the sorted array
            for (int i = 0; i < nums.length; i++) {

                  // If the current element matches the target,
                  // add its index to the result
                  if (nums[i] == target) {
                        res.add(i);
                  }
            }

            // Return all target indices
            return res;
      }
}