class Solution {
    static class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void BFS(int ro, int co, int[][] grid, int[][] visited) {
        int dr[] = { -1, 0, 1, 0 };
        int dc[] = { 0, -1, 0, 1 };
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro, co));
        visited[ro][co] = 1;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.r;
            int col = p.c;

            for (int i = 0; i < 4; i++) {
                int nRow = dr[i] + row;
                int nCol = dc[i] + col;

                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && visited[nRow][nCol] == 0
                        && grid[nRow][nCol] == 0) {
                    visited[nRow][nCol] = 1;
                    q.add(new Pair(nRow, nCol));
                }
            }
        }
    }
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int visited[][] = new int[m][n];

        // for boundary BFS
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0 && visited[i][0] == 0) {
                BFS(i, 0, grid, visited);
            }
        }
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 0 && visited[0][i] == 0) {
                BFS(0, i, grid, visited);
            }
        }

        for (int i = 0; i < m; i++) {
            if (grid[i][n - 1] == 0 && visited[i][n - 1] == 0) {
                BFS(i, n - 1, grid, visited);
            }
        }
        for (int i = 0; i < n; i++) {
            if (grid[m - 1][i] == 0 && visited[m - 1][i] == 0) {
                BFS(m - 1, i, grid, visited);
            }
        }

        int NoOfClosedIland = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 0) {
                    NoOfClosedIland++;
                    BFS(i, j, grid, visited);
                }
            }
        }
        return  NoOfClosedIland;
    }
}