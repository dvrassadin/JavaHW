package homework13;

enum Position {
    LAWYER, CLEANER, DEVELOPER, SECRETARY, DRIVER, TESTER, DESIGNER
}

public class Vacancy {
    private String companyName;
    private float salary;
    private Position position;

    public Vacancy(String companyName, float salary, Position position) {
        this.companyName = companyName;
        this.salary = salary;
        this.position = position;
    }

    public String getCompanyName() {
        return companyName;
    }

    public float getSalary() {
        return salary;
    }

    public Position getPosition() {
        return position;
    }

}
