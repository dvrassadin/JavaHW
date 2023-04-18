package homework08;

public class Main {
    public static void main(String[] args) {
        Feedable[] animals = {
                new Cat("Barsik", 5),
                new Cat("Musya", 7),
                new Cat("Pusya", 3),
                new Cat("Ryzhik", 10),
                new Cat("Pyzhik", 5),
                new Cat("Kusya", 5),
                new Cat("Sonya", 4),
                new Cat("Monya", 9),
                new Cat("Zhuzha", 2),
                new Cat("Ugolyok", 8),
                new Cat("Dusya", 2),
                new Cat("Fyodor", 11)
        };
        Eatable plate = new Plate(0);
        plate.addFood(45);
        System.out.printf("plate: %d\n", plate.getFood());

        for (Feedable animal : animals) {
            animal.eatFrom(plate);
            if (animal instanceof Cat)
                System.out.printf("%s is %s.\n", ((Cat) animal).getName(), animal.getFull() ? "full" : "hungry");
            System.out.printf("plate: %d\n", plate.getFood());
        }

    }
}
