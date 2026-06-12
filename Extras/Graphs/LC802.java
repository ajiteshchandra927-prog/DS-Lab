class Solution {
    public boolean dfsCycleDetectionDirected(HashMap<Integer, ArrayList<Integer>> adjList, int start,
            boolean[] visitedDFS, boolean[] inRecursion) {
        visitedDFS[start] = true;
        inRecursion[start] = true;// mark node as visited and currently present in recursion stack

        for (int neighbor : adjList.get(start)) {
            if (!visitedDFS[neighbor] && dfsCycleDetectionDirected(adjList, neighbor, visitedDFS, inRecursion))
                return true;
            else if (inRecursion[neighbor])
                return true;
        }
        inRecursion[start] = false;// remove node from recursion stack while backtracking
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        int n = graph.length;
        boolean[] visitedDFS = new boolean[n];
        boolean[] inRecursion = new boolean[n];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                adj.get(i).add(neighbor);
            }
        }

        for (int vertex : adj.keySet()) {
            if (!visitedDFS[vertex]) {
                dfsCycleDetectionDirected(adj, vertex, visitedDFS, inRecursion);
            }
        }

        for (int i = 0; i < n; i++)
            if (!inRecursion[i])
                ans.add(i);
        return ans;
    }
}

public class LC802 {
    
}
