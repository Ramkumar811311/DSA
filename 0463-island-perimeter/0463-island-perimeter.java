class Solution {
    static class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static int BFS(int ro, int co, int grid[][], int visited[][]) {
        int dr[] = { -1, 0, 1, 0 };
        int dc[] = { 0, -1, 0, 1 };
        int m = grid.length;
        int n = grid[0].length;
        visited[ro][co] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro, co));
        int perimeter = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.r;
            int col = p.c;

            for (int i = 0; i < 4; i++) {
                int nRow = dr[i] + row;
                int nCol = dc[i] + col;
                if (nRow < 0 || nRow >= m ||
                        nCol < 0 || nCol >= n) {

                    perimeter++;
                    continue;
                }

                else if (grid[nRow][nCol] == 0) {
                    perimeter++;
                } else if (visited[nRow][nCol] == 0 && grid[nRow][nCol] == 1) {
                    visited[nRow][nCol] = 1;
                    q.add(new Pair(nRow, nCol));
                }
            }
        }
        return perimeter;

    }

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = -1;
        int visited[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {

                    ans = BFS(i, j, grid, visited);

                }
            }
        }
        return ans;
    }
}