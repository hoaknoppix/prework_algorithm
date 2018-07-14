import java.util.HashSet;

/**
 * time complexity is O(n) since hashSet.contains is O(1)
 */
public class LongestConsecutiveSequence {

    public static int getLongestConsecutiveSequence(int arr[]) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int element: arr) {
            hashSet.add(element);
        }
        int result = 0;
        for (int element: arr) {
            int greaterElements = 0;
            int lessThanElements = 0;
            int i = 1;
            while (hashSet.contains(element - i)) {
                lessThanElements++;
                i++;
            }
            i = 1;
            while (hashSet.contains(element + i)) {
                greaterElements++;
                i++;
            }
            int currentConsequenceLength = lessThanElements + greaterElements + 1;
            if (currentConsequenceLength > result) {
                result = currentConsequenceLength;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int[] arr = {100, 4, 200, 1, 3, 2, 5, 6, 7, 8, 1};
        System.out.println(getLongestConsecutiveSequence(arr));
    }
}
