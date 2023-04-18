package homework06;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру.
// NoteBook notebook1 = new NoteBook
// NoteBook notebook2 = new NoteBook
// NoteBook notebook3 = new NoteBook
// NoteBook notebook4 = new NoteBook
// NoteBook notebook5 = new NoteBook
// Например: “Введите цифру, соответствующую необходимому критерию: 
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет
// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
// Класс сделать в отдельном файле
// приветствие 
// Выбор параметра
// выбор конкретнее
// вывод подходящих

public class Main {
    public static void main(String[] args) throws IOException {
        Set<Laptop> laptops = new HashSet<>();

        laptops.add(new Laptop("Apple MacBook Air", 16, 512, "MacOS", "grey"));
        laptops.add(new Laptop("Apple MacBook Pro", 32, 512, "MacOS", "silver"));
        laptops.add(new Laptop("Lenovo ThinkPad", 16, 256, "Windows", "black"));
        laptops.add(new Laptop("Lenovo ThinkPad", 32, 512, "Linux", "black"));
        laptops.add(new Laptop("Asus TUF Gaming", 64, 1024, "Windows", "black"));
        laptops.add(new Laptop("Xiaomi RedmiBook 15", 8, 256, "Windows", "black"));
        laptops.add(new Laptop("Huawei MateBook D", 16, 512, "Windows", "grey"));
        laptops.add(new Laptop("Honor MagicBook 16", 16, 512, "Windows", "grey"));
        laptops.add(new Laptop("Acer A315", 8, 256, "Linux", "black"));

        Scanner sc = new Scanner(System.in);
        String action = "";
        while (true) {
            System.out.print(
                    "Enter the filtering parameter: \n1 — memory;\n2 — storage;\n3 — OS;\n4 — color;\n0 — exit.\n>>> ");
            action = sc.nextLine();

            if (action.equals("1")) {
                System.out.print("Enter the minimum amount of memory: ");
                String memory = sc.nextLine();
                for (Laptop laptop : laptops)
                    if (laptop.getMemory() >= Integer.parseInt(memory))
                        System.out.println(laptop);

            } else if (action.equals("2")) {
                System.out.println("Enter the minimum amount of storage: ");
                String storage = sc.nextLine();
                for (Laptop laptop : laptops)
                    if (laptop.getStorage() >= Integer.parseInt(storage))
                        System.out.println(laptop);

            } else if (action.equals("3")) {
                System.out.println("Enter the operation system you want to find: ");
                String os = sc.nextLine();
                for (Laptop laptop : laptops)
                    if (laptop.getOS().equals(os))
                        System.out.println(laptop);

            } else if (action.equals("4")) {
                System.out.println("Enter the color you want to find: ");
                String color = sc.nextLine();
                for (Laptop laptop : laptops)
                    if (laptop.getColor().equals(color))
                        System.out.println(laptop);

            } else if (action.equals("0")) {
                System.out.println("Goodbye.");
                break;

            } else {
                System.out.println("This is incorrect number.");
            }
            System.out.println();
        }
        sc.close();
    }
}
