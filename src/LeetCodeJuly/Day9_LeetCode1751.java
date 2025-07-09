package LeetCodeJuly;

import java.util.Arrays;

public class Day9_LeetCode1751 {
    public static void main(String[] args) {

    }
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int n = events.length;

        int[] startDays = new int[n];
        for (int i = 0; i < n; i++) {
            startDays[i] = events[i][0];
        }

        Integer[][] dp = new Integer[n][k + 1];

        return dfs(0, k, events, startDays, dp);
    }

    private int dfs(int i, int remaining, int[][] events, int[] startDays, Integer[][] dp) {
        if (i >= events.length || remaining == 0) return 0;
        if (dp[i][remaining] != null) return dp[i][remaining];

        int skip = dfs(i + 1, remaining, events, startDays, dp);

        int next = upperBound(startDays, events[i][1]);
        int take = events[i][2] + dfs(next, remaining - 1, events, startDays, dp);

        return dp[i][remaining] = Math.max(skip, take);
    }
    private int upperBound(int[] startDays, int targetEnd) {
        int low = 0, high = startDays.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (startDays[mid] <= targetEnd) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
