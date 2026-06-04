//solution using DISJOINT SET UNION ( UNION FIND DATA STRUCTURE ):

class Solution {
    public int findParent(int i, int[] parent) {
        if (i == parent[i])
            return i;
        return parent[i] = findParent(parent[i], parent); //path compression
    }

    public void union(int x, int y, int[] parent, int[] rank) {
        int parent_x = findParent(x, parent);
        int parent_y = findParent(y, parent);

        if (parent_x == parent_y)
            return;
        else if (rank[parent_x] > rank[parent_y]) {
            parent[parent_y] = parent_x;
        } else if (rank[parent_x] < rank[parent_y]) {
            parent[parent_x] = parent_y;
        } else {
            parent[parent_x] = parent_y;
            rank[parent_y]++;
        }
    }

    public  boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        int[] rank = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < equations.length; i++) {
            int var1 = equations[i].charAt(0) - 'a';
            int var2 = equations[i].charAt(3) - 'a';
            int parent_1 = findParent(var1, parent);
            int parent_2 = findParent(var2, parent);
            if (equations[i].charAt(1) == '=') {
                if (parent_1 != parent_2) {
                    union(var1, var2, parent, rank);
                }
            }
        }

        for (int i = 0; i < equations.length; i++) {
            int var1 = equations[i].charAt(0) - 'a';
            int var2 = equations[i].charAt(3) - 'a';
            int parent_1 = findParent(var1, parent);
            int parent_2 = findParent(var2, parent);
            if (equations[i].charAt(1) == '!') {
                if (parent_1 == parent_2) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class Satisfiability_of_Equality_Equations {
    public static void main(String[] args) {
        
    }   
}
