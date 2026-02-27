import java.util.*;

class Solution {
    private static class File {
        String head, name;
        int number;

        public File (String head, int number, String name) {
            this.head = head;
            this.number = number;
            this.name = name;
        }
    }

    public String[] solution(String[] files) {
        int n = files.length;

        File[] arr = new File[n];

        for (int i = 0; i < n; i++) {
            String file = files[i];
            boolean check = false;

            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            for (char c : file.toCharArray()) {
                if (!Character.isDigit(c) && check) {
                    break;
                }

                if (Character.isLetter(c) || c == '-' || c == ' ') {
                    sb1.append(c);
                }

                if (Character.isDigit(c)) {
                    check = true;
                    sb2.append(c);
                }
            }

            String head = sb1.toString().toLowerCase();
            int number = Integer.valueOf(sb2.toString());

            arr[i] = new File(head, number, file);
        }

        Arrays.sort(arr, (o1,o2) -> {
            if (o1.head.compareTo(o2.head) != 0) return o1.head.compareTo(o2.head);
            else return Integer.compare(o1.number, o2.number);
        });

        String[] answer = new String[n];

        for (int i = 0; i < n; i++) answer[i] = arr[i].name;

        return answer;
    }
}