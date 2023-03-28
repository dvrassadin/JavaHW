import java.util.Scanner;

// Реализовать простой калькулятор (+ - / *)
// Ввод числа ->
// Ввод знака ->
// Ввод числа ->

public class Task03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double firstNumber = sc.nextDouble();

        System.out.print("Enter the operation: ");
        String operation = sc.next();

        System.out.print("Enter the second number: ");
        double secondNumber = sc.nextDouble();

        sc.close();

        Double result = null;
        switch (operation) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;
        }

        System.out.printf("%f %s %f = %f", firstNumber, operation, secondNumber,
                result);
    }
}
