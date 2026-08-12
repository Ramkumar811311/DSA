class Solution {
    static class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void BFS(int ro, int co, int grid[][], int visited[][], int ans[][], int color) {
        int dr[] = { -1, 0, 1, 0 };
        int dc[] = { 0, -1, 0, 1 };
        int m = grid.length;
        int n = grid[0].length;
        visited[ro][co] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro, co));
        int intialColor = grid[ro][co];

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.r;
            int col = p.c;
            boolean isBorder = false;
            for (int i = 0; i < 4; i++) {
                int nRow = dr[i] + row;
                int nCol = dc[i] + col;
                if (nRow < 0 || nRow >= m || nCol < 0 || nCol >= n) {
                    isBorder = true;
                } else if (grid[nRow][nCol] != intialColor) {
                    isBorder = true;
                } else if (visited[nRow][nCol] == 0) {
                    visited[nRow][nCol] = 1;
                    q.add(new Pair(nRow, nCol));
                }
            }
            if (isBorder) {
                ans[row][col] = color;
            }
        }
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;

        int visited[][] = new int[m][n];
        int ans[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = grid[i][j];
            }
        }

        BFS(row, col, grid, visited, ans, color);
        return ans;
    }
}