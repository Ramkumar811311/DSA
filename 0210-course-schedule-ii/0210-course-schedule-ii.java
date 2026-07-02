class Solution {
    public static boolean DFS(int Node, int visited[],int pathVisited[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        visited[Node] = 1;
        pathVisited[Node] = 1;
        for (int element : adj.get(Node)) {
            if (visited[element] == 0) {
                if( DFS(element, visited,pathVisited, adj, st)){
                    return true;
                }
            }
            else if(pathVisited[element] == 1){
                return true;
            }
        }
        pathVisited[Node] = 0;
        st.push(Node);
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int visited[] = new int[numCourses];
        int pathVisited[] = new int[numCourses];
        Stack<Integer> st = new Stack<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] course : prerequisites) {
            int a = course[0];
            int b = course[1];

            adj.get(b).add(a);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if( DFS(i, visited,pathVisited, adj, st) == true){
                    return new int[0];
                }
            }
        }
        int ans[] = new int[numCourses];
        int j=0;

        while (!st.isEmpty()) {
            ans[j++]=st.pop();
        }
        return ans;
    }
}