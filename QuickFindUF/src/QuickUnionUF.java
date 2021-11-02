public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("Index Illegal");
        }
    }

    private int root(int i) {
        validate(i);
        while (i != id[i]) { // i = 1 id[i] = 1 -> false
            i = id[i]; // i = break
        }
        return i; // i = 1
    }

    public boolean connected(int p, int q) { // p = 6 -> 0 q = 1 -> 1
        return root(p) == root(q); // false
    }

    public void union(int p, int q) { // p = 6 q = 1
        int i = root(p); // -> 0
        int j = root(q); // -> 1
        if (i == j) return;
        id[i] = j; // id[i] = 0 j = 1 -> id[i] = 1
    }
}
