package sortingAlgorithms;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {10, 80, 30, 90, 40};
        int arraySize = array.length;
        System.out.println(Arrays.toString(array));
        quickSortArray(array, 0, arraySize - 1);
        System.out.println("Sorted array");
        System.out.println(Arrays.toString(array));
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high) {
        // Choosing the pivot
        int pivot = arr[high];
        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private static void quickSortArray(int[] array, int start, int end) {
        if (start < end) {
            int pi = partition(array, start, end);
            quickSortArray(array, start, pi - 1);
            quickSortArray(array, pi + 1, end);
        }
    }

}
