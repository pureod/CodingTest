import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] adjList = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) adjList[i] = new ArrayList<>();

        for (int[] line : edge) {
            adjList[line[0]].add(line[1]);
            adjList[line[1]].add(line[0]);
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        dist[1] = 0;

        while (!queue.isEmpty()) {
            int now = queue.pollFirst();

            for (int next : adjList[now]) {
                if (dist[next] != -1) continue;

                queue.add(next);
                dist[next] = dist[now] + 1;
            }
        }

        int max = 0;
        int answer = 1;

        for (int i = 1; i < n+1; i++) {
            if (dist[i] > max) {
                max = dist[i];
                answer = 1;
            }
            else if (dist[i] == max) {
                answer++;
            }
            else {
                continue;
            }
        }

        return answer;
    }
}