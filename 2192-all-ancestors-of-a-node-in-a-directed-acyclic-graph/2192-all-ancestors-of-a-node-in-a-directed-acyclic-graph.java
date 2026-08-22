class Solution {
     public static void DFS(int src, int node, List<List<Integer>> adj, List<HashSet<Integer>> ans, boolean visited[]) {
        if (visited[node] == true) {
            return;
        }
        visited[node] = true;
        for (int next : adj.get(node)) {
            if (visited[next] == false) {
                ans.get(next).add(src);
                DFS(src, next, adj, ans, visited);
            }
        }
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        List<HashSet<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(new HashSet<>());
        }
        for (int i = 0; i < n; i++) {
            boolean visited[] = new boolean[n];
            DFS(i, i, adj, ans, visited);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>(ans.get(i));
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
}