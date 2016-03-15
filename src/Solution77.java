import java.util.ArrayList;
import java.util.List;

/**
 * Created by X on 03/03/2016.
 */
public class Solution77 {
    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> l = new ArrayList<>();

        if (n < k || n <= 0) {
            return l;
        }

        recursive(n, k, 1, new ArrayList<>(), l);

        return l;

    }

    public static void recursive(int n, int k, int from, List<Integer> item, List<List<Integer>> res) {
        if (item.size() == k) {
            res.add(new ArrayList<>(item));
            return;
        }

        for (int i = from; i <= n; i ++) {
            item.add(i);
            recursive(n, k, i + 1, item, res);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String [] args) {
        int n = 5;
        int k = 3;
        List<List<Integer>> l = combine(n, k);

        System.out.print(l);
    }
}
