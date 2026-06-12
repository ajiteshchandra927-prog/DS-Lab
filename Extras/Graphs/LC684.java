class Solution {
    public boolean dfsCycleDetectionUndirected(ArrayList<HashSet<Integer>> adj, int curr, int parent,
            boolean[] visited) {
        visited[curr] = true;
        for (int neighbor : adj.get(curr)) {
            if (neighbor == parent)
                continue; // ignore the edge leading back to the parent, because every undirected edge appears twice

            if (visited[neighbor])
                return true; //if the for any of the neighbor, parent is not the current vertex, as well as neighbor is visited already, it means cycle is there

            if (dfsCycleDetectionUndirected(adj, neighbor, curr, visited))
                return true;
        }
        return false;
    }

    public boolean isCyclicDFS_Undirected(ArrayList<HashSet<Integer>> adjList, boolean[] visitedDFS, int n) {
        for (int vertex = 0; vertex < n; vertex++) {
            if (!visitedDFS[vertex] && dfsCycleDetectionUndirected(adjList, vertex, -1, visitedDFS)) { //go to each vertex, if its not visited, apply dfs check on it
                return true;
            }
        }
        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<HashSet<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        for (int i = 0; i < n; i++)
            adj.add(new HashSet<>());
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for (int i = n - 1; i >= 0; i--) {
            int u = edges[i][0] - 1;
            int v = edges[i][1] - 1;
            //remove edge:
            adj.get(u).remove(v);
            adj.get(v).remove(u);
            boolean[] visited = new boolean[n];
            if (!isCyclicDFS_Undirected(adj, visited, n))
                return new int[] { u+1, v+1 };
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return new int[] { -1, -1 };
    }
}

public class LC684 {
    
}
