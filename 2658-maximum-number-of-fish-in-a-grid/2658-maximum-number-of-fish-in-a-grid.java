class Solution {
    static class Pair{
        int r;
        int c;
        Pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    public static int BFS(int ro,int co,int[][] grid, int[][] visited){
        int dr[] = { -1, 0, 1, 0 };
        int dc[] = { 0, -1, 0, 1 };
        int m=grid.length;
        int n=grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro,co));
        visited[ro][co]=1;
        int noFish=grid[ro][co];
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row=p.r;
            int col=p.c;

            for(int i=0; i<4; i++){
                int nRow = dr[i] + row;
                int nCol = dc[i] + col;
                if (nRow < 0 || nRow >= m || nCol < 0 || nCol >= n || visited[nRow][nCol]==1 || grid[nRow][nCol]==0) {
                    continue;
                }
                noFish+=grid[nRow][nCol];
                visited[nRow][nCol]=1;
                q.add(new Pair(nRow,nCol));
            }
        }
        return noFish;
    }
    public int findMaxFish(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int visited[][]=new int[m][n];
        int maxFish=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0) continue;
                if(visited[i][j]==0){
                    maxFish=Math.max(maxFish,BFS(i,j,grid,visited));
                }
            }
        }

        return maxFish;

    }
}