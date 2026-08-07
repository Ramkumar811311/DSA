class Solution {
    public static void DFS(int node, int visited[],
            ArrayList<ArrayList<Integer>> adj) {
        visited[node] = 1;
        for (int it : adj.get(node)) {
            if (visited[it] == 0) {
                DFS(it, visited, adj);
            }
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int visited[] = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int edge[] : invocations) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }
        DFS(k, visited, adj);
        List<Integer> ans = new ArrayList<>();
        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];

            if (visited[u] == 0 && visited[v] == 1) {
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}