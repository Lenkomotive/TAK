package algorithm;

import java.util.ArrayList;
import java.util.List;

public class PartitionHelper {

    public static List<List<Integer>> getAllPartitions(int target) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        getAllPartitions(target, 0, 1, output, result);
        return (List)output;
    }

    private static void getAllPartitions(
            int target,
            int current_sum,
            int start, ArrayList<ArrayList<Integer>> output,
            ArrayList<Integer> result) {

        if (target == current_sum) {
            output.add((ArrayList)result.clone());
        }

        for (int i = start; i < target; ++i) {
            int temp_sum = current_sum + i;
            if (temp_sum <= target) {
                result.add(i);
                getAllPartitions(target, temp_sum, i, output, result);
                result.remove(result.size() - 1);
            } else {
                return;
            }
        }
    }
}
