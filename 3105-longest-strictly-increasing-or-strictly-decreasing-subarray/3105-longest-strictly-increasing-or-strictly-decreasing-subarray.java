class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxInc = 0, maxDec = 0, inc = 1, dec = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1])
                inc++;
            
            else {
                if (inc > maxInc)
                    maxInc = inc;
                
                inc = 1;
            }

            if (nums[i] > nums[i + 1])
                dec++;
            
            else {
                if (dec > maxDec)
                    maxDec = dec;
                
                dec = 1;
            }
        }

        if (inc > maxInc) maxInc = inc;
        if (dec > maxDec) maxDec = dec;
        
        return Math.max(maxInc, maxDec);
    }
}