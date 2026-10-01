class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count=0,total=0;
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]-nums[i-1] == nums[i+1]-nums[i]){
                count++;
                total+=count;
            }
            else{
                count=0;
            }
        }
        return total;
    }
}