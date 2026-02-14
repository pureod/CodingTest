import java.util.*;

class Solution {
    private static class Truck {
        int start, weight;

        public Truck (int start, int weight) {
            this.start = start;
            this.weight = weight;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int n = truck_weights.length;
        int total_weight = 0;
        int time = 0;

        ArrayDeque<Truck> wait = new ArrayDeque<>();
        for (int w : truck_weights) wait.addLast(new Truck(0, w));

        ArrayDeque<Truck> bridge = new ArrayDeque<>();

        while (!wait.isEmpty()) {
            Truck now = wait.peek();

            while (!bridge.isEmpty() && time - bridge.peek().start >= bridge_length) {
                Truck remove = bridge.pollFirst();
                total_weight -= remove.weight;
            }

            if (total_weight + now.weight <= weight) {
                wait.pollFirst();
                bridge.addLast(new Truck(time, now.weight));
                total_weight += now.weight;
            }

            time++;
        }

        return time + bridge_length;
    }
}