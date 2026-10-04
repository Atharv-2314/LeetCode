class Solution {
    private boolean backtrack(String s, int index, int open, Boolean[][] memo) {
        if (memo[index][open] != null)
            return memo[index][open];

        if (index == s.length()) 
            return open == 0;
        
        if (open > s.length() - index)
            return false;
        
        char ch = s.charAt(index);
        boolean result;

        if (ch == '(') 
            result = backtrack(s, index + 1, open + 1, memo);
        
        else if (ch == ')') {
            if (open == 0) 
                return false;
            
            result = backtrack(s, index + 1, open - 1, memo);
        }

        else 
            result = backtrack(s, index + 1, open + 1, memo)
                || backtrack(s, index + 1, open, memo)
                || ((open > 0) && backtrack(s, index + 1, open - 1, memo));

        memo[index][open] = result;
        return result;
    }
    
    public boolean checkValidString(String s) {
        Boolean[][] memo = new Boolean[s.length() + 1][s.length() + 1];
        return backtrack(s, 0, 0, memo);
    }
}