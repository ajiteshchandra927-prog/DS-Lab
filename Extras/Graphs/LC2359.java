class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> adj, int start, boolean[] visited, int dist, int[] arr) {
        if (visited[start])
            return;
        visited[start] = true;
        arr[start] = dist;
        for (int neighbor : adj.get(start)) {
            if (!visited[neighbor]) {
                dfs(adj, neighbor, visited, dist + 1, arr);
            }
        }
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            if (edges[i] != -1)
                adj.get(i).add(edges[i]);
        }

        int[] arr1 = new int[n];
        Arrays.fill(arr1, -1);
        int[] arr2 = new int[n];
        Arrays.fill(arr2, -1);

        boolean[] visited = new boolean[n];
        dfs(adj, node1, visited, 0, arr1);
        Arrays.fill(visited, false);
        dfs(adj, node2, visited, 0, arr2);

        int ans = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr1[i] != -1 && arr2[i] != -1) {
                int curr = Math.max(arr1[i], arr2[i]);

                if (curr < min) {
                    min = curr;
                    ans = i;
                }
            }
        }

        return ans;
    }
}
public class LC2359 {
    
}
