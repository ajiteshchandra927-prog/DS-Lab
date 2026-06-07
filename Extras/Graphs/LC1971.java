//wtf is this question, its so easy it shouldnt even exist
class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> adjList, int start, boolean [] visited){
        if(visited[start])return;
        visited[start] = true;
        for(int neighbor : adjList.get(start)){
            if(!visited[neighbor]){
                dfs(adjList,neighbor,visited);
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<n; i++) adjList.add(new ArrayList<>());
        boolean [] visited = new boolean[n];
        for(int [] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        dfs(adjList,source,visited);
        return visited[destination];
    }
}
public class LC1971 {
    
}
