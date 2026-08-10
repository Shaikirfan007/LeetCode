class Solution {
    public int[] findPeakGrid(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int low = 0;
        int high = cols - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Find the maximum element in this column
            int maxRow = 0;

            for (int i = 1; i < rows; i++) {
                if (mat[i][mid] > mat[maxRow][mid]) {
                    maxRow = i;
                }
            }

            // Values on left and right
            int left = (mid - 1 >= 0) ? mat[maxRow][mid - 1] : -1;
            int right = (mid + 1 < cols) ? mat[maxRow][mid + 1] : -1;

            // If current element is greater than left and right,
            // it is a peak.
            if (mat[maxRow][mid] > left &&
                mat[maxRow][mid] > right) {

                return new int[]{maxRow, mid};
            }

            // If left is greater, move towards left
            if (left > mat[maxRow][mid]) {
                high = mid - 1;
            }

            // Otherwise move towards right
            else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }
}