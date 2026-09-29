class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if ((m + n) % 2 == 0) return false;

        boolean[][][] reachable = new boolean[m][n][m + n + 1];

        if (grid[0][0] == '(') 
            reachable[0][0][1] = true;

        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                for (int balance = 0; balance <= m + n; balance++) {
                    if (!reachable[i][j][balance]) continue;

                    if (i + 1 < m) 
                        update(reachable, i + 1, j, grid[i + 1][j], balance);
                    
                    if (j + 1 < n) 
                        update(reachable, i, j + 1, grid[i][j + 1], balance);
                }

        return reachable[m - 1][n - 1][0];
    }

    private void update(boolean[][][] reachable, int i, int j, char cell, int balance) {
        int nextBalance = balance + (cell == '(' ? 1 : -1);

        if (nextBalance >= 0) 
            reachable[i][j][nextBalance] = true;
    }
}