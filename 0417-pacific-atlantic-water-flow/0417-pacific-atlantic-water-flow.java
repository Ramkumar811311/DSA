class Solution {
    static class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static Boolean BFS(int ro, int co, int[][] heights) {
        int dr[] = { -1, 0, 1, 0 };
        int dc[] = { 0, -1, 0, 1 };
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];

        boolean isPacific = false;
        boolean isAtlantic = false;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro, co));
        visited[ro][co] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.r;
            int col = p.c;
            if (row == 0 || col == 0) {
                isPacific = true;
            }
            if (row == m - 1 || col == n - 1) {
                isAtlantic = true;
            }
            if (isPacific && isAtlantic) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int nRow = dr[i] + row;
                int nCol = dc[i] + col;

                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && !visited[nRow][nCol]
                        && heights[nRow][nCol] <= heights[row][col]) {
                    visited[nRow][nCol] = true;
                    q.add(new Pair(nRow, nCol));
                }
            }
        }

        return false;
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (BFS(i, j, heights)) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
}