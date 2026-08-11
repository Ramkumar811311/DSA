class Solution {
    static class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static boolean BFS(int ro, int co, int grid1[][], int grid2[][], int visited[][]) {
        int dr[] = { -1, 0, 1, 0 };
        int dc[] = { 0, -1, 0, 1 };
        int m = grid2.length;
        int n = grid2[0].length;
        visited[ro][co] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro, co));
        boolean isSubIsland = true;
        if (grid1[ro][co] == 0) {
            isSubIsland = false;
        }

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.r;
            int col = p.c;

            for (int i = 0; i < 4; i++) {
                int nRow = dr[i] + row;
                int nCol = dc[i] + col;

                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && visited[nRow][nCol] == 0
                        && grid2[nRow][nCol] == 1) {
                    if (grid1[nRow][nCol] == 0 && grid2[nRow][nCol] == 1) {
                        isSubIsland = false;
                    }

                    visited[nRow][nCol] = 1;
                    q.add(new Pair(nRow, nCol));
                }
            }
        }
        return isSubIsland;

    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;

        int subIland = 0;

        int visited[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && visited[i][j] == 0 && BFS(i, j, grid1, grid2, visited)) {
                    subIland++;
                }
            }
        }
        return subIland;
    }
}