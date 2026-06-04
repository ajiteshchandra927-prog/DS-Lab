import java.util.ArrayList;

public class DSU {

    // without path compression:
    public static int findParent(int i, int[] parent) {
        if (i == parent[i])
            return i;
        return findParent(parent[i], parent);
    }

    public static void union(int x, int y, int[] parent) {
        int parent_x = findParent(x, parent);
        int parent_y = findParent(y, parent);

        if (parent_x != parent_y) {
            parent[parent_x] = parent_y;
        }
    }

    // with path compression:
    public static int findParentOptimized(int i, int[] parent) {
        if (i == parent[i])
            return i;
        return parent[i] = findParentOptimized(parent[i], parent);
    }

    public static void unionOptimized(int x, int y, int[] parent, int[] rank) {
        int parent_x = findParentOptimized(x, parent);
        int parent_y = findParentOptimized(y, parent);

        if (parent_x == parent_y)
            return;

        if (rank[parent_x] > rank[parent_y]) {
            parent[parent_y] = parent_x;
        } else if (rank[parent_x] < rank[parent_y]) {
            parent[parent_x] = parent_y;
        } else {
            parent[parent_x] = parent_y;
            rank[parent_y]++;
        }
    }

    public static boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj, int[] parent, int [] rank) {
        for(int u = 0; u<V; u++){
            for(int v : adj.get(u)){
                if( u < v ){
                    int parent_u = findParentOptimized(u,parent);
                    int parent_v = findParentOptimized(v,parent);
                    if(parent_u == parent_v)return true;
                    unionOptimized(u,v,parent,rank);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 7;
        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        System.out.println("Cycle: "+detectCycle(n,adj,parent,rank));
    }

}
