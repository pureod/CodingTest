import java.util.*;

class Solution {
    private static int makeSeconds (String str) {
        String[] arr = str.split(":");
        int minute = Integer.valueOf(arr[0]);
        int second = Integer.valueOf(arr[1]);

        return minute * 60 + second;
    }

    private static String makeString (int time) {
        int minute = time / 60;
        int second = time % 60;
        String resultM = minute < 10 ? "0" + minute : "" + minute;
        String resultS = second < 10 ? "0" + second : "" + second;

        return resultM + ":" + resultS;
    }

    private static int skipOp (int time, int opStart, int opEnd) {
        if (time >= opStart && time <= opEnd) {
            time = opEnd;
        }

        return time;
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int current = makeSeconds(pos);
        int opStart = makeSeconds(op_start);
        int opEnd = makeSeconds(op_end);
        int limit = makeSeconds(video_len);

        for (String command : commands) {
            current = skipOp(current, opStart, opEnd);

            if (command.equals("prev")) {
                current = Math.max(current-10, 0);
            }
            else {
                current = Math.min(current+10, limit);
            }

            current = skipOp(current, opStart, opEnd);

        }

        return makeString(current);
    }
}