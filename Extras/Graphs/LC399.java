class Pair {
    String vertex;
    double val;

    Pair(String vertex, double val) {
        this.vertex = vertex;
        this.val = val;
    }
}

class Solution {
    double res = -1;

    public void dfs(HashMap<String, ArrayList<Pair>> adj, String curr, String end, HashSet<String> visited,
            double currval) {
        if (curr.equals(end)) {
            res = currval;
            return;
        }
        visited.add(curr);
        if (curr.equals(end))
            res = currval;
        for (Pair neighbor : adj.get(curr)) {
            String neighborVertex = neighbor.vertex;
            double neighborVal = neighbor.val;
            if (!visited.contains(neighborVertex)) {
                dfs(adj, neighborVertex, end, visited, currval * neighborVal);
            }
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, ArrayList<Pair>> adj = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String u = equation.get(0);
            String v = equation.get(1);
            double val = values[i];
            if (!adj.containsKey(u)) {
                adj.put(u, new ArrayList<>());
            }
            adj.get(u).add(new Pair(v, val));
            if (!adj.containsKey(v)) {
                adj.put(v, new ArrayList<>());
            }
            adj.get(v).add(new Pair(u, 1 / val));
        }
        double[] ans = new double[queries.size()];
        int i = 0;
        for (List<String> query : queries) {
            HashSet<String> visited = new HashSet<>();
            String start = query.get(0);
            String end = query.get(1);
            if (!adj.containsKey(start) || !adj.containsKey(end)) {
                ans[i++] = -1.0;
                continue;
            }
            dfs(adj, start, end, visited, 1.0);
            ans[i++] = res;
            res = -1;
        }
        return ans;
    }
}
public class LC399 {
    
}
