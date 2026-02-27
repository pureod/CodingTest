import java.util.*;

class Solution {
    private static class Robot {
        int nowR, nowC;
        ArrayDeque<Integer> dest;

        public Robot(int nowR, int nowC, ArrayDeque<Integer> dest) {
            this.nowR = nowR;
            this.nowC = nowC;
            this.dest = dest;
        }
    }

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        ArrayDeque<Robot> queue = new ArrayDeque<>();

        for (int i = 0; i < routes.length; i++) {
            int start = routes[i][0] - 1;
            int startR = points[start][0];
            int startC = points[start][1];

            ArrayDeque<Integer> temp = new ArrayDeque<>();
            for (int j = 1; j < routes[i].length; j++) {
                temp.addLast(routes[i][j]);
            }

            queue.addLast(new Robot(startR, startC, temp));
        }

        answer += countCollision(queue);

        while (queue.size() >= 2) {
            int size = queue.size();
            ArrayList<Robot> robots = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                Robot robot = queue.pollFirst();

                if (!robot.dest.isEmpty()) {
                    int target = robot.dest.peekFirst() - 1;
                    int endR = points[target][0];
                    int endC = points[target][1];

                    if (robot.nowR != endR) {
                        robot.nowR += (endR > robot.nowR) ? 1 : -1;
                    } else if (robot.nowC != endC) {
                        robot.nowC += (endC > robot.nowC) ? 1 : -1;
                    }

                    if (robot.nowR == endR && robot.nowC == endC) {
                        robot.dest.pollFirst();
                    }
                }

                robots.add(robot);
            }

            answer += countCollision(robots);

            for (Robot robot : robots) {
                if (!robot.dest.isEmpty()) {
                    queue.addLast(robot);
                }
            }
        }

        return answer;
    }

    private int countCollision(Iterable<Robot> robots) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> result = new HashSet<>();

        for (Robot robot : robots) {
            String location = robot.nowR + "," + robot.nowC;
            if (set.contains(location)) result.add(location);
            set.add(location);
        }
        return result.size();
    }
}
