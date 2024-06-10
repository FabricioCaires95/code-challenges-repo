package sortingAlgorithms;


public class DivideConquerSum {

    public static void main(String[] args) {

        int[] array = {4, 6, 3};

        System.out.println(sumArraysDC(array, 0, array.length));

    }

    private static int sumArraysDC(int[] array, int i, int n) {
        if (i == n) {
            return 0;
        }
        // 1 = 4 + (array, 1, 3) = 4
        // 2 = 6 + (array, 2, 3 ) = 6
        // 3 = 3 + (array, 3, 3) = 3
        return array[i] + sumArraysDC(array, i + 1, n);
    }
}

