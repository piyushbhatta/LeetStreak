package LeetCodeJuly;

public class Day5_LeetCode3307 {
    public static void main(String[] args) {

    }
    public static char kthCharacter(long k, int[] operations) {
        int n = operations.length;
        long[] lengths = new long[n + 1];
        lengths[0] = 1;
        for (int i = 0; i < n; i++) {
            lengths[i + 1] = Math.min((long) 1e18, lengths[i] * 2);
        }
        int shift = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (k > lengths[i]) {
                k -= lengths[i];
                if (operations[i] == 1) {
                    shift++;
                }
            }

        }
        char ch = 'a';
        ch = (char) ((ch - 'a' + shift) % 26 + 'a');
        return ch;
    }
}
