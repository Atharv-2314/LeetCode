class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1000000007;
        long oddCount = 0, evenCount = 1, 
            currentSum = 0, res = 0;

        for (int num : arr) {
            currentSum += num;
            
            if (currentSum % 2 != 0) {
                res = (res + evenCount) % mod;
                oddCount++;
            } 
            
            else {
                res = (res + oddCount) % mod;
                evenCount++;
            }
        }

        return (int) res;
    }
}