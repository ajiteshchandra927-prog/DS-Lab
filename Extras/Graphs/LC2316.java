class Solution {
    int count = 0;
    public void dfs(ArrayList<ArrayList<Integer>> adj, int curr, boolean [] visited){
        if(visited[curr])return;
        visited[curr] = true;
        count++;
        for(int neighbor : adj.get(curr)){
            if(!visited[neighbor]){
                dfs(adj,neighbor,visited);
            }
        }
    }
    public long countPairs(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++)adj.add(new ArrayList<>());
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean [] visited = new boolean[n];
        long ans = 0;
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                count = 0;
                dfs(adj,i,visited);
                ans += 1L*count*(n-count);
            }
        }
        return ans/2;
    }
}
public class LC2316 {
    
}
