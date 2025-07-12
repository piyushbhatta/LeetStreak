package LeetCodeJuly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day13_LeetCode1900 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(earliestAndLatest(11,2,4)));
    }
    static int earliest = Integer.MAX_VALUE;
    static int latest = Integer.MIN_VALUE;
    public static int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        dfs(1, createPlayerList(n), firstPlayer, secondPlayer);
        return new int[]{earliest, latest};
    }

    private static List<Integer> createPlayerList(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        return list;
    }

    private static void dfs(int round, List<Integer> players, int first, int second) {
        int size = players.size();
        for (int i = 0; i < size / 2; i++) {
            int p1 = players.get(i);
            int p2 = players.get(size - 1 - i);

            if ((p1 == first && p2 == second) || (p1 == second && p2 == first)) {
                earliest = Math.min(earliest, round);
                latest = Math.max(latest, round);
                return;
            }
        }

        List<List<Integer>> nextRounds = new ArrayList<>();
        simulate(players, 0, new ArrayList<>(), nextRounds, first, second);

        for (List<Integer> next : nextRounds) {
            Collections.sort(next);
            dfs(round + 1, next, first, second);
        }
    }

    private static void simulate(List<Integer> players, int i, List<Integer> path, List<List<Integer>> result, int first, int second) {
        int size = players.size();
        if (i >= size / 2) {
            if (size % 2 == 1) path.add(players.get(size / 2));
            result.add(new ArrayList<>(path));
            if (size % 2 == 1) path.removeLast();
            return;
        }

        int a = players.get(i);
        int b = players.get(size - 1 - i);
        if (a == first || a == second) {
            path.add(a);
            simulate(players, i + 1, path, result, first, second);
            path.removeLast();
        } else if (b == first || b == second) {
            path.add(b);
            simulate(players, i + 1, path, result, first, second);
            path.removeLast();
        } else {
            path.add(a);
            simulate(players, i + 1, path, result, first, second);
            path.removeLast();

            path.add(b);
            simulate(players, i + 1, path, result, first, second);
            path.removeLast();
        }
    }
}
