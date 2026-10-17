import java.util.HashMap;

class Solution {
    public int digitSum(int n) {
        int res = 0;

        while (n > 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }

    public void mergeSort(int[][] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public void merge(int[][] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[][] left = new int[n1][2];
        int[][] right = new int[n2][2];

        for (int i = 0; i < n1; i++) {
            left[i][0] = arr[l + i][0];
            left[i][1] = arr[l + i][1];
        }

        for (int j = 0; j < n2; j++) {
            right[j][0] = arr[m + 1 + j][0];
            right[j][1] = arr[m + 1 + j][1];
        }

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            boolean takeLeft =
                left[i][1] < right[j][1] ||
                (left[i][1] == right[j][1] && left[i][0] < right[j][0]);

            if (takeLeft) 
                arr[k++] = left[i++];
            
            else 
                arr[k++] = right[j++];
        }

        while (i < n1) 
            arr[k++] = left[i++];

        while (j < n2) 
            arr[k++] = right[j++];
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] sorted = new int[n][2];

        for (int i = 0; i < n; i++) {
            sorted[i][0] = nums[i];
            sorted[i][1] = digitSum(nums[i]);
        }

        mergeSort(sorted, 0, n - 1);

        HashMap<Integer, Integer> targetIndex = new HashMap<>();
        
        for (int i = 0; i < n; i++) 
            targetIndex.put(sorted[i][0], i);
        
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int start = 0; start < n; start++) {
            if (visited[start]) 
                continue;

            int current = start;
            int cycleLength = 0;

            while (!visited[current]) {
                visited[current] = true;
                cycleLength++;
                current = targetIndex.get(nums[current]);
            }

            if (cycleLength > 1) 
                swaps += cycleLength - 1;
        }

        return swaps;
    }
}