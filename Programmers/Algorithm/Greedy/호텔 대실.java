import java.util.*;

class Solution {
    private static class Room {
        int start, end;

        public Room (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static int makeMinute(String time) {
        String[] arr = time.split(":");

        return Integer.valueOf(arr[0]) * 60 + Integer.valueOf(arr[1]);
    }

    public int solution(String[][] book_time) {
        int answer = -1;

        PriorityQueue<Room> reserve = new PriorityQueue<>(
            (o1,o2) -> Integer.compare(o1.start, o2.start));

        PriorityQueue<Room> used = new PriorityQueue<>(
            (o1,o2) -> Integer.compare(o1.end, o2.end));

        for (String[] book : book_time) {
            int start = makeMinute(book[0]);
            int end = makeMinute(book[1]);

            reserve.add(new Room(start, end));
        }

        while (!reserve.isEmpty()) {
            Room now = reserve.poll();

            while (!used.isEmpty()) {
                if (used.peek().end + 10 <= now.start) {
                    used.poll();
                    continue;
                }
                break;
            }

            used.add(new Room(now.start, now.end));

            if (used.size() > answer) answer = used.size();
        }

        return answer;
    }
}