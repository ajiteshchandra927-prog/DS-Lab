class Cell{
    int x;
    int y;
    Cell(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int [][] directions = {
            {0,-1}, //up
            {0,1}, //down
            {1,0}, //right
            {-1,0} //left
        };

        boolean [][] visited = new boolean[m][n];
        Queue<Cell> q = new LinkedList<>();

        q.add(new Cell(entrance[0],entrance[1]));
        visited[entrance[0]][entrance[1]] = true;

        int level = 0;

        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-->0){
                Cell cell = q.poll();
                int x = cell.x;
                int y = cell.y;
                if((x == m-1 || x == 0 || y == 0 || y == n-1)&& !(x == entrance[0] && y == entrance[1]))return level;
                for(int [] direction : directions){
                    int x_ = x + direction[0];
                    int y_ = y + direction[1];
                    if(x_<0 || x_>=m || y_<0 || y_>=n)continue;
                    if(!visited[x_][y_] && maze[x_][y_] == '.'){
                        q.add(new Cell(x_,y_));
                        visited[x_][y_] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}

public class LC1926 {
    
}
