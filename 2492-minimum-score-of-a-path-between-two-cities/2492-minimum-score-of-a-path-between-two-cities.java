class Solution {
    static int ans = Integer.MAX_VALUE;

    public void DFS(int node, boolean[] visited,
            ArrayList<ArrayList<ArrayList<Integer>>> adj) {

        visited[node] = true;

        for (ArrayList<Integer> edge : adj.get(node)) {

            ans = Math.min(ans, edge.get(1));

            int next = edge.get(0);

            if (!visited[next]) {
                DFS(next, visited, adj);
            }
        }
    }

    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : roads) {
            int u = edge[0];
            int v = edge[1];
            int d = edge[2];

            ArrayList<Integer> temp1 = new ArrayList<>();
            ArrayList<Integer> temp2 = new ArrayList<>();
            temp1.add(v);
            temp1.add(d);
            temp2.add(u);
            temp2.add(d);

            adj.get(u).add(temp1);
            adj.get(v).add(temp2);
        }
        boolean[] visited = new boolean[n + 1];
        ans = Integer.MAX_VALUE;
        DFS(1, visited, adj);
        return ans;
    }
}