import java.util.*;

class Solution {
    private static class Car {
        int start, end;

        public Car (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int solution(int[][] routes) {
        PriorityQueue<Car> pq = new PriorityQueue<>(
            (o1,o2) -> Integer.compare(o1.end, o2.end));

        for (int[] route : routes) pq.add(new Car(route[0],route[1]));

        int lastCamera = Integer.MIN_VALUE;
        int answer = 0;

        while (!pq.isEmpty()) {
            Car now = pq.poll();

            if (now.start > lastCamera) {
                lastCamera = now.end;
                answer++;
            }
        }

        return answer;
    }
}