class Solution {
    public int findCenter(int[][] edges) {
        int V = edges.length;

        int degree[] = new int[V + 2];

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            degree[u]++;
            degree[v]++;
        }

        for (int i = 1; i <= V + 1; i++) {
            if (degree[i] == V) {
                return i;
            }
        }

        return -1;
    }
}