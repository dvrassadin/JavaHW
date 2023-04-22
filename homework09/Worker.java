package homework09;

class Worker extends Employee {

    public Worker(String name, String surname, double salary) {
        super(name, surname, salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format(
                "%s %s (рабочий), зарплата: %.2f ₽.", name, surname, calculateSalary());
    }
}
