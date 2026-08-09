class Solution {
    public int findChampion(int[][] grid) {
        int champian = 0;
        for (int i = 1; i < grid.length; i++) {
            if (grid[i][champian] == 1) {
                champian = i;
            }
        }
        return champian;
    }
}