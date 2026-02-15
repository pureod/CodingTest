class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] arr = new int[20001];

        for (int num : nums) arr[num+10000]++;

        for (int i = 20000; i >= 0; i--) {
            if (arr[i] == 0) continue;

            int count = arr[i];

            for (int j = 0; j < count; j++) {
                k--;
                if (k == 0) return i - 10000;
            }
        }

        return 0;
    }
}