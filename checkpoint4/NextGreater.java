import java.util.Arrays;

public class NextGreater {
    public static int[] getNextGreaterArray(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            boolean foundNextGreater = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    result[i] = arr[j];
                    foundNextGreater = true;
                    break;
                }
            }
            if (!foundNextGreater) {
                result[i] = -1;
            }
        }
        return result;
    }
    public static void main(String args[]) {
        int[] test = {4, 5, 2, 10};
        Arrays.stream(getNextGreaterArray(test)).forEach(e -> System.out.print(e + " "));
    }
}
