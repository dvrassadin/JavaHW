package homework09;

abstract class Employee implements Comparable<Employee> {

    protected String name;
    protected String surname;
    protected double salary;

    public Employee(String name, String surname, double salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s; Среднемесячная заработная плата: %.2f", name, surname, salary);
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(o.calculateSalary(), calculateSalary());
    }
}
