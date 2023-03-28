// Вывести все простые числа от 1 до 1000

public class Task02 {
    public static void main(String[] args) {
        for (int i = 2; i < 1001; i++) {
            boolean wasBroke = false;
            for (int j = 2; j < i / 2 + 1; j++)
                if (i % j == 0) {
                    wasBroke = true;
                    break;
                }
            if (!wasBroke)
                System.out.printf("%d, ", i);
            wasBroke = false;
        }
    }
}
