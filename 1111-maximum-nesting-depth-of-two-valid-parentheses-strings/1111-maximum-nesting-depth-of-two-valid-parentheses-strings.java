class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        Stack<Character> stack = new Stack<>();
        int[] res = new int[seq.length()];
        int curDepth = 0;

        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                curDepth++;
                stack.push('(');

                if (curDepth % 2 == 0) 
                    res[i] = 1;
                
                else res[i] = 0;
            }

            else {
                stack.pop();

                if (curDepth % 2 == 0) 
                    res[i] = 1;
                
                else res[i] = 0;

                curDepth--;
            }
        }

        return res;
    }
}