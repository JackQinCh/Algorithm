public class QuickUnion implements UnionFind {
    private int parent[];
    private int count;
    private int treeSize[];

    public QuickUnion(int n) {
        parent = new int[n];
        treeSize = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            treeSize[i] = 1;
        }
    }

    private int root(int i) {
        while (i != parent[i]){
            parent[i] = parent[parent[i]];
            i = parent[i];
        } 
        return i;
    }

    /**
     * O(logn).
     */
    @Override
    public boolean find(int p, int q) {
        return root(p) == root(q);
    }

    /**
     * O(logn).
     */
    @Override
    public void unite(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (treeSize[i] < treeSize[j]) {
            parent[i] = j;
            treeSize[j] += treeSize[i];
        } else {
            parent[j] = i;
            treeSize[i] += treeSize[j];
        }
        count--;
    }

    @Override
    public int unions() {
        return count;
    }

    public static void main(String[] args) {
        UnionFind unionFind = new QuickUnion(10);

        unionFind.unite(2, 3);
        unionFind.unite(3, 4);
        unionFind.unite(5, 6);
        unionFind.unite(4, 9);
        
        System.out.println("0 is union with 1: " + unionFind.find(0, 1));
        System.out.println("3 is union with 4: " + unionFind.find(3, 4));
        System.out.println("4 is union with 9: " + unionFind.find(4, 9));
        System.out.println("5 is union with 6: " + unionFind.find(5, 6));
        System.out.println("7 is union with 8: " + unionFind.find(7, 8));
        System.out.println("5 is union with 9: " + unionFind.find(5, 9));

        System.out.println("unions is " + unionFind.unions());
    }
}