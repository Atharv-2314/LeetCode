class Solution {
    public int sortPermutation(int[] nums) {
        int res = 0;
        boolean sorted = true;

        for (int i = 0; i < nums.length; i++) 
            if (i != nums[i]) {
                if (sorted) {
                    sorted = false;
                    res = nums[i];
                }

                else res = res & nums[i];
            }

        return res;
    }
}