class Solution {

    public boolean check(int[] nums) {

        int missed = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (nums[i] > nums[(i + 1) % n]) {
                //making it a circular array by %n
                missed++;
            }
        }

        if (missed <= 1) {
            return true;
        }
        return false;
    }
}
//Please click the ⬆️ UPARROW ⬆️ button in the bottom left corner of your screen

//That means you Like👍the solution