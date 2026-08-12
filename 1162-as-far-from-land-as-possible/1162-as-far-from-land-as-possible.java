class Solution {
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

    public static int BFS(int grid[][], int visited[][]) {
        int m = grid.length;
        int n = grid[0].length;
        int dr[] = { -1, 0, 1, 0 };
        int dc[] = { 0, -1, 0, 1 };

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = 1;
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        int maxDist = -1;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.r;
            int col = p.c;
            int dis = p.d;
            maxDist = Math.max(maxDist, dis);
            for (int i = 0; i < 4; i++) {
                int nRow = dr[i] + row;
                int nCol = dc[i] + col;
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && visited[nRow][nCol] == 0) {
                    visited[nRow][nCol] = 1;
                    q.add(new Pair(nRow, nCol, dis + 1));
                }
            }
        }
        return maxDist;
    }

    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int visited[][] = new int[m][n];
        int ans = BFS(grid, visited);
        return ans == 0 ? -1 : ans;
    }
}