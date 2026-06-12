class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return Arrays.asList(0);
        Queue<Integer> q = new LinkedList<>();
        int[] inDegree = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            inDegree[u]++;
            inDegree[v]++;
        }

        for (int i = 0; i < n; i++)
            if (inDegree[i] == 1)
                q.add(i);

        while (n > 2) {
            int sz = q.size();
            n -= sz;
            while (sz-- > 0) {
                int leaf = q.poll();

                for (int neighbor : adj.get(leaf)) {
                    inDegree[neighbor]--;

                    if (inDegree[neighbor] == 1) {
                        q.add(neighbor);
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll());
        }
        return ans;
    }
}

public class LC310 {
    
}
