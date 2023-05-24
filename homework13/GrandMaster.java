package homework13;

public class GrandMaster extends Master {

    public GrandMaster(String name) {
        super(name);
        this.salary = 110000;
    }

    @Override
    public boolean receiveOffer(Vacancy vacancy) {
        if (this.salary < vacancy.getSalary() && this.positions.contains(vacancy.getPosition())) {
            System.out.printf("Грандмастер %s >>> Мне нужна эта работа! [%s - %s - %.2f]\n",
                    this.name,
                    vacancy.getCompanyName(),
                    vacancy.getPosition().toString(),
                    vacancy.getSalary());
            this.salary = vacancy.getSalary();
            return true;
        } else {
            System.out.printf("Грандмастер %s >>> Я найду работу получше! [%s - %s - %.2f]\n",
                    this.name,
                    vacancy.getCompanyName(),
                    vacancy.getPosition().toString(),
                    vacancy.getSalary());
            return false;
        }
    }

}
