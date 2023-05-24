package homework13;

import java.util.HashSet;
import java.util.Random;

public class Company {

    private Random random;
    private String nameCompany;
    private double maxSalary;
    private Publisher jobAgency;
    private HashSet<Position> positions;

    public Company(String nameCompany, double maxSalary, Publisher jobAgency) {
        this.nameCompany = nameCompany;
        this.maxSalary = maxSalary;
        this.jobAgency = jobAgency;
        random = new Random();
    }

    public void addPositions(Position... positions) {
        if (this.positions == null)
            this.positions = new HashSet<>();
        for (Position position : positions)
            this.positions.add(position);
    }

    public void removePosition(Position position) {
        this.positions.remove(position);
    }

    /**
     * TODO: Доработать метод, компания должна генерировать объект "Вакансия" и
     * передавать
     * объект в агенство.
     * Поиск сотрудника
     */
    public void needEmployee() {
        for (Position position : positions) {
            switch (position) {
                case CLEANER, DRIVER:
                    jobAgency.sendOffer(new Vacancy(
                            this.nameCompany,
                            random.nextFloat(20000, (float) maxSalary / 2),
                            position));
                    break;
                default:
                    jobAgency.sendOffer(new Vacancy(
                            this.nameCompany,
                            random.nextFloat(20000, (float) maxSalary),
                            position));
                    break;
            }
        }
    }

}
