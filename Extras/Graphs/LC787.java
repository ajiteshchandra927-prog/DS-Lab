class Pair{
    int vertex;
    int weight;
    Pair(int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++)adj.add(new ArrayList<>());
        for(int [] flight : flights){
            int u = flight[0];
            int v = flight[1];
            int wt = flight[2];
            adj.get(u).add(new Pair(v,wt));
        }
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(src,0));
        int level = 0;
        int [] result = new int[n];
        Arrays.fill(result,Integer.MAX_VALUE);
        result[src] = 0;
        while(!q.isEmpty() && level <= k){
            int sz = q.size();
            while(sz-->0){
                Pair node = q.poll();
                int curr = node.vertex;
                int wt_src_curr = node.weight;
                for(Pair neighbor : adj.get(curr)){
                    if(wt_src_curr+neighbor.weight < result[neighbor.vertex]){
                        result[neighbor.vertex] = wt_src_curr+neighbor.weight;
                        q.add(new Pair(neighbor.vertex,result[neighbor.vertex]));
                    }
                }
            }
            level++;
        }
        return result[dst]==Integer.MAX_VALUE ? -1 : result[dst];
    }
}
public class LC787 {
    
}
