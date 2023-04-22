package homework09;

/**
 * TODO: 1. Доработать самостоятельно в рамках домашней работы
 */
class Freelancer extends Employee {

    public Freelancer(String name, String surname, double salary) {
        super(name, surname, salary);
    }

    @Override
    public double calculateSalary() {
        return 20 * 5 * salary;
    }

    @Override
    public String toString() {
        return String.format(
                "%s %s (подрядчик), вознаграждение: %.2f ₽.", name, surname, calculateSalary());
    }
}
