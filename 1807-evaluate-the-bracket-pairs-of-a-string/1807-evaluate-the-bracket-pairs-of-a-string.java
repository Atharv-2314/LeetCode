class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        String res = "", sub = "";
        int len = s.length(), start = 0, end = 0;
        HashMap<String, String> hm = new HashMap<>();
        
        for (List<String> entry : knowledge) 
            hm.put(entry.get(0), entry.get(1));
        
        while (end < len) {
            if (s.charAt(end) == '(') {
                res += s.substring(start, end);
                start = end + 1;
            }
            
            else if (s.charAt(end) == ')') {
                sub = s.substring(start, end);
                res += (hm.get(sub) == null ? "?" : hm.get(sub));
                start = end + 1;
            }
            
            end++;
        }
        
        if (start != end) 
            res += s.substring(start, end);
        
        return res;
    }
}