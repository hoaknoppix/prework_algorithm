import java.util.ArrayList;
import java.util.List;

public class Numrange {
    public static List<List<Integer>> getSubsequences(int[] arr, int b, int c) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> subSequence = new ArrayList<>();
            subSequence.add(arr[i]);
            int j = i;
            int t = arr[i];
            while (t <= c) {
                if (t >= b) {
                    ArrayList<Integer> newSubSequence = (ArrayList<Integer>)subSequence.clone();
                    result.add(newSubSequence);
                }
                j++;
                if (j == arr.length) {
                    break;
                }
                subSequence.add(arr[j]);
                t += arr[j];
            }
        }
        return  result;
    }

    public static void main(String args[]) {
        int[] arr = {10, 5, 1, 0, 2};
        List<List<Integer>> subSequences = getSubsequences(arr, 1, 15);
        for (List<Integer> subSequence : subSequences) {
            for (int i = 0; i < subSequence.size(); i++) {
                if (i == 0) {
                    System.out.print("[");
                }
                System.out.print(subSequence.get(i));
                if (i == subSequence.size() - 1) {
                    System.out.print("]");
                } else {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
