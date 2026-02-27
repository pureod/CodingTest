import java.util.*;

class Solution {
    static class Expr {
        String A, B, C;
        char op;
        boolean unknown; // C == "X"
        Expr(String a, char op, String b, String c) {
            this.A = a;
            this.op = op;
            this.B = b;
            this.C = c;
            this.unknown = "X".equals(c);
        }
    }

    public String[] solution(String[] expressions) {
        List<Expr> list = new ArrayList<>();
        for (String s : expressions) {
            String[] t = s.split(" "); // "A", "+/-", "B", "=", "C"
            list.add(new Expr(t[0], t[1].charAt(0), t[2], t[4]));
        }

        List<Integer> possibleBases = new ArrayList<>();
        for (int base = 2; base <= 9; base++) {
            if (isPossibleBase(list, base)) possibleBases.add(base);
        }

        List<String> answer = new ArrayList<>();
        for (Expr e : list) {
            if (!e.unknown) continue;

            String first = null;
            boolean same = true;

            for (int base : possibleBases) {
                int a = parseBase(e.A, base);
                int b = parseBase(e.B, base);
                int res = (e.op == '+') ? (a + b) : (a - b);

                String resStr = toBaseString(res, base);

                if (first == null) first = resStr;
                else if (!first.equals(resStr)) {
                    same = false;
                    break;
                }
            }

            String filled = same ? first : "?";
            answer.add(e.A + " " + e.op + " " + e.B + " = " + filled);
        }

        return answer.toArray(new String[0]);
    }

    private boolean isPossibleBase(List<Expr> list, int base) {
        for (Expr e : list) {
            // A, B는 항상 숫자
            if (!digitsValid(e.A, base) || !digitsValid(e.B, base)) return false;

            // C가 숫자일 때만 검증/계산에 사용
            if (!e.unknown) {
                if (!digitsValid(e.C, base)) return false;

                int a = parseBase(e.A, base);
                int b = parseBase(e.B, base);
                int c = parseBase(e.C, base);

                int res = (e.op == '+') ? (a + b) : (a - b);
                if (res != c) return false;
            }
        }
        return true;
    }

    private boolean digitsValid(String s, int base) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') return false;
            int d = ch - '0';
            if (d >= base) return false;
        }
        return true;
    }

    private int parseBase(String s, int base) {
        return Integer.parseInt(s, base);
    }

    private String toBaseString(int value, int base) {
        if (value == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int v = value;
        while (v > 0) {
            sb.append(v % base);
            v /= base;
        }
        return sb.reverse().toString();
    }
}
