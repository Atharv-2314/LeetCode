class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long cost = 0;

        if (costBoth < cost1 + cost2) {
            int low = Math.min(need1, need2);
            cost += (long) low * costBoth;
            need1 -= low;
            need2 -= low;
        }

        if (need1 > 0) 
            cost += (long) Math.min(costBoth, cost1) * need1;
        

        if (need2 > 0) 
            cost += (long) Math.min(costBoth, cost2) * need2;

        return cost;
    }
}