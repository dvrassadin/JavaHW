package homework09;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {

    private static Random random = new Random();

    static Employee generateEmployee() {
        String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий",
                "Рубен", "Герман", "Алексей", "Владимир", "Алишер" };
        String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов",
                "Горбунов", "Лыткин", "Соколов", "Иванов", "Пупкин", "Пыжиков", "Рыжиков", "Моисеенко" };

        if (random.nextBoolean()) {
            return new Worker(names[random.nextInt(names.length)], surnames[random.nextInt(surnames.length)],
                    random.nextInt(15000, 180000));
        } else {
            return new Freelancer(names[random.nextInt(names.length)], surnames[random.nextInt(surnames.length)],
                    random.nextInt(250, 1500));
        }
    }

    public static void main(String[] args) {

        Employee[] employees = new Employee[15];

        for (int i = 0; i < employees.length; i++)
            employees[i] = generateEmployee();

        for (Employee employee : employees)
            System.out.println(employee);

        Arrays.sort(employees);

        System.out.printf("\n*** Отсортированный по доходу массив сотрудников ***\n\n");

        for (Employee employee : employees)
            System.out.println(employee);

        System.out.printf("\n*** Отсортированный по имени, а потом по фамилии массив сотрудников ***\n\n");

        Arrays.sort(employees, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                int firstCompare = o1.name.compareTo(o2.name);
                if (firstCompare == 0)
                    return o1.surname.compareTo(o2.surname);
                return firstCompare;
            };
        });

        for (Employee employee : employees)
            System.out.println(employee);
    }
}
