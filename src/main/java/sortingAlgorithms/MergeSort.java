package sortingAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {

        int array [] = {5, 7, 1, 10, 6, 3, 2, 9};
        System.out.println(Arrays.toString(array));
        List<Integer> t = new ArrayList<>();
        mergeSort(array);

        System.out.println(Arrays.toString(array));

    }

    private static void mergeSort(int[] array) {
        int arraySize = array.length; // 8

        if (arraySize <= 1)  return; // base case
        //{5, 7, 1, 10, 6, 3, 2, 9};
        int middle = arraySize / 2; //4
        int [] leftArray = new int[middle]; //
        int [] righArray = new int[arraySize - middle]; //

        int leftIndex = 0; //
        int rightIndex = 0;

        //populate sub arrays
        for (; leftIndex < array.length; leftIndex++) {
            if (leftIndex < middle) {
                leftArray[leftIndex] = array[leftIndex];
            } else {
                righArray[rightIndex] = array[leftIndex];
                rightIndex++;
            }
        }
        mergeSort(leftArray);
        mergeSort(righArray);
        merge(leftArray, righArray, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0; //originalArray
        int l = 0;
        int r = 0;

        while (l < leftSize && r < rightSize) {
            if (leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }

        while (l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }

        while (r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }


    }

}
