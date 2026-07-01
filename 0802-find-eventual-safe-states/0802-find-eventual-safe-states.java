class Solution {
    public static Boolean detectCycleUsingDfs(int Node, int visited[], int pathVisited[],
            int graph[][], int safePath[]) {

        visited[Node] = 1;
        pathVisited[Node] = 1;
        for (int element : graph[Node]) {
            if (visited[element] == 0) {
                if (detectCycleUsingDfs(element, visited, pathVisited, graph, safePath)) {
                    return true;
                }
            } else if (visited[element] == 1 && pathVisited[element] == 1) {
                return true;
            }
        }
        safePath[Node] = 1;
        pathVisited[Node] = 0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int safePath[] = new int[graph.length];
        int visited[] = new int[graph.length];
        int pathVisited[] = new int[graph.length];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0) {
                detectCycleUsingDfs(i, visited, pathVisited, graph, safePath);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            if (safePath[i] == 1) {
                ans.add(i);
            }
        }
        return ans;
    }
}