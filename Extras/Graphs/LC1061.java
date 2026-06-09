class Solution {
    int min;
    public void dfs(ArrayList<ArrayList<Integer>> adj, int curr, boolean [] visited){
        if(visited[curr]) return;
        visited[curr] = true;
        min = Math.min(min,curr);
        for(int neighbor : adj.get(curr)){
            if(!visited[neighbor])
            {
                dfs(adj,neighbor,visited);
            }
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<26; i++)adj.add(new ArrayList<>());
        for(int i = 0; i<s1.length(); i++){
            int c1 = s1.charAt(i)-'a';
            int c2 = s2.charAt(i)-'a';
            adj.get(c1).add(c2);
            adj.get(c2).add(c1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<baseStr.length(); i++){
            boolean [] visited = new boolean[26];   
            min = Integer.MAX_VALUE;
            dfs(adj,baseStr.charAt(i)-'a',visited);
            sb.append((char)(min+'a'));;
        }
        return sb.toString();
    }
}
public class LC1061 {
    
}
