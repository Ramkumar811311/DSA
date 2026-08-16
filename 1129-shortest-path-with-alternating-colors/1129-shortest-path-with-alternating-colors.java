class Solution {
    static class Edge {
        int node;
        int color;

        Edge(int node, int color) {
            this.node = node;
            this.color = color;
        }
    }

    static class Pair {
        int node;
        int color;
        int step;

        Pair(int node, int color, int step) {
            this.node = node;
            this.color = color;
            this.step = step;
        }
    }

    public static void BFS(ArrayList<Edge>[] adj, int n,int ans[]) {
        // Initially every answer is -1
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
        }

        boolean[][] visited = new boolean[n][2];

        Queue<Pair> q = new LinkedList<>();

        // We can start with either color.
        // 0 = RED
        // 1 = BLUE

        q.add(new Pair(0, 0, 0));
        q.add(new Pair(0, 1, 0));

        visited[0][0] = true;
        visited[0][1] = true;

        ans[0] = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int node = p.node;
            int color = p.color;
            int step = p.step;
            int nextColor=1-color;
            for (Edge e:adj[node]) {
                if (e.color!=nextColor) {
                    continue;
                }
                if (visited[e.node][e.color]) {
                    continue;
                }
                visited[e.node][e.color]=true;
                ans[e.node] = Math.min(
                    ans[e.node] == -1 ? Integer.MAX_VALUE : ans[e.node],
                    step + 1
                );

                q.add(new Pair(e.node, e.color, step + 1));
            }
        }

    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int ans[] = new int[n];
        ArrayList<Edge>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int redEdge[] : redEdges) {
            int u = redEdge[0];
            int v = redEdge[1];
            adj[u].add(new Edge(v, 0));
        }
        for (int blueEdge[] : blueEdges) {
            int u = blueEdge[0];
            int v = blueEdge[1];
            adj[u].add(new Edge(v, 1));
        }
        BFS(adj,n,ans);
        return ans;
    }
}