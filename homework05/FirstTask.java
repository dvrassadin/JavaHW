package homework05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Добавить функции 1) Добавление номера
// 2) Вывод всего 
// Пример:
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 1242353
// К: Введите 1) Добавление номера
// 2) Вывод всего 
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 547568
// К: Введите 1) Добавление номера
// 2) Вывод всего 
// Я: 2
// Иванов: 1242353, 547568

public class FirstTask {
    static Map<String, ArrayList<String>> contacts = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the action:\n1 — Add number;\n2 — Print numbers;\n0 — Stop.\n>>> ");
            String action = sc.next();
            if (action.equals("0")) {
                System.out.println("Goodbye.");
                break;
            } else if (action.equals("1")) {
                System.out.println("Enter the last name: ");
                String lastName = sc.next();
                System.out.println("Enter the number: ");
                String number = sc.next();
                addNumber(lastName, number);
            } else if (action.equals("2")) {
                System.out.println("Enter the last name: ");
                String lastName = sc.next();
                printContact(lastName);
            } else {
                System.out.println("The action is incorrect.");
            }
            System.out.println();
        }

        sc.close();
    }

    static void addNumber(String lastName, String number) {
        if (contacts.containsKey(lastName)) {
            System.out.println("Add number");
            contacts.get(lastName).add(number);
        } else {
            System.out.println("Add new.");
            ArrayList<String> newNumber = new ArrayList<>(Arrays.asList(number));
            contacts.put(lastName, newNumber);
        }
    }

    static void printContact(String lastName) {
        if (contacts.containsKey(lastName)) {
            for (var kv : contacts.entrySet())
                if (kv.getKey().equals(lastName))
                    for (String number : kv.getValue())
                        System.out.println(number);
        } else
            System.out.println("There is no such last name.");
    }
}
