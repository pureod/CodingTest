import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        PriorityQueue<Integer> pq_max = new PriorityQueue<>(
            (o1,o2) -> Integer.compare(o2,o1));
        PriorityQueue<Integer> pq_min = new PriorityQueue<>();

        for (String operation : operations) {
            String[] operationArr = operation.split(" ");
            char cmd = operationArr[0].charAt(0);
            int num = Integer.parseInt(operationArr[1]);

            if (cmd == 'I') {
                hash.put(num, hash.getOrDefault(num,0)+1);
                pq_max.add(num);
                pq_min.add(num);
            }
            else if (cmd == 'D') {
                if (num == 1) {
                    if (hash.isEmpty()) continue;
                    int target = 0;
                    while (true) {
                        int t = pq_max.poll();
                        if (hash.getOrDefault(t,-1) != -1) {
                            target = t;
                            break;
                        }
                    }
                    hash.put(target, hash.get(target)-1);
                    hash.remove(target,0);
                }
                else {
                    if (hash.isEmpty()) continue;
                    int target = 0;
                    while (true) {
                        int t = pq_min.poll();
                        if (hash.getOrDefault(t,-1) != -1) {
                            target = t;
                            break;
                        }
                    }
                    hash.put(target, hash.get(target)-1);
                    hash.remove(target,0);
                }
            }

        }

        int[] answer = new int[hash.size()];
        int cnt = 0;
        for (Integer key : hash.keySet()) {
            answer[cnt++] = key;
        }

        Arrays.sort(answer);

        if (answer.length >= 2) {
            return new int[] {answer[answer.length-1],answer[0]};
        }
        else if (answer.length == 1) {
            return new int[] {answer[0],answer[0]};
        }
        else {
            return new int[] {0,0};
        }
    }
}