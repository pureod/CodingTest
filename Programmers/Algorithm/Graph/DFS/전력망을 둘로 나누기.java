import java.util.*;

class Solution {
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    
    private static void dfs(int now) {
        visited[now] = true;
        
        for (int next : adjList[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
    
    public int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < wires.length; i++){
            int count = 0;
            adjList = new ArrayList[n+1];
            visited = new boolean[n+1];
            for (int k = 0; k < n+1; k++) {
                adjList[k] = new ArrayList<>();
            }
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                adjList[wires[j][0]].add(wires[j][1]);
                adjList[wires[j][1]].add(wires[j][0]);
            }
            dfs(1);
            
            for (boolean b : visited) {
                if (b) count++;
            }
            int result = Math.abs(n - count*2);
            if (min > result) {
                min = Math.min(min,result);
            }
        }

        
        return min;
    }
}