import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class dijkstra_demo {
    public static int[] dijkstras(ArrayList<ArrayList<int[]>> adj, int source) {
        int[] ans = new int[adj.size()];

        Arrays.fill(ans, Integer.MAX_VALUE);

        ans[source] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });

        pq.add(new int[] { source, 0 });

        while (!pq.isEmpty()) {
            int curr = pq.poll()[0];
            for (int[] neighborData : adj.get(curr)) {
                int neighborNode = neighborData[0];
                int weight = neighborData[1];
                int d_source_curr = ans[curr];
                int d_curr_neighbor = weight;
                int d_source_neighbor = ans[neighborNode];

                if (d_source_curr + d_curr_neighbor < d_source_neighbor) {
                    d_source_neighbor = d_source_curr + d_curr_neighbor;
                    ans[neighborNode] = d_source_neighbor;
                    pq.add(new int[] { neighborNode, d_source_neighbor });
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new int[] { 1, 4 });
        adj.get(0).add(new int[] { 2, 1 });

        adj.get(1).add(new int[] { 3, 1 });

        adj.get(2).add(new int[] { 1, 2 });
        adj.get(2).add(new int[] { 3, 5 });

        adj.get(3).add(new int[] { 4, 3 });

        System.out.println(Arrays.toString(dijkstras(adj, 0)));
    }
}
