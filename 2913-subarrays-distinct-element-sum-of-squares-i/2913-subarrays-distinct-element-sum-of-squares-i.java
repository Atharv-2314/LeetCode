class Solution {
    public int sumCounts(List<Integer> nums) {
        int sum = nums.size();
        int i = 0, size = 2, n = sum;
        
        while (size <= n) {
            int j = i + size;
            HashSet<Integer> hs = new HashSet<>();
            
            for (int x = i; x < j; x++)
                hs.add(nums.get(x));
            
            sum += (int) Math.pow(hs.size(), 2);
            i++;
            
            if (j == n) {
                i = 0;
                size++;
            }
        }
        
        return sum;
    }
}