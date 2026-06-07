class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        for(String str : bank)set.add(str);
        int level = 0;
        q.add(startGene);
        visited.add(startGene);
        while(!q.isEmpty()){
            int n = q.size();
            while(n-->0){
                String curr = q.poll();
                if(curr.equals(endGene)) return level;

                for(char ch : "ACGT".toCharArray()){
                    for(int i = 0; i<curr.length(); i++){
                        char [] temp = curr.toCharArray();
                        temp[i] = ch;
                        String neighbor = new String(temp);
                        if(!visited.contains(neighbor) && set.contains(neighbor)){
                            visited.add(neighbor);
                            q.add(neighbor);
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}

public class LC433 {
    
}
