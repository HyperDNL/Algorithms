public class UFCanonical {
    private int[] id;
    private int[] sz;

    public UFCanonical(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("Index Illegal");
        }
    }

    public int find(int i) {
        validate(i);

        return i;
    }

    public int root(int i) {
        validate(i);
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) return;

        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] = sz[j];
        }
    }

    public static void main(String[] args) {
        int n = 10;

        UFCanonical uf = new UFCanonical(n);

        uf.union(0, 1);
        uf.union(1, 4);
        uf.union(4, 6);
        uf.union(5, 7);
        uf.union(6, 5);

        for(int i = 0; i < n; i++){
            System.out.println(uf.root(i));
        }
    }
}
