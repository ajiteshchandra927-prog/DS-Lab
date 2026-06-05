import java.util.LinkedList;
import java.util.Queue;
//using BFS:
class Solution {
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
public class Shortest_Path_in_Binary_Matrix {
    
}
