class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (depth > 0)
                    res.append("(");

                depth++;
            }

            else {
                depth--;

                if (depth > 0)
                    res.append(")");
            }
        }

        return res.toString();
    }
}