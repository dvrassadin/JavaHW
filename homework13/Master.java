package homework13;

public class Master extends Student {

    public Master(String name) {
        super(name);
        this.salary = 80000;
    }

    @Override
    public boolean receiveOffer(Vacancy vacancy) {
        if (this.salary < vacancy.getSalary() && this.positions.contains(vacancy.getPosition())) {
            System.out.printf("Мастер %s >>> Мне нужна эта работа! [%s - %s - %.2f]\n",
                    this.name,
                    vacancy.getCompanyName(),
                    vacancy.getPosition().toString(),
                    vacancy.getSalary());
            this.salary = vacancy.getSalary();
            return true;
        } else {
            System.out.printf("Мастер %s >>> Я найду работу получше! [%s - %s - %.2f]\n",
                    this.name,
                    vacancy.getCompanyName(),
                    vacancy.getPosition().toString(),
                    vacancy.getSalary());
            return false;
        }
    }
}
