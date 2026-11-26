class Solution {
    public boolean canAliceWin(int n) {
        int stones = 10;

        while (true) {
            if ((n < stones) && (stones % 2 == 0))
                return false;
            
            else if ((n < stones) && (stones % 2 != 0))
                return true;

            n -= stones;
            stones--;
        }
    }
}