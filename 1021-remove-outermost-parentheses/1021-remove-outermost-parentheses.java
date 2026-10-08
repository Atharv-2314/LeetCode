class Solution {
    public String removeOuterParentheses(String s) {
        String res = "";
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (depth > 0)
                    res += "(";

                depth++;
            }

            else {
                depth--;

                if (depth > 0)
                    res += ")";
            }
        }

        return res;
    }
}