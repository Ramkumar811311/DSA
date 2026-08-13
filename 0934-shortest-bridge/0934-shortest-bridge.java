class Solution {
    static int dr[] = { -1, 0, 1, 0 };
    static int dc[] = { 0, -1, 0, 1 };

    static class Pair {
        int r;
        int c;
        int d;

        Pair(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    public static int BFS(Queue<Pair> q, int grid[][]) {
        int m = grid.length, n = grid[0].length;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.r;
            int col = p.c;
            int dis = p.d;

            for (int i = 0; i < 4; i++) {
                int nRow = dr[i] + row;
                int nCol = dc[i] + col;
                if (nRow < 0 || nRow >= m || nCol < 0 || nCol >= n) {
                    continue;
                } else if (grid[nRow][nCol] == 1) {
                    return dis;
                } else if (grid[nRow][nCol] ==0) {
                    grid[nRow][nCol] = 2;
                    q.add(new Pair(nRow, nCol, dis + 1));
                }

            }
        }
        return 0;
    }
    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean isIland = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (!isIland) {
                        q.add(new Pair(i, j, 0));
                        DFS(i, j, grid, q);
                        isIland = true;
                    }
                }
            }
        }
        return BFS(q, grid);
    }
    public static void DFS(int ro, int co, int grid[][], Queue<Pair> q) {
        grid[ro][co] = 2;
        for (int i = 0; i < 4; i++) {
            int nRow = dr[i] + ro;
            int nCol = dc[i] + co;
            if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && grid[nRow][nCol] == 1) {
                q.add(new Pair(nRow, nCol, 0));
                grid[nRow][nCol] = 2;
                DFS(nRow, nCol, grid, q);
            }
        }
    }
}