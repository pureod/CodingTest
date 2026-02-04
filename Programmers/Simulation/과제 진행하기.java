import java.util.*;

class Solution {
    private static class Task {
        String name;
        int start, playTime;

        public Task (String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
    }

    private static int makeMinute (String time) {
        String[] arr = time.split(":");

        if (arr.length == 2) {
            return Integer.valueOf(arr[0]) * 60 + Integer.valueOf(arr[1]);
        }
        else {
            return Integer.valueOf(arr[0]);
        }
    }

    public String[] solution(String[][] plans) {
        ArrayList<String> answer = new ArrayList<>();
        int n = plans.length;
        ArrayDeque<Task> stack = new ArrayDeque<>();

        PriorityQueue<Task> pq = new PriorityQueue<>(
            (o1,o2) -> Integer.compare(o1.start, o2.start));

        for (String[] plan : plans) {
            String name = plan[0];
            int start = makeMinute(plan[1]);
            int playTime = makeMinute(plan[2]);

            pq.add(new Task(name, start, playTime));
        }

        Task prev = pq.poll();

        while (!pq.isEmpty()) {
            Task current = pq.poll();

            int time = current.start - prev.start;

            if (time < prev.playTime) {
                stack.addFirst(new Task(prev.name, prev.start, prev.playTime - time));
            }
            else {
                answer.add(prev.name);
                time -= prev.playTime;

                while (!stack.isEmpty() && time > 0) {
                    if (time >= stack.peek().playTime) {
                        Task target = stack.pollFirst();
                        answer.add(target.name);
                        time -= target.playTime;
                    }
                    else {
                        Task target = stack.peek();
                        target.playTime -= time;
                        break;
                    }
                }
            }

            prev = current;
        }

        stack.addFirst(new Task(prev.name, prev.start, prev.playTime));

        while (!stack.isEmpty()) answer.add(stack.pollFirst().name);

        return answer.toArray(new String[0]);
    }
}