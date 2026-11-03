class Solution {
    public int minMoves(int[] nums) {
        int maxNum = nums[0], arrSum = 0, n = nums.length;

        for (int num : nums) {
            if (maxNum < num) maxNum = num;
            arrSum += num;
        }

        return maxNum * n - arrSum;
    }
}