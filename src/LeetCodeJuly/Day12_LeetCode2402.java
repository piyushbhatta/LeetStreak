package LeetCodeJuly;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Day12_LeetCode2402 {
    public static void main(String[] args) {

    }
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        int[] roomCount = new int[n];
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < n; i++) available.offer(i);

        PriorityQueue<long[]> busy = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );

        for (int[] m : meetings) {
            int start = m[0], end = m[1], duration = end - start;

            // Free up rooms that are done before start
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                available.offer((int) busy.poll()[1]);
            }

            if (!available.isEmpty()) {
                int room = available.poll();
                busy.offer(new long[]{start + duration, room});
                roomCount[room]++;
            } else {
                long[] earliest = busy.poll();
                long newStart = earliest[0];
                int room = (int) earliest[1];
                busy.offer(new long[]{newStart + duration, room});
                roomCount[room]++;
            }
        }

        int max = 0, result = 0;
        for (int i = 0; i < n; i++) {
            if (roomCount[i] > max) {
                max = roomCount[i];
                result = i;
            }
        }
        return result;
    }
}
