package homework02.Task01;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// Реализуйте алгоритм сортировки пузырьком числового массива (введён вами), 
// результат после каждой итерации запишите в лог-файл.

public class Program {
    public static final Logger logger = Logger.getLogger(Program.class.getName());

    public static void main(String[] args) throws IOException {
        FileHandler fh = new FileHandler("homework02/Task01/log.txt");
        logger.addHandler(fh);

        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);

        int[] array = { 4, 5, 56, 2, 8, 0, 4, 2, 1, 12, 7, 8, 9, 11 };

        bubbleSort(array);
    }

    static int[] bubbleSort(int[] array) {
        logger.log(Level.INFO, intArrayToString(array));
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    logger.log(Level.INFO, intArrayToString(array));
                }
            }
        }
        return array;
    }

    static String intArrayToString(int[] array) {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i : array)
            result.append(String.format("%d, ", i));
        result.setLength(result.length() - 2);
        result.append("]\n");
        return result.toString();
    }
}
