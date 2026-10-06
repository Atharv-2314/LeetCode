class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int open = 0, close = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (s.charAt(i) == '(') {
                stack.push('(');
                close++;
            }
                
            else {
                if (stack.isEmpty())
                    open++;
                
                else {
                    stack.pop();
                    close--;
                }
            }
        }

        return open + close;
    }
}