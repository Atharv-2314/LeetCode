class Solution {
    public int minInsertions(String s) {
        int insertions = 0, open = 0, i = 0;
        
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                open++;
                i++;
            } 
            
            else { 
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') 
                    i += 2;
                
                else {
                    insertions++;
                    i++;
                }
                
                if (open > 0) open--; 
                else insertions++; 
            }
        }
        
        insertions += open * 2; 
        return insertions;
    }
}
