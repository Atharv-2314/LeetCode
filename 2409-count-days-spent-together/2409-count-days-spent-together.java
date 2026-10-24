class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] monthPrefix = new int[12];
        monthPrefix[0] = 0;
        
        for (int i = 1; i < 12; i++) 
            monthPrefix[i] = monthPrefix[i - 1] + months[i - 1];
            
        int AA = Integer.parseInt(arriveAlice.substring(3, 5)),
            LA = Integer.parseInt(leaveAlice.substring(3, 5)),
            AB = Integer.parseInt(arriveBob.substring(3, 5)),
            LB = Integer.parseInt(leaveBob.substring(3, 5));
        
        int mon = Integer.parseInt(arriveAlice.substring(0, 2));
        AA += monthPrefix[mon - 1];

        mon = Integer.parseInt(leaveAlice.substring(0, 2));
        LA += monthPrefix[mon - 1];

        mon = Integer.parseInt(arriveBob.substring(0, 2));
        AB += monthPrefix[mon - 1];

        mon = Integer.parseInt(leaveBob.substring(0, 2));
        LB += monthPrefix[mon - 1];
        
        if ((LA < AB) || (LB < AA))
            return 0;
        
        return Math.min(LA, LB) - Math.max(AA, AB) + 1;
    }
}