package homework13;

import java.util.HashSet;

public class JobAgency implements Publisher {

    HashSet<Observer> observers = new HashSet<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Реализация рассылки сообщений
     * Сначала проходит по всем соискателям и выбирает тех, кто готов работать на
     * такой позиции за такие деньги.
     * Из тех, кто готов, выбирает соискателя с лучшей квалификаций и удаляет его из
     * списка соискателей.
     */
    @Override
    public void sendOffer(Vacancy vacancy) {
        HashSet<Observer> accepted = new HashSet<>();
        for (Observer observer : this.observers) {
            if (observer.getPositions().contains(vacancy.getPosition()) && observer.receiveOffer(vacancy)) {
                accepted.add(observer);
            }
        }

        for (Observer accepter : accepted)
            if (accepter instanceof GrandMaster) {
                System.out.printf("Эту работу получает грандмастер %s.\n", ((GrandMaster) accepter).getName());
                this.observers.remove(accepter);
                return;
            }

        for (Observer accepter : accepted)
            if (accepter instanceof Master) {
                System.out.printf("Эту работу получает мастер %s.\n", ((Master) accepter).getName());
                this.observers.remove(accepter);
                return;
            }

        for (Observer accepter : accepted)
            if (accepter instanceof Student) {
                System.out.printf("Эту работу получает студент %s.\n", ((Student) accepter).getName());
                this.observers.remove(accepter);
                return;
            }
    }
}
