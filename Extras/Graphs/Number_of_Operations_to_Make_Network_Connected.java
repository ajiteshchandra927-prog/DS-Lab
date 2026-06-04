
class Solution {
    public int findParent(int i, int [] parent){
        if( i == parent[i] )return i;
        return parent[i] = findParent(parent[i], parent);
    }

    public void union(int x, int y, int [] parent, int [] rank){
        int parent_x = findParent(x,parent);
        int parent_y = findParent(y,parent);

        if(parent_x == parent_y) return;
        else if(rank[parent_x] > rank[parent_y]){
            parent[parent_y] = parent_x;
        }
        else if(rank[parent_x] < rank[parent_y]){
            parent[parent_x] = parent_y;
        }
        else{
            parent[parent_x] = parent_y;
            rank[parent_y]++;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int components = n;
        int [] parent = new int[n];
        int [] rank = new int[n];
        for(int i = 0; i<n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        if(connections.length < n - 1) return -1; //if there are less no of edges(connections) than n - 1(no of computers - 1) then we can not connect them obv, so return -1;

        for(int i = 0; i < connections.length; i++){
            int u = connections[i][0];
            int v = connections[i][1];

            int parent_u = findParent(u,parent);
            int parent_v = findParent(v,parent);

            if(parent_u != parent_v){
                union(u,v,parent,rank);
                components--;
            }
        }

        return components - 1;
    }
}

public class Number_of_Operations_to_Make_Network_Connected {
    public static void main(String[] args) {
        
    }    
}
