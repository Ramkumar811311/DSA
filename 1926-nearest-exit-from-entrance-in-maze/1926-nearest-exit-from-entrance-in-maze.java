class Solution {
    static class Pair {
        int r;
        int c;
        int s;

        Pair(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }

    public static int BFS(int ro, int co, char maze[][], int visited[][]) {
        int m = maze.length;
        int n = maze[0].length;
        int dr[] = { -1, 0, 1, 0 };
        int dc[] = { 0, -1, 0, 1 };
        Queue<Pair> q = new LinkedList<>();
        visited[ro][co] = 1;
        q.add(new Pair(ro, co, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.r;
            int col = p.c;
            int step = p.s;
            for (int i = 0; i < 4; i++) {
                int nRow = dr[i] + row;
                int nCol = dc[i] + col;
                if (nRow < 0 || nRow >= m || nCol < 0 || nCol >= n) {
                    continue;
                } 
                else if ((nRow == 0 || nRow == m - 1 || nCol == 0 || nCol == n - 1) && maze[nRow][nCol]== '.' && !(nRow == ro && nCol == co)) {
                    return step+1;
                }
                else if (visited[nRow][nCol] == 0 && maze[nRow][nCol] == '.') {
                    visited[nRow][nCol] = 1;
                    q.add(new Pair(nRow, nCol, step + 1));
                }

            }
        }
        return -1;
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        int visited[][] = new int[maze.length][maze[0].length];

        return BFS(entrance[0], entrance[1], maze, visited);
    }
}