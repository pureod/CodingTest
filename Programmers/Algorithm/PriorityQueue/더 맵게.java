import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
        for (int s : scoville) pq.add(s);

        while (pq.size() >= 2 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();더
            int newFood = first + (second * 2);

            pq.add(newFood);
            answer++;
        }

        if (pq.peek() < K) return -1;

        return answer;
    }
}