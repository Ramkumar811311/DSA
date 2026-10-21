class Solution {
    public static class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void BFS(int ro, int co, int visited[][], char grid[][]) {
        int dr[] = { -1, 0, 1, 0 };
        int dc[] = { 0, -1, 0, 1 };
        visited[ro][co] = 1;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro, co));
        int m = grid.length;
        int n = grid[0].length;

        while (!q.isEmpty()) {
            int row = q.peek().r;
            int col = q.peek().c;
            q.poll();

            for (int k = 0; k < 4; k++) {
                int nRow = row + dr[k];
                int nCol = col + dc[k];

                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && visited[nRow][nCol] == 0
                        && grid[nRow][nCol] == '1') {
                    visited[nRow][nCol] = 1;
                    q.add(new Pair(nRow, nCol));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int visited[][] = new int[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    count++;
                    BFS(i, j, visited, grid);
                }
            }
        }
        return count;
    }
}