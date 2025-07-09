package LeetCodeJuly;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Day8_LeetCode1353 {
    public static void main(String[] args) {

    }
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i = 0, day = 0, count = 0, n = events.length;

        while (i < n || !minHeap.isEmpty()) {
            if (minHeap.isEmpty()) {
                day = events[i][0];
            }

            while (i < n && events[i][0] == day) {
                minHeap.offer(events[i][1]);
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                count++;
            }

            day++;
        }
        return count;
    }
}
