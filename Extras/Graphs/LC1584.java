class Node {
    int vertex;
    int weight;

    Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int manhattanDist = Math.abs(x2 - x1) + Math.abs(y2 - y1);
                adj.get(i).add(new Node(j, manhattanDist));
                adj.get(j).add(new Node(i, manhattanDist));
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            return a.weight - b.weight;
        });
        pq.add(new Node(0, 0));
        int totalWeight = 0;
        boolean[] visited = new boolean[points.length];
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int curr = node.vertex;
            int weight = node.weight;
            if (visited[curr])
                continue;
            totalWeight += weight;
            visited[curr] = true;
            for (Node neighborNode : adj.get(curr)) {
                if (!visited[neighborNode.vertex]) {
                    pq.add(new Node(neighborNode.vertex, neighborNode.weight));
                }
            }
        }
        return totalWeight;
    }
}

public class LC1584 {
    public static void main(String[] args) {
        
    }
}
