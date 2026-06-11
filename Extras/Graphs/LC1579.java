class Solution {
    public int assignEdgeWeights(int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            if (!adj.containsKey(u)) {
                adj.put(u, new ArrayList<>());
            }
            adj.get(u).add(v);
            if (!adj.containsKey(v)) {
                adj.put(v, new ArrayList<>());
            }
            adj.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        int levels = 0;
        HashSet<Integer> visited = new HashSet<>();
        q.add(0);
        visited.add(0);
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                int curr = q.poll();
                for (int neighbor : adj.get(curr)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        q.add(neighbor);
                    }
                }
            }
            levels++;
        }
        long mod = 1000000007;
        long ans = 1;

        for (int i = 0; i < levels - 2; i++) {
            ans = (ans * 2) % mod;
        }

        return (int) ans;
    }
}
public class LC1579 {
    
}
