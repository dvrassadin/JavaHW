import java.util.Scanner;

// Вычислить n-ое треугольного число(сумма чисел от 1 до n), а так же n! (произведение чисел от 1 до n)
// Ввод:5
// Треугольное число 1 + 2 + 3 + 4 + 5 = 15
// n! 1 * 2 * 3 * 4 * 5 = 120

public class FirstTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = sc.nextInt();
        sc.close();

        System.out.printf("Triangular number is %d.\n", triangularNumber(number));
        System.out.printf("Factorial is %d.\n", factorial(number));
    }

    static int triangularNumber(int number) {
        int result = 0;
        for (int i = 1; i <= number; i++) result += i;
        return result;
    }

    static int factorial(int number) {
        if (number == 0 || number == 1) return 1;
        int result = 1;
            
        for (int i = 2; i <= number; i++) result *= i;
        return result;
            
    }
}
 
