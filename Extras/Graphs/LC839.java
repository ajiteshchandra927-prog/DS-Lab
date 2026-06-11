class Solution {
    public int findParent(int i, int[] parent) {
        if (i == parent[i])
            return i;
        return parent[i] = findParent(parent[i], parent);
    }

    public void union(int x, int y, int[] parent, int[] rank) {
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

    public boolean isSimilar(String s1, String s2) {
        int diff = 0;
        for(int i = 0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) diff++;
        }
        return diff == 0 || diff == 2;
    }

    public int numSimilarGroups(String[] strs) {
        int[] parent = new int[strs.length];
        int[] rank = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        int ans = strs.length;
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    if (findParent(i, parent) != findParent(j, parent)) {
                        union(i, j, parent, rank);
                        ans--;
                    }
                }
            }
        }
        return ans;
    }
}