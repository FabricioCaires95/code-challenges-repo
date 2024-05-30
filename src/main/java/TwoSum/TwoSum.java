package TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * Brute Force Implementation, with O(n^2) time complexity
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private static int[] twoSumOption(int[] nums, int target) {
        int left = 0, right = nums.length - 1, sum = 0;

        while (left < right) {
            sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }


    private static int[] twoSumOptimizedHashMap(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // Find the complement
            int complement = target - nums[i];

            if (target == complement) {
                return new int[]{i, i};
            }

            if (numMap.containsKey(complement)) {
                return new int[]{i, numMap.get(complement)};
            } else {
                numMap.put(nums[i], i);
            }
        }

        return new int[]{-1, -1};
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{3, 2, 3};
//        int target = 6;
//        int[] result = twoSumTest(nums, target);
//        System.out.println(result[0] + " " + result[1]);

        int[] nums = new int[]{10, 9, 19, 15};
        int target = 25;
        int[] x = twoSumOptimizedHashMap(nums, target);
        System.out.println(Arrays.toString(x));

        int[] y = twoSumOption(nums, target);
        System.out.println(Arrays.toString(y));

    }





}
