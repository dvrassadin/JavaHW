package homework02.Task03;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.IOException;
import java.util.Scanner;

// *дополнительно. К калькулятору из предыдущего дз добавить логирование.
// 1 + 3 = 4
// 4 + 3 = 7

public class Program {
    public static final Logger logger = Logger.getLogger(Program.class.getName());

    public static void main(String[] args) throws IOException {
        try {
            FileHandler fh = new FileHandler("homework02/Task03/log.txt", true);
            logger.addHandler(fh);

            SimpleFormatter sf = new SimpleFormatter();
            fh.setFormatter(sf);

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

            String stringResult = String.format("%f %s %f = %f",
                    firstNumber,
                    operation,
                    secondNumber,
                    result);

            logger.log(Level.INFO, stringResult);
            System.out.println(stringResult);

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }
}
