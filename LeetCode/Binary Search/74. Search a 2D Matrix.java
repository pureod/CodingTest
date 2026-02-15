class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] > target) return false;
            if (matrix[i][m-1] < target) continue;

            int idx = Arrays.binarySearch(matrix[i], target);

            if (idx >= 0) return true;
        }

        return false;
    }
}