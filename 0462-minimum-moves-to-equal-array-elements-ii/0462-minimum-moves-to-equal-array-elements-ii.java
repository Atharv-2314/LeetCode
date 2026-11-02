class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, res = 0;
        
        if (n % 2 != 0) {
            int median = nums[(n + 1) / 2 - 1]; 

            for (int num : nums)
                res += Math.abs(median - num);
        }

        else {
            int median1 = nums[(n + 1) / 2 - 1], median2 = nums[(n + 1) / 2],
                temp1 = 0, temp2 = 0;

            for (int num : nums) {
                temp1 += Math.abs(median1 - num);
                temp2 += Math.abs(median2 - num);
            }

            res = Math.min(temp1, temp2);
        }

        return res;
    }
}