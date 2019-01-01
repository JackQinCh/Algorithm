import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class TopK {
    /**
     * NlogK
     */
    public List<Integer> topKLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k + 1);
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) queue.poll();
        }
        List<Integer> result = new ArrayList<>(queue);
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 5, 2, 7, 8, 9, 0, 10};
        System.out.println(Arrays.toString(new TopK().topKLargest(arr, 4).toArray()));
    }
}