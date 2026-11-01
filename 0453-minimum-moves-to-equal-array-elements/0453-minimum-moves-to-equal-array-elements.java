class Solution {
    public int minMoves(int[] nums) {
        int base = nums[0];

        for (int n : nums)
            if (n < base)
                base = n;
            
        int res = 0;

        for (int n : nums)
            res += (n - base);
        
        return res;
    }
}