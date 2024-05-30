package reverseArray;

import java.util.ArrayList;
import java.util.List;

public class ReverseArray {

    public static void main(String[] args) {
        List<Integer> a = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(reverseArray(a));
    }


    public static List<Integer> reverseArray(List<Integer> a) {
        // Write your code here
        if (a.isEmpty()) {
            return a;
        }
        ArrayList<Integer> reversed = new ArrayList<>(2);

        for (int i = a.size() - 1; i >= 0; i--) {
          reversed.add(a.get(i));
        }

        return reversed;
    }
}
