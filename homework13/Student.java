package homework13;

import java.util.HashSet;

public class Student implements Observer {

    protected String name;
    protected double salary;
    protected HashSet<Position> positions;

    public Student(String name) {
        this.name = name;
        this.salary = 25000;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean receiveOffer(Vacancy vacancy) {
        if (this.salary < vacancy.getSalary() && this.positions.contains(vacancy.getPosition())) {
            System.out.printf("Студент %s >>> Мне нужна эта работа! [%s - %s - %.2f]\n",
                    this.name,
                    vacancy.getCompanyName(),
                    vacancy.getPosition().toString(),
                    vacancy.getSalary());
            this.salary = vacancy.getSalary();
            return true;
        } else {
            System.out.printf("Студент %s >>> Я найду работу получше! [%s - %s - %.2f]\n",
                    this.name,
                    vacancy.getCompanyName(),
                    vacancy.getPosition().toString(),
                    vacancy.getSalary());
            return false;
        }
    }

    @Override
    public void addPositions(Position... positions) {
        if (this.positions == null)
            this.positions = new HashSet<>();
        for (Position position : positions)
            this.positions.add(position);
    }

    @Override
    public HashSet<Position> getPositions() {
        return this.positions;
    }
}
