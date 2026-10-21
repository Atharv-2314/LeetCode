class Solution {
    public int minOperations(String s) {
        boolean sorted = true;
        char min = s.charAt(0), max = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (cur < min)
                min = cur;
            
            if (cur > max)
                max = cur;

            if ((i != s.length() - 1) && (cur > s.charAt(i + 1))) 
                sorted = false;
        }

        if (sorted) return 0;
        if (s.length() == 2) return -1;

        if ((s.charAt(0) == min) || (s.charAt(s.length() - 1) == max))
            return 1;
        
        int minCount = 0, maxCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == min) minCount++;
            else if (s.charAt(i) == max) maxCount++;
        }

        if (((s.charAt(0) == max) && (maxCount == 1)) && ((s.charAt(s.length() - 1) == min)) && (minCount == 1))
            return 3;
        
        return 2;
    }
}