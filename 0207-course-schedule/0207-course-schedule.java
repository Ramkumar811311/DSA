class Solution {
    public static Boolean detectCycleUsingDfs(int Node, int visited[], int pathVisited[],
            ArrayList<ArrayList<Integer>> adj) {

        visited[Node] = 1;
        pathVisited[Node] = 1;
        for (int element : adj.get(Node)) {
            if (visited[element] == 0) {
                if (detectCycleUsingDfs(element, visited, pathVisited, adj)) {
                    return true;
                }
            } else if (visited[element] == 1 && pathVisited[element] == 1) {
                return true;
            }
        }
        pathVisited[Node] = 0;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int visited[] = new int[numCourses];
        int pathVisited[] = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prerequisite = edge[1];

            adj.get(prerequisite).add(course);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (detectCycleUsingDfs(i, visited, pathVisited, adj)) {
                    return false;
                }
            }
        }
        return true;
    }
}