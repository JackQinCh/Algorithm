public class QuickFind implements UnionFind {
    private int[] id;
    private int count;

    public QuickFind(int n) {
        id = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    /**
     * O(1).
     */
    @Override
    public boolean find(int p, int q) {
        return id[p] == id[q];
    }

    /**
     * O(n).
     */
    @Override
    public void unite(int p, int q) {
        int pid = id[p];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) id[i] = id[q];
        }
        count--;
    }

    @Override
    public int unions() {
        return count;
    }

    public static void main(String[] args) {
        UnionFind unionFind = new QuickFind(10);

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