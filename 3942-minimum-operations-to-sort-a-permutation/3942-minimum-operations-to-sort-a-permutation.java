
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length, start = nums[0];
        boolean ascending = true, descending = true;

        for (int i = 0; i < n; i++) {
            if (nums[i] != (start + i) % n)
                ascending = false;

            if (nums[i] != (start - i + n) % n)
                descending = false;
        }

        if (ascending) {
            if (start == 0)
                return 0;

            return Math.min(n - start, start + 2);
        }

        if (descending) {
            int shift = (n - 1 - start + n) % n;
            return Math.min(shift + 1, n - shift + 1);
        }

        return -1;
    }
}