public class floyd_warshall_algo {
    public static void floydWarshall(int[][] dist) {
        int n = dist.length;
        for(int via = 0; via<n; via++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(dist[i][via] != 100000000 && dist[via][j] != 100000000){
                           dist[i][j] = Math.min(dist[i][j],dist[i][via] + dist[via][j]);
                       }
                }
            }
        }
    }
    public static void main(String[] args) {
        int [][] dist = {
            {0, 4, 5, 5, 7},
            {3, 0, 1, 4, 6},
            {2, 6, 0, 3, 5},
            {3, 7, 1, 0, 2},
            {1, 5, 5, 4, 0}
        };

        floydWarshall(null);
    }
}
