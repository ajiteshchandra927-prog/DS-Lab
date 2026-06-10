class Solution {
    int [] arr;
    public void dfs(ArrayList<ArrayList<Integer>> adj, int curr, boolean [] visited,int k){
        if(visited[curr])return;
        visited[curr] = true;
        arr[k]++;
        for(int neighbor : adj.get(curr)){
            if(!visited[neighbor]){
                dfs(adj,neighbor,visited,k);
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
        int k = 0;
        arr = new int[n];
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                dfs(adj,i,visited,k);
                k++;
            }
        }
        long total = 0;
        for(int i = 0; i<arr.length; i++){
            total+=arr[i];
        }
        for(int i = 0; i<arr.length; i++){
            ans+=(total-arr[i])*arr[i];
        }
        return ans/2;
    }
}
public class LC2316 {
    
}
