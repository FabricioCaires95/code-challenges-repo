package specialArray;

import java.util.Arrays;

/**
 * You are given an array nums of non-negative integers. nums is considered special if there exists a number x such that there are exactly x numbers in nums that are greater than or equal to x.
 *
 * Notice that x does not have to be an element in nums.
 *
 * Return x if the array is special, otherwise, return -1. It can be proven that if nums is special, the value for x is unique.
 */
public class SpecialArrayApp {

    public static void main(String[] args) {
        var nums = new int[]{0,4,3,0,4};
        System.out.println(specialArrayBruteForce(nums));

        var nums2 = new int[]{0,4,3,0,4};
        System.out.println(specialArray(nums2));

        var nums3 = new int[]{0,4,3,0,4};
        System.out.println(specialArrayNComplexity(nums3));
    }


    private static int specialArrayBruteForce(int[] nums) {
        for (int i = 1; i <= nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] >= i) {
                    count++;
                }
            }
            if (count == i) {
                return i;
            }
        }
        return -1;
    }

    private static int specialArray(int[] nums) {
        Arrays.sort(nums);
        int sizeArray = nums.length;

        if (nums[0] > sizeArray) {
            return sizeArray;
        }

        for (int i = 1; i <= sizeArray; i++) {
            if (nums[sizeArray - i] >= i && (nums[sizeArray - i - 1] < 0 || nums[sizeArray - i - 1] < i)) {
                return i;
            }
        }

        return -1;
    }

    private static int specialArrayNComplexity(int[] nums) {
        int[] bucket = new int[1001];
        for (int num: nums) {
            bucket[num]++;
        }
        int total = nums.length;
        for (int i = 0; i < 1001; i++) {
            if (i == total){
                return i;
            }
            total -= bucket[i];
        }

        return -1;
    }

}
