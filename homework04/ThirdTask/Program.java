package homework04.ThirdTask;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// В калькулятор добавьте возможность отменить последнюю операцию.
// Пример

// 1
// +
// 2
// ответ:
// 3

// +
// 4
// ответ:
// 7
// +
// 2

// ответ:
// 9
// -
// 1
// Ответ 8
// Отмена -> 9
// Отмена -> 7
// Отмена -> 3
// +
// 2
// Ответ 5

public class Program {
    static final Logger logger = Logger.getLogger(Program.class.getName());
    static Deque<Double> results = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        try {
            FileHandler fh = new FileHandler("homework04/ThirdTask/log.txt", true);
            logger.addHandler(fh);

            SimpleFormatter sf = new SimpleFormatter();
            fh.setFormatter(sf);

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter the first number: ");
            results.add(sc.nextDouble());

            while (true) {
                if (results.size() > 1)
                    System.out.printf("The result is %f.\n", results.getLast());

                System.out.print("Enter the operation, \"cancel\" or \"stop\": ");
                String operation = sc.next();

                if (operation.equals("cancel"))
                    results.removeLast();
                else if (operation.equals("stop"))
                    break;
                else {
                    System.out.print("Enter the second number: ");
                    double secondNumber = sc.nextDouble();

                    Double result = null;
                    switch (operation) {
                        case "+":
                            result = results.getLast() + secondNumber;
                            break;
                        case "-":
                            result = results.getLast() - secondNumber;
                            break;
                        case "*":
                            result = results.getLast() * secondNumber;
                            break;
                        case "/":
                            result = results.getLast() / secondNumber;
                            break;
                    }

                    String stringResult = String.format("%f %s %f = %f",
                            results.getLast(),
                            operation,
                            secondNumber,
                            result);

                    logger.log(Level.INFO, stringResult);
                    results.add(result);
                }
            }

            sc.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
