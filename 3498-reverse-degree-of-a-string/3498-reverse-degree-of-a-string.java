class Solution {
    public int reverseDegree(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int c = (int)(s.charAt(i));
            sum += ((i + 1) * (123 - c));
        }

        return sum;
    }
}