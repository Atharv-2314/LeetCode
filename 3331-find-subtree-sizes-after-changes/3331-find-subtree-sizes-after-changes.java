class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] original = new ArrayList[n];
        List<Integer>[] modified = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            original[i] = new ArrayList<>();
            modified[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) 
            original[parent[i]].add(i);

        int[] last = new int[26];
        Arrays.fill(last, -1);

        int[] previous = new int[n];
        int[] newParent = new int[n];

        int[] stack = new int[2 * n];
        int top = 0;

        stack[top++] = 1; 

        while (top > 0) {
            int event = stack[--top];

            int node = Math.abs(event) - 1;
            int c = s.charAt(node) - 'a';

            if (event < 0) {
                last[c] = previous[node];
                continue;
            }

            int p = last[c];

            if (node == 0) 
                newParent[node] = -1;
            
            else if (p != -1) 
                newParent[node] = p;
            
            else 
                newParent[node] = parent[node];

            if (newParent[node] != -1) 
                modified[newParent[node]].add(node);

            previous[node] = last[c];
            last[c] = node;

            stack[top++] = -(node + 1);

            List<Integer> children = original[node];

            for (int i = children.size() - 1; i >= 0; i--) 
                stack[top++] = children.get(i) + 1;
        }

        int[] answer = new int[n];

        Arrays.fill(answer, 1);

        int[] order = new int[n];
        int[] dfs = new int[n];

        int count = 0;
        top = 0;

        dfs[top++] = 0;

        while (top > 0) {
            int node = dfs[--top];

            order[count++] = node;

            for (int child : modified[node]) 
                dfs[top++] = child;
        }

        for (int i = count - 1; i > 0; i--) {
            int node = order[i];
            answer[newParent[node]] += answer[node];
        }

        return answer;
    }
}