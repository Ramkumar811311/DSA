class Solution {
    static class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static int BFS(int ro, int co, int visited[][], int grid[][]) {
        int dr[] = { -1, 0, 1, 0 };
        int dc[] = { 0, -1, 0, 1 };
        visited[ro][co] = 1;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro, co));
        int count = 1;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.r;
            int col = p.c;

            for (int i = 0; i < 4; i++) {
                int nRow = row + dr[i];
                int nCol = col + dc[i];

                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && visited[nRow][nCol] == 0
                        && grid[nRow][nCol] == 1) {
                    count++;
                    visited[nRow][nCol] = 1;
                    q.add(new Pair(nRow, nCol));
                }
            }

        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int visited[][] = new int[m][n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    maxArea = Math.max(maxArea, BFS(i, j, visited, grid));
                }
            }
        }
        return maxArea;
    }
}