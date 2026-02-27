import java.util.*;

class Solution {

    private static class Task {
        int index, start, duration;
        public Task (int index, int start, int duration) {
            this.index = index;
            this.start = start;
            this.duration = duration;
        }
    }

    public int solution(int[][] jobs) {
        int n = jobs.length;

        PriorityQueue<Task> request = new PriorityQueue<>(
            Comparator.comparingInt((Task t) -> t.start)
                .thenComparingInt(t -> t.duration)
                .thenComparingInt(t -> t.index));

        PriorityQueue<Task> wait = new PriorityQueue<>(
            Comparator.comparingInt((Task t) -> t.duration)
                .thenComparingInt(t -> t.start)
                .thenComparingInt(t -> t.index));

        for (int i = 0; i < n; i++) request.add(new Task(i, jobs[i][0], jobs[i][1]));

        wait.add(request.poll());

        int time = 0;
        int sum = 0;

        while (!wait.isEmpty()) {
            Task now = wait.poll();

            time = Math.max(now.start, time) + now.duration;
            int waitingTime = time - now.start;
            sum += waitingTime;

            while (!request.isEmpty() && request.peek().start <= time) {
                wait.add(request.poll());
            }

            if (!request.isEmpty() && wait.isEmpty()) {
                wait.add(request.poll());
            }
        }

        return sum / n;
    }
}