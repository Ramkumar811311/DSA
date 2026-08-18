class Solution {
    static class Pair {
        int r;
        int c;
        int h;

        Pair(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }

    public int[][] highestPeak(int[][] isWater) {
        int dr[] = { -1, 0, 1, 0 };
        int dc[] = { 0, -1, 0, 1 };
        int m=isWater.length;
        int n=isWater[0].length;
        int ans[][]=new int[m][n];
        int visited[][]=new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(isWater[i][j]==0) continue;
                q.add(new Pair(i,j,0));
                visited[i][j]=1;
                ans[i][j]=0;
            }
        }
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row=p.r;
            int col=p.c;
            int height=p.h;
            ans[row][col]=height;

            for(int i=0; i<4; i++){
                int nRow = dr[i] + row;
                int nCol = dc[i] + col;
                if (nRow < 0 || nRow >= m || nCol < 0 || nCol >= n || isWater[nRow][nCol]==1 || visited[nRow][nCol]==1) {
                    continue;
                }
                visited[nRow][nCol] = 1;
                q.add(new Pair(nRow, nCol, height+1));
            }
        }
        return ans;
    }
}