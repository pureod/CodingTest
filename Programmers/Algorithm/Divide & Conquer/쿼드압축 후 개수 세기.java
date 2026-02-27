import java.util.*;

class Solution {
    private static int[][] map;
    private static int zero, one;

    private static void quad(int r, int c, int length) {
        int target = map[r][c];

        for (int i = r; i < r + length; i++) {
            for (int j = c; j < c + length; j++) {
                if (map[i][j] == target) continue;

                length /= 2;
                quad(r,c,length);
                quad(r+length, c, length);
                quad(r, c+length, length);
                quad(r+length, c+length, length);

                return;
            }
        }

        if (target == 0) zero++;
        else one++;

        return;
    }

    public int[] solution(int[][] arr) {
        zero = 0; one = 0;
        map = arr;

        quad(0, 0, arr.length);

        return new int[] {zero, one};
    }
}