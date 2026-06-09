class Pair{
    int vertex;
    int weight;
    Pair(int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }
}
class Solution {
    int ans = Integer.MAX_VALUE;
    public void dfs(ArrayList<ArrayList<Pair>> adj, int curr,boolean [] visited){
        if(visited[curr])return;
        visited[curr] = true;
        for(Pair neighbor : adj.get(curr)){
            ans = Math.min(ans,neighbor.weight);
            int neighborVertex = neighbor.vertex;
            if(!visited[neighborVertex]){
                dfs(adj,neighborVertex,visited);
            }
        }
    }
    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++)adj.add(new ArrayList<>());
        for(int [] road : roads){
            int u = road[0]-1;
            int v = road[1]-1;
            int wt = road[2];
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        boolean [] visited = new boolean[n];
        dfs(adj,0,visited);
        return ans;
    }
}

public class LC2492 {
    
}
