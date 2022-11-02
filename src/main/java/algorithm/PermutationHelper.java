package algorithm;

import java.util.ArrayList;
import java.util.List;

public class PermutationHelper {

    public static List<List<Integer>> permute(List<Integer> currentPartition) {
        List<List<Integer>> result = new ArrayList<>();
        Permutation(0, currentPartition, result);
        return  deduplicate(result);
    }

    public static void Permutation(int i, List<Integer> nums, List<List<Integer>> result) {
        if (i == nums.size() - 1) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) list.add(n);
            result.add(list);
        } else {
            for (int j = i, l = nums.size(); j < l; j++) {
                int temp = nums.get(j);
                nums.set(j,nums.get(i));
                nums.set(i,temp);
                Permutation(i + 1, nums, result);
                temp = nums.get(j);
                nums.set(j,nums.get(i));
                nums.set(i,temp);
            }
        }
    }

    private static List<List<Integer>> deduplicate(List<List<Integer>> result) {
        List<List<Integer>>  unique = new ArrayList<>();
        result.forEach(e -> {
            if(!unique.contains(e)) {
                unique.add(e);
            }
        });
        return unique;
    }

    public static List<List<Integer>> filterPermutations(List<List<Integer>> permutedPartitions, int n) {
        List<List<Integer>> filteredPermutations = new ArrayList<>();
        for (var permutation : permutedPartitions) {
            int sum = 0;
            for (var element : permutation) {
                sum += element;
            }
            if (sum == n) {
                filteredPermutations.add(permutation);
            }
        }
        return filteredPermutations;
    }
}
