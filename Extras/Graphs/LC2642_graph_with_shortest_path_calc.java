class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int [][] grid = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i == j) grid[i][j] = 0;
                else grid[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i<edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            int weight = edges[i][2];
            grid[x][y] = weight;
            grid[y][x] = weight;
        }

        for(int via = 0; via<n; via++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(grid[i][via]!=Integer.MAX_VALUE && grid[via][j] != Integer.MAX_VALUE){
                        grid[i][j] = Math.min(grid[i][j],grid[i][via]+grid[via][j]);
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int ans = -1;
        for(int i = 0; i<n; i++){
            int count = 0;
            for(int j = 0; j<n; j++){
                if(i!=j&&grid[i][j]<=distanceThreshold)count++;
            }
            if(count <= min){
                ans = i;
                min = count;
            }
        }
        return ans;
    }
}

public class LC2642_graph_with_shortest_path_calc {
    public static void main(String[] args) {
        
    }
}
