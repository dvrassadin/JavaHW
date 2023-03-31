package homework03;

import java.util.ArrayList;
import java.util.Random;

// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее ариф. из этого списка.

public class ThirdTask {
    static int min, max, sum;
    static int size = 6;
    static ArrayList<Integer> list = new ArrayList<>(size);
    static Random random = new Random();

    static double getAverage() {
        return Double.valueOf(sum) / Double.valueOf(list.size());
    }

    public static void main(String[] args) {
        for (int i = 0; i < size; i++)
            list.add(random.nextInt(size));
        System.out.println(list);

        min = max = sum = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            sum += list.get(i);
            if (list.get(i) > max)
                max = list.get(i);
            else if (list.get(i) < min)
                min = list.get(i);
        }

        System.out.printf("Minimum is %d.\nMaximum is %d.\nAverage is %f.\n",
                min, max, getAverage());
    }
}
