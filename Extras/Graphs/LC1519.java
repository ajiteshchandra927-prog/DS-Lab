class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> adj, int curr, int parent,int[] count, String labels,int[]result){
        int count_before = count[labels.charAt(curr)-'a'];
        count[labels.charAt(curr)-'a']++;
        for(int child : adj.get(curr)){
            if(child == parent)continue;
            dfs(adj,child,curr,count,labels,result);
        }
        int count_after = count[labels.charAt(curr)-'a'];
        result[curr] = count_after - count_before;
    }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int [] result = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++)adj.add(new ArrayList<>());
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int [] count = new int[26];
        dfs(adj,0,-1,count,labels,result);
        return result;
    }
}
public class LC1519 {
    
}
