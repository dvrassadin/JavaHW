package homework03;

import java.util.Arrays;
import java.util.Random;

// (Дополнительное) Реализовать алгоритм сортировки слиянием

public class FirstTask {
    public static void main(String[] args) {
        var array = createRandomArray();
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(mergeSort(array)));
    }

    static int[] mergeSort(int[] array) {
        if (array.length < 2)
            return array;
        int[] leftHalf = mergeSort(Arrays.copyOf(array, array.length / 2));
        int[] rightHalf = mergeSort(Arrays.copyOfRange(array, array.length / 2, array.length));
        int[] result = new int[array.length];
        int li = 0;
        int ri = 0;
        for (int i = 0; i < result.length; i++) {
            if (li == leftHalf.length) {
                System.arraycopy(rightHalf, ri, result, i, rightHalf.length - ri);
                break;
            } else if (ri == rightHalf.length) {
                System.arraycopy(leftHalf, li, result, i, leftHalf.length - li);
                break;
            } else if (leftHalf[li] <= rightHalf[ri]) {
                result[i] = leftHalf[li];
                li++;
            } else {
                result[i] = rightHalf[ri];
                ri++;
            }
        }
        return result;
    }

    static int[] createRandomArray() {
        Random random = new Random();
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++)
            array[i] = random.nextInt(9);
        return array;
    }
}
