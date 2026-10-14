class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();
        int cur = num;

        while (cur > 0) {
            if ((cur == 1) && (sum > 9))
                return "";

            int digit = (sum > 8) ? 9 : sum;
            
            sb.append(digit);
            sum -= digit;
            cur--;
        }

        return sb.toString();
    }
}