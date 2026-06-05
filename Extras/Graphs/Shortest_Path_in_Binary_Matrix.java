import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
//using BFS:
class Solution2 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        Queue<int[]> q = new LinkedList<>();
        int[][] directions = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };
        q.add(new int[] { 0, 0, 1 });
        grid[0][0] = 1;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int x = node[0];
            int y = node[1];
            int dist = node[2];
            if (x == n - 1 && y == n - 1) {
                return dist;
            }
            for (int k = 0; k < 8; k++) {
                int r = directions[k][0] + x;
                int c = directions[k][1] + y;
                if (r >= 0 && r < n && c >= 0 && c < n) {
                    if (grid[r][c] == 0) {
                        q.add(new int[] { r, c, dist + 1 });
                        grid[r][c] = 1;
                    }
                }
            }
        }

        return -1;
    }
}

//using dijkstras:
class Solution1 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        int[][] directions = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[2], b[2]));
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }
        result[0][0] = 1;
        pq.add(new int[] { 0, 0, 0 }); //x,y,dist from source
        while (!pq.isEmpty()) {
            int node[] = pq.poll();
            int currX = node[0];
            int currY = node[1];
            int dist_source_curr = node[2];
            if (currX == n - 1 && currY == n - 1) {
                return dist_source_curr+1;
            }
            if (dist_source_curr > result[currX][currY]) {
                continue;
            }   
            for (int[] direction : directions) {
                int neighborX = currX + direction[0];
                int neighborY = currY + direction[1];
                if (neighborX < 0 || neighborX >= n || neighborY < 0 || neighborY >= n)
                    continue;
                if (grid[neighborX][neighborY] == 1) {
                    continue;
                }
                int dist_curr_neighbor = 1;
                int dist_source_neighbor = result[neighborX][neighborY];
                if (dist_source_curr + dist_curr_neighbor < dist_source_neighbor) {
                    dist_source_neighbor = dist_source_curr + dist_curr_neighbor;
                    result[neighborX][neighborY] = dist_source_neighbor;
                    pq.add(new int[]{neighborX, neighborY, dist_source_neighbor});
                }
            }
        }
        return -1;
    }
}
public class Shortest_Path_in_Binary_Matrix {
    
}
