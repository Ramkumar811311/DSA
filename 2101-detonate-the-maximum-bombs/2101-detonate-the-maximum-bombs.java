class Solution {
    public static int BFS(int src, int bombs[][]) {
        int n = bombs.length;
        boolean visited[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true;
        int count = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;
            for (int next = 0; next < n; next++) {
                long x1 = bombs[next][0];
                long y1 = bombs[next][1];
                // int r1 = bombs[next][0];
                long x2 = bombs[curr][0];
                long y2 = bombs[curr][1];
                long r2 = bombs[curr][2];
                long d = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
                if (r2 * r2 >= d && visited[next] == false) {
                    visited[next] = true;
                    q.add(next);
                }
            }

        }
        return count;
    }

    public int maximumDetonation(int[][] bombs) {
        int ans = 0;
        for (int i = 0; i < bombs.length; i++) {
            ans = Math.max(ans, BFS(i, bombs));
        }
        return ans;
    }
}