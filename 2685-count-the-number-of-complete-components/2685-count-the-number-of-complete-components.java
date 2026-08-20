class Solution {
    public static boolean BFS(int src, int visited[], ArrayList<ArrayList<Integer>> adj) {
        int vertices = 0;
        int edgeCount = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = 1;
        while (!q.isEmpty()) {
            int node = q.poll();
            vertices++;
            for (int neighbour : adj.get(node)) {
                edgeCount++;
                if (visited[neighbour] == 0) {
                    visited[neighbour] = 1;
                    q.add(neighbour);
                }
            }
        }
        edgeCount /= 2;
        int requiredEdges = vertices * (vertices - 1) / 2;
        return requiredEdges == edgeCount;
    }

    public int countCompleteComponents(int n, int[][] edges) {
        int visited[] = new int[n];
        int ans = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (BFS(i, visited, adj)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}