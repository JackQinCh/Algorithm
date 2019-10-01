public class BinaryIndexedTree {
    private final int[] bitArr;

    public BinaryIndexedTree(final int[] arr) {
        bitArr = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            update(i, arr[i]);
        }
    }

    public void update(final int index, final int value) {
        int idx = index + 1;
        while (idx < bitArr.length) {
            bitArr[idx] += value;
            idx = idx + (idx & -idx);
        }
    }

    public int prefixSum(final int index) {
        int idx = index + 1;
        int sum = 0;
        while (idx > 0) {
            sum += bitArr[idx];
            idx = idx - (idx & -idx);
        }
        return sum;
    }

    public int rangeSum(final int start, final int end) {
        return prefixSum(end) - prefixSum(start - 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0,1,2,3,4,5,6,7,8,9};
        BinaryIndexedTree bitTree = new BinaryIndexedTree(arr);
        System.out.println(bitTree.prefixSum(5));
        System.out.println(bitTree.rangeSum(2, 8));
        System.out.println(bitTree.rangeSum(5, 9));
        bitTree.update(2, 10);
        System.out.println(bitTree.prefixSum(5));
        System.out.println(bitTree.rangeSum(2, 8));
        System.out.println(bitTree.rangeSum(5, 9));
    }
}