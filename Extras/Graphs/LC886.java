//easy as fuck
class Solution {
    public boolean isBipartite(ArrayList<ArrayList<Integer>>adj,int curr, int currColor, int [] color){
        color[curr] = currColor;
        for(int neighbor : adj.get(curr)){
            if(color[neighbor] == color[curr]) return false;
            if(color[neighbor] == -1){
                int neighborColor = 1 - currColor;
                if(!isBipartite(adj,neighbor,neighborColor,color)) return false;
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<dislikes.length; i++){
            int u = dislikes[i][0]-1;
            int v = dislikes[i][1]-1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int [] color = new int[n];
        Arrays.fill(color,-1);

        for(int i = 0; i<n; i++){
            if(color[i]==-1)
                if(!isBipartite(adj,i,0,color))return false;;
        }
        return true;
    }
}
public class LC886 {
    public static void main(String[] args) {
        
    }
}
