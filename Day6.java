import java.util.*;

public class Day6 {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            
            if (prefixSum == 0) {
                result.add(new int[]{0, i});
            }

           
            if (map.containsKey(prefixSum)) {
                for (int start : map.get(prefixSum)) {
                    result.add(new int[]{start + 1, i});
                }
            }

            map.putIfAbsent(prefixSum, new ArrayList<>());
            map.get(prefixSum).add(i);
        }
        return result;
    }

 
    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3, -1, 2};
        List<int[]> subarrays = findZeroSumSubarrays(arr);

        for (int[] indices : subarrays) {
            System.out.println("(" + indices[0] + ", " + indices[1] + ")");
        }
    }
}
