import java.util.*;

class Solution {
    private static int gcd(int x, int y) {
        if (y == 0) return x;

        return gcd(y, x % y);
    }

    public long solution(int w, int h) {
        if (w == 1 || h == 1) return 0;
        long total = (long) w * h;
        long loss = w + h - gcd(w, h);

        return total - loss;
    }
}