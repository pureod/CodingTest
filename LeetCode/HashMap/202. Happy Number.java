class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();

        while (n != 1 && !visited.contains(n)) {
            visited.add(n);
            n = getNext(n);
        }

        return n == 1;
    }

    private int getNext(int num) {
        int sum = 0;

        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }

        return sum;
    }
}