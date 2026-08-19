class Solution {
    public static boolean isGraphBiparitie(int src,ArrayList<ArrayList<Integer>> adj,int color[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        color[src]=0;
        while(!q.isEmpty()){
            int node= q.poll();
            for(int it : adj.get(node)){
                if(color[it]==-1){
                    color[it]=1-color[node];
                    q.add(it);
                }
                if(color[it]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        int color[] = new int[n + 1];
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            color[i] = -1;
            adj.add(new ArrayList<>());
        }

        for (int[] dislike : dislikes) {
            int u = dislike[0];
            int v = dislike[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                if (isGraphBiparitie(i, adj, color) == false) {
                    return false;
                }
            }
        }
        return true;
    }
}