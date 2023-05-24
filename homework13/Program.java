package homework13;

public class Program {

    /**
     * TODO: Доработать приложение, поработать с шаблоном проектирования Observer,
     * добавить новый тип соискателя.
     * Добавить новую сущность "Вакансия", компания должна рассылать вакансии.
     * 
     * @param args
     */
    public static void main(String[] args) {
        JobAgency jobAgency = new JobAgency();
        Company geekBrains = new Company("GeekBrains", 80000, jobAgency);
        Company google = new Company("Google", 110000, jobAgency);
        Company yandex = new Company("Yandex", 150000, jobAgency);

        // Добавление позиций, которые нужны компаниям
        geekBrains.addPositions(Position.CLEANER, Position.DRIVER, Position.SECRETARY);
        google.addPositions(Position.DEVELOPER, Position.LAWYER, Position.TESTER, Position.DESIGNER);
        yandex.addPositions(Position.DRIVER, Position.DEVELOPER, Position.DEVELOPER);

        Student petrov = new Student("Petrov");
        Student kulikov = new Student("Kulikov");
        Master ivanov = new Master("Ivanov");
        Master sidorov = new Master("Sidorov");
        Master kushkov = new Master("Kushkov");
        GrandMaster pupkin = new GrandMaster("Pupkin");
        GrandMaster shnurkov = new GrandMaster("Shnurkov");

        // Добавление должностей, которые ищут соискатели
        petrov.addPositions(Position.CLEANER, Position.DEVELOPER, Position.DRIVER,
                Position.SECRETARY);
        kulikov.addPositions(Position.DEVELOPER, Position.TESTER, Position.DESIGNER);
        ivanov.addPositions(Position.DEVELOPER, Position.TESTER, Position.DRIVER);
        sidorov.addPositions(Position.DESIGNER, Position.DRIVER);
        kushkov.addPositions(Position.LAWYER, Position.DRIVER);
        pupkin.addPositions(Position.LAWYER, Position.DESIGNER);
        shnurkov.addPositions(Position.DESIGNER, Position.DEVELOPER);

        jobAgency.registerObserver(ivanov);
        jobAgency.registerObserver(sidorov);
        jobAgency.registerObserver(petrov);
        jobAgency.registerObserver(pupkin);
        jobAgency.registerObserver(shnurkov);

        for (int i = 0; i < 10; i++) {
            geekBrains.needEmployee();
            google.needEmployee();
            yandex.needEmployee();
        }

    }
}
