import java.util.*;

public class UniquePermutation {

    private static void getUniquePermutations(int[] arr, int level, List<int[]> result, HashSet<String> hashSet) {
        if (level == arr.length - 1) {
            StringBuilder sb = new StringBuilder();
            Arrays.stream(arr).forEach(sb::append);
            String s = sb.toString();
            if (!hashSet.contains(s)) {
                hashSet.add(s);
                result.add(arr.clone());
            }
            return;
        }
        getUniquePermutations(arr, level + 1, result, hashSet);
        for (int i = arr.length - 1; i >= level; i--) {
            if (i == level) {
                continue;
            }
            int tmp = arr[level];
            arr[level] = arr[i];
            arr[i] = tmp;
            getUniquePermutations(arr, level + 1, result, hashSet);
            tmp = arr[level];
            arr[level] = arr[i];
            arr[i] = tmp;
        }
    }

    public static List<int[]> getUniquePermutations(int[] arr) {
        List<int[]> result = new ArrayList<>();
        HashSet<String> flags = new HashSet<>();
        getUniquePermutations(arr, 0, result, flags);
        return result;
    }


    public static void main(String args[]) {
        int[] arr = {1, 2, 2};
        List<int[]> uniquePermutations = getUniquePermutations(arr);
        uniquePermutations.forEach(array -> {
            Arrays.stream(array).forEach(element -> {
                System.out.print(element + " ");
            });
            System.out.println();
        });
    }
}
