class Solution {
    public void union(int x, int y, int [] parent, int [] rank){
        int parent_x = findParent(x,parent);
        int parent_y = findParent(y,parent);

        if(parent_x == parent_y){
            return;
        }
        if(rank[parent_x] > rank[parent_y]){
            parent[parent_y] = parent_x;
        }
        else if(rank[parent_y] > rank[parent_x]){
            parent[parent_x] = parent_y;
        }
        else{
            parent[parent_x] = parent_y;
            rank[parent_y]++;
        }
    }
    public int findParent(int i, int [] parent){
        if(i == parent[i]) return i;
        return parent[i] = findParent(parent[i], parent);
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int [] parent = new int[n];
        int [] rank = new int[n];
        for(int i = 0; i<edges.length; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        for(int [] edge : edges){
            int u = edge[0]-1;
            int v = edge[1]-1;
            int parent_u = findParent(u,parent);
            int parent_v = findParent(v,parent);
            if(parent_u != parent_v){
                union(u,v,parent,rank);
            }
            else{
                return new int[]{u+1,v+1};
            }
        }
        return new int[]{-1,-1};
    }
}
public class LC684_using_dsu {
    
}
