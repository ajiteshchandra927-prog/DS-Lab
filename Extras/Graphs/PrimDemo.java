import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Node {
    int weight;
    int vertex;

    Node(int weight, int vertex) {
        this.weight = weight;
        this.vertex = vertex;
    }
}

public class PrimDemo {

    public static int prims(ArrayList<ArrayList<Node>> adj, int V) {

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            return a.weight - b.weight;
        });
        pq.add(new Node(0, 0));

        boolean[] visited = new boolean[V];

        int totalWeight = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int curr = node.vertex;
            int weight = node.weight;

            if (!visited[curr]) {
                totalWeight += weight;
                for (Node neighborNode : adj.get(curr)) {
                    if (!visited[neighborNode.vertex]) {
                        pq.add(new Node(neighborNode.weight, neighborNode.vertex));
                    }
                }
            }

            visited[curr] = true;
        }
        return totalWeight;
    }

    public static void main(String[] args) {
        int V = 4;

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Undirected graph (add both sides)
        graph.get(0).add(new Node(2, 1));
        graph.get(1).add(new Node(2, 0));

        graph.get(0).add(new Node(6, 2));
        graph.get(2).add(new Node(6, 0));

        graph.get(1).add(new Node(4, 2));
        graph.get(2).add(new Node(4, 1));

        graph.get(1).add(new Node(3, 3));
        graph.get(3).add(new Node(3, 1));

        graph.get(2).add(new Node(1, 3));
        graph.get(3).add(new Node(1, 2));

        System.out.println(prims(graph, V));
    }
}
