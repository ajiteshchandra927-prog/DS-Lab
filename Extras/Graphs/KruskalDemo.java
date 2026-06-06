import java.util.ArrayList;
import java.util.Collections;

class Edge {
    int start;
    int end;
    int weight;

    Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

public class KruskalDemo {
    public static int findParent(int i, int[] parent) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = findParent(parent[i], parent);
    }

    public static void union(int x, int y, int[] parent, int[] rank) {
        int parent_x = findParent(x, parent);
        int parent_y = findParent(y, parent);

        if (parent_x == parent_y) {
            return;
        }

        if (rank[parent_x] > rank[parent_y]) {
            parent[parent_y] = parent_x;
        } else if (rank[parent_y] > rank[parent_x]) {
            parent[parent_x] = parent_y;
        } else {
            parent[parent_x] = parent_y;
            rank[parent_y]++;
        }
    }

    public static int Kruskals(ArrayList<Edge> edges, int V) {
        int parent[] = new int[V];
        int rank[] = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int totalWeight = 0;
        Collections.sort(edges, (a, b) -> {
            return a.weight - b.weight;
        });

        for (Edge Edge : edges) {
            int start = Edge.start;
            int end = Edge.end;
            int weight = Edge.weight;

            int parent_start = findParent(start, parent);
            int parent_end = findParent(end, parent);

            if (parent_start == parent_end) {
                continue;
            }

            totalWeight += weight;
            union(start, end, parent, rank);
        }
        return totalWeight;
    }

    public static void main(String[] args) {

        int V = 4;

        ArrayList<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 1));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(0, 3, 2));
        edges.add(new Edge(1, 3, 3));
        edges.add(new Edge(2, 3, 5));

        int mstWeight = Kruskals(edges, V);

        System.out.println("MST Weight = " + mstWeight);
    }
}
