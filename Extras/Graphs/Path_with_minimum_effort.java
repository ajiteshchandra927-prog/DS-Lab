class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int [][] directions = {
            {-1,0}, //up
            {1,0}, //down
            {0,1}, //right
            {0,-1} //left
        };
        int [][] result = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                result[i][j] = Integer.MAX_VALUE;
            }
        }
        result[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[2] - b[2];
        });

        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int [] node = pq.poll();
            int x = node[0];
            int y = node[1];
            int diff = node[2];
            for(int [] direction : directions){
                int neighborX = x + direction[0];
                int neighborY = y + direction[1];
                if(neighborX < 0 || neighborX >= m || neighborY < 0 || neighborY >= n)continue;
                int absDiff = Math.abs(heights[neighborX][neighborY] - heights[x][y]);
                int maxDiff = Math.max(diff, absDiff);
                if(maxDiff < result[neighborX][neighborY]){
                    result[neighborX][neighborY] = maxDiff;
                    pq.add(new int[]{neighborX,neighborY,maxDiff});
                }
            }
        }
        return result[m-1][n-1];
    }
}

public class Path_with_minimum_effort {
    
}
