//LMAOOOOOOOOOOOO easier than two sum
class Solution {
    public void dfs(List<List<Integer>> adj, boolean [] visited, int start){
        if(visited[start])return;
        visited[start] = true;
        for(int neighbor : adj.get(start)){
            if(!visited[neighbor]){
                dfs(adj,visited,neighbor);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean [] visited = new boolean[n];
        dfs(rooms,visited,0);
        for(int i = 0; i<n; i++) if(!visited[i]) return false;
        return true;
    }
}
public class LC841 {
    public static void main(String[] args) {
        
    }
}
