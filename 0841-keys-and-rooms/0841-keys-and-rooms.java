class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        int n = rooms.size();
        int visited[] = new int[n];
        q.add(0);
        visited[0] = 1;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int next : rooms.get(node)) {
                if (visited[next] == 0) {
                    q.add(next);
                    visited[next] = 1;
                }
            }
        }
        for(int i=0; i<n; i++){
            if(visited[i]==0){
                return false;
            }
        }
        return true;
    }
}