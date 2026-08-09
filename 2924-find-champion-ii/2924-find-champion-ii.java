class Solution {
    public int findChampion(int n, int[][] edges) {
        int team[]=new int[n];

        for(int edge[] : edges){
            int u=edge[0];
            int v=edge[1];
            team[v]++;
        }

        int champian=-1;

        for(int i=0;i<n; i++){
            if(team[i]==0){
                if(champian!=-1){
                    return -1;
                }
                champian=i;
            }
        }
        return champian;
    }
}