public class CheckPoint2 {

    public static int[][] getConcentricRectangularArray(int size) {
        if (size < 1) {
            return null;
        }
        int n = 1 + (size - 1) * 2;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = Math.min(i, j);
                int l = Math.max(i, j);
                arr[i][j] = Math.max(size - k, l - (n - size - 1));
            }
        }
        return arr;
    }

    public static void main(String args[]) {
        int[][] arr = getConcentricRectangularArray(9);
        for (int i = 0; i <arr.length; i++) {
            for (int j = 0; j <arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
