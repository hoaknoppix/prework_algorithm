public class KthSmallestElement {

    /*
    There are several solutions such as sorting the array first, using heap for better performance.
    In this case, the solution must use constant extra space, so I cannot use it.
    Current time complexity O(n^2)
     */
    public static int findKthSMallestElement(int[] arr, int k) {
        if (k > arr.length || k < 1) {
            return -1;
        }
        int result = -1;
        int numberOfSmallerElements = 0;
        int numberOfEqualElements = 0;
        int i;
        int j;
        for (i = 0; i < arr.length; i++) {
            numberOfSmallerElements = 0;
            numberOfEqualElements = 0;
            for (j = 0; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[i] > arr[j]) {
                    numberOfSmallerElements++;
                }
                if (arr[i] == arr[j]) {
                    numberOfEqualElements++;
                }
            }
            if (k >= numberOfSmallerElements + 1 && k <= numberOfEqualElements + numberOfSmallerElements + 1) {
                result = arr[i];
                break;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int[] arr = {9, 9, 9, 9, 9, 9, 9, 9, 5, 2, 1};
        System.out.println(findKthSMallestElement(arr, arr.length - 3));
    }
}
