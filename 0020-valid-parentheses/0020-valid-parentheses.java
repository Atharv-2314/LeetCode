class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char brac = s.charAt(i);
            
            if ((brac == ')') && (!stack.isEmpty()) && (stack.peek() == '('))
                stack.pop();
            
            else if ((brac == '}') && (!stack.isEmpty()) && (stack.peek() == '{'))
                stack.pop();
            
            else if ((brac == ']') && (!stack.isEmpty()) && (stack.peek() == '['))
                stack.pop();
            
            else stack.push(brac);
        }

        return stack.isEmpty();
    }
}