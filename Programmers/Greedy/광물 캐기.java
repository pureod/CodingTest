import java.util.*;

class Solution {
    private static class Box {
        int diamond, iron, stone;

        public Box (int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }

        public int getValue (int pick) {
            if (pick == 0) return this.diamond + this.iron + this.stone;
            else if (pick == 1) return this.diamond * 5 + this.iron + this.stone;
            else return this.diamond * 25 + this.iron * 5 + this.stone;
        }

        public int getPq () {
            return this.diamond * 25 + this.iron * 5 + this.stone;
        }
    }

    public int solution(int[] picks, String[] minerals) {
        int n = minerals.length;
        int answer = 0;

        int max = (picks[0] + picks[1] + picks[2]) * 5;
        int limit = Math.min(n, max);

        PriorityQueue<Integer> pick = new PriorityQueue<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < picks[i]; j++) {
                pick.add(i);
            }
        }

        PriorityQueue<Box> box = new PriorityQueue<>((o1, o2) -> {
            int c = Integer.compare(o2.getPq(), o1.getPq());
            if (c != 0) return c;

            c = Integer.compare(o2.diamond, o1.diamond);
            if (c != 0) return c;

            c = Integer.compare(o2.iron, o1.iron);
            if (c != 0) return c;

            return Integer.compare(o2.stone, o1.stone);
        });

        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < limit; i++) {
            if (i % 5 == 0) {
                a = 0; b = 0; c = 0;
            }

            String now = minerals[i];

            if (now.equals("diamond")) a++;
            else if (now.equals("iron")) b++;
            else c++;

            if ((i+1) % 5 == 0 || i == n-1) {
                box.add(new Box(a,b,c));
            }
        }

        while (!pick.isEmpty() && !box.isEmpty()) {
            Box now_box = box.poll();
            int now_pick = pick.poll();

            answer += now_box.getValue(now_pick);
        }

        return answer;
    }
}