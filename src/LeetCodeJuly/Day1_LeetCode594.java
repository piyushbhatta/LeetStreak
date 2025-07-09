package LeetCodeJuly;
import java.util.HashMap;
import java.util.Map;

/// We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
///
/// Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.
public class Day1_LeetCode594 {
    public static void main(String[] args) {
        int[] nums ={1,3,2,2,5,2,3,7};
        System.out.println(findLHS(nums));
    }
    public static int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        int maxLength = 0;
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                int length = map.get(key) + map.get(key + 1);
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }
}
