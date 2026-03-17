import java.util.*;

class Solution {

    private static class Task {
        int num, start, work;

        public Task(int num, int start, int work) {
            this.num = num;
            this.start = start;
            this.work = work;
        }
    }

    public int solution(int[][] jobs) {
        PriorityQueue<Task> wait = new PriorityQueue<>(
            (a, b) -> {
                if (a.work != b.work) return Integer.compare(a.work, b.work);
                else if (a.start != b.start) return Integer.compare(a.start, b.start);
                else return Integer.compare(a.num, b.num);
            });

        PriorityQueue<Task> list = new PriorityQueue<>(
            (a, b) -> {
                if (a.start != b.start) return Integer.compare(a.start, b.start);
                else if (a.work != b.work) return Integer.compare(a.work, b.work);
                else return Integer.compare(a.num, b.num);
            });

        for (int i = 0; i < jobs.length; i++) {
            list.offer(new Task(i, jobs[i][0], jobs[i][1]));
        }

        int current = 0;
        int total = 0;
        int count = 0;

        while (count < jobs.length) {
            while (!list.isEmpty() && list.peek().start <= current) {
                wait.add(list.poll());
            }

            if (!wait.isEmpty()) {
                Task task = wait.poll();
                current += task.work;
                total += (current - task.start);
                count++;
            } else {
                current = list.peek().start;
            }
        }

        return total / jobs.length;
    }
}