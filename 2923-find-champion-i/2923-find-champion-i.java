class Solution {
    public int findChampion(int[][] grid) {
         int team[] = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == j) {
                    continue;
                }
                if (grid[i][j] == 1) {
                    team[i]++;
                }
            }
        }

        int winner = -1;
        int maxWin = -1;

        for (int i = 0; i < team.length; i++) {

            if (team[i] > maxWin) {
                maxWin = team[i];
                winner = i;
            }
        }
        return winner;
    }
}