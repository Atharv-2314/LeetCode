class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];

        for (int digit : digits) {
            freq[digit]++;
        }

        int count = 0;

        for (int num = 100; num <= 998; num += 2) {
            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;

            int[] used = new int[10];
            used[a]++;
            used[b]++;
            used[c]++;

            boolean possible = true;

            for (int digit = 0; digit <= 9; digit++) {
                if (used[digit] > freq[digit]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                count++;
            }
        }

        return count;
    }
}