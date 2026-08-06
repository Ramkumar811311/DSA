class Solution {
    static int timer = 1;

    public static void DFS(int node, int parent, ArrayList<ArrayList<Integer>> adj, int visited[], int dt[], int low[],
            List<List<Integer>> bridges) {
        visited[node] = 1;
        dt[node] = low[node] = timer;
        timer++;

        for (int it : adj.get(node)) {
            if (it == parent) {
                continue;
            }

            else if (visited[it] == 0) {
                DFS(it, node, adj, visited, dt, low, bridges);
                low[node] = Math.min(low[node], low[it]);
                if (low[it] > dt[node]) {
                    bridges.add(Arrays.asList(it, node));
                }
            } else {
                low[node] = Math.min(low[node], dt[it]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int visited[] = new int[n];
        int dt[] = new int[n];
        int low[] = new int[n];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        List<List<Integer>> bridges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                DFS(i, -1, adj, visited, dt, low, bridges);
            }
        }
        return bridges;
    }
}