class Solution {
    public String reverseParentheses(String s) {
        int i = 0, bracFound = -1;
        String res = "";

        while (i < s.length()) {
            bracFound = (s.charAt(i) == '(' ? 0 : -1);
            
            if (bracFound == -1)
                res += s.charAt(i);
            
            else {
                Stack<Character> stack = new Stack<>();
                
                while (true) {
                    if (s.charAt(i) == ')') {
                        String temp = "";
                        
                        while (stack.peek() != '(') 
                            temp += stack.pop();
                        
                        stack.pop();
                        bracFound--;
                        
                        if (bracFound == 0) {
                            res += temp;
                            break;
                        }
                        
                        else 
                            for (int j = 0; j < temp.length(); j++)
                                stack.push(temp.charAt(j));
                    }
                    
                    else if (s.charAt(i) == '(') {
                        stack.push('(');
                        bracFound++;
                    }
                    
                    else stack.push(s.charAt(i));
                    
                    i++;
                }
            }
            
            i++;
        }

        return res;
    }
}