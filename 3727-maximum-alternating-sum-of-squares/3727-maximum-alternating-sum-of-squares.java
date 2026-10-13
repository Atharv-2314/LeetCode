class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        int mid = n / 2;
        long res = 0;
        
        for (int i = 0; i < n; i++)
            if (nums[i] < 0)
                nums[i] *= -1;
                
        Arrays.sort(nums);
       
        
        for (int i = 0; i < mid; i++) {
            res -= (nums[i] * nums[i]);
            res += (nums[i + mid] * nums[i + mid]);
        }
        
        return (n % 2 == 0) ? res : (res + nums[n - 1] * nums[n - 1]);
    }
}