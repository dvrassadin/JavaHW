import java.util.Scanner;

// *(ДОПОЛНИТЕЛЬНАЯ) +Задано уравнение вида q + w = e, q, w, e >= 0. 
// Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69 (пользователь). 
// Требуется восстановить выражение до верного равенства. 
// Предложить хотя бы одно решение или сообщить, что его нет.
// под знаками вопроса - одинаковые цифра
// Ввод: 2? + ?5 = 69
// Вывод: 24 + 45 = 69

public class Task04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the equation:");
        String equation = sc.nextLine();
        sc.close();

        String firstNumber = equation.split(" ")[0];
        String secondNumber = equation.split(" ")[2];
        int result = Integer.parseInt(equation.split(" ")[4]);
        boolean wasFound = false;

        for (int i = 0; i < 10; i++) {
            var firstInt = Integer.parseInt(firstNumber.replace("?", Integer.toString(i)));
            for (int j = 0; j < 10; j++) {
                var secondInt = Integer.parseInt(secondNumber.replace("?", Integer.toString(j)));
                if (firstInt + secondInt == result) {
                    wasFound = true;
                    System.out.printf("%d + %d = %d\n", firstInt, secondInt, result);
                }
            }
        }
        if (!wasFound)
            System.out.println("It can't be.");
    }
}
