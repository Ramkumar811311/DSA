class Solution {
    static class Pair {
        int sq;
        int stp;

        Pair(int sq, int stp) {
            this.sq = sq;
            this.stp = stp;
        }
    }

    public static int BFS(int board[][], int visited[][]) {
        int n = board.length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, 0));
        visited[n - 1][0] = 1;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            // int row = p.r;
            // int col = p.c;
            int square = p.sq;
            int step = p.stp;
            if (square == n * n) {
                return step;
            }

            for (int i = 1; i <= 6; i++) {
                int nSq = square + i;
                if (nSq > n * n) {
                    break;
                }
                int nRow = n - 1 - (nSq - 1) / n;
                int nCol = (nSq - 1) % n;
                // Boustrophedon
                if ((n - 1 - nRow) % 2 == 1) {
                    nCol = n - 1 - nCol;
                }
                int dest = nSq;
                if (board[nRow][nCol] != -1) {
                    dest=board[nRow][nCol];
                }
                // Find row and column of destination
                int dRow = n - 1 - (dest - 1) / n;

                int dCol = (dest - 1) % n;

                if ((n - 1 - dRow) % 2 == 1) {
                    dCol = n - 1 - dCol;
                }
                if (visited[dRow][dCol]==0) {
                    visited[dRow][dCol]=1;
                    q.add(new Pair(dest, step+1));
                }

            }
        }
        return -1;
    }
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int visited[][] = new int[n][n];
        return BFS(board, visited);
    }
}