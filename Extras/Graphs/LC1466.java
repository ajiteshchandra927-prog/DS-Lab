class Solution {
    int count = 0;
    public void dfs(ArrayList<ArrayList<Integer>> adj1, ArrayList<ArrayList<Integer>> adj2, int curr, boolean [] visited){
        if(visited[curr])return;
        visited[curr] = true;
        for(int neighbor : adj1.get(curr)){
            if(!visited[neighbor]){
                for(int x : adj2.get(curr)) if(x == neighbor)count++;
                dfs(adj1,adj2,neighbor,visited);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj1.add(new ArrayList<>());
            adj2.add(new ArrayList<>());
        }
        for(int [] connection : connections){
            int u = connection[0];
            int v = connection[1];
            adj1.get(u).add(v);
            adj1.get(v).add(u);
            adj2.get(u).add(v);
        }
        boolean []visited = new boolean[n];
        dfs(adj1,adj2,0,visited);
        return count;
    }
}
public class LC1466 {
    
}
