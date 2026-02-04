import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] dist = new int[n+1];
        Arrays.fill(dist,-1);

        ArrayList<Integer>[] adjList = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) adjList[i] = new ArrayList<>();

        for (int[] road : roads) {
            adjList[road[0]].add(road[1]);
            adjList[road[1]].add(road[0]);
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(destination);
        dist[destination] = 0;

        while (!queue.isEmpty()) {
            int now = queue.pollFirst();

            for (int next : adjList[now]) {
                if (dist[next] != -1) continue;

                queue.add(next);
                dist[next] = dist[now] + 1;
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();

        for (int source : sources) answer.add(dist[source]);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}