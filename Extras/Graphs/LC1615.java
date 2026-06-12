class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        ArrayList<HashSet<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++)adj.add(new HashSet<>());
        for(int [] road : roads){
            int u = road[0];
            int v = road[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int [] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = adj.get(i).size();
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                int x = 0;
                if(adj.get(i).contains(j)) x = 1;
                max = Math.max(max,arr[i]+arr[j]-x);
            }
        }
        return max;
    }
}
public class LC1615 {
    
}
