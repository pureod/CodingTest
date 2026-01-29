import java.util.*;

class Solution {
    private static int N;
    private static boolean[] visited;
    private static ArrayList<Integer>[] adjList;

    private static void dfs (int start) {
        visited[start] = true;

        for (int next : adjList[start]) {
            if (visited[next]) continue;
            dfs(next);
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        N = n;
        visited = new boolean[n];
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        for (int i = 0; i < computers.length; i++) {
            int[] computer = computers[i];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (computer[j] == 1) adjList[i].add(j);
            }
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            answer++;
            dfs(i);
        }

        return answer;
    }
}