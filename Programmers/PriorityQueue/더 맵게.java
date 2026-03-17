import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int n = scoville.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) pq.add(scoville[i]);

        while (!pq.isEmpty()) {
            if (pq.peek() >= K) return answer;
            if (pq.size() < 2) return -1;

            int first = pq.poll();
            int second = pq.poll();

            pq.add(first + (second * 2));

            answer++;
        }

        return answer;
    }
}