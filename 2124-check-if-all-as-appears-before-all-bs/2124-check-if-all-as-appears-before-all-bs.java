class Solution {
    public boolean checkString(String s) {
        boolean bfound = false;

        for (char ch : s.toCharArray()) {
            if ((ch == 'b') && (bfound == false))
                bfound = true;
            
            if ((ch == 'a') && (bfound == true))
                return false;
        }

        return true;
    }
}