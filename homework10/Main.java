package homework10;

public class Main {
    public static void main(String[] args) {
        // Создаём коробки
        FruitBox<Apple> appleBox1 = new FruitBox<>();
        FruitBox<Apple> appleBox2 = new FruitBox<>();
        FruitBox<Orange> orangeBox1 = new FruitBox<>();
        FruitBox<Orange> orangeBox2 = new FruitBox<>();

        // Заполняем коробки фруктами
        for (int i = 0; i < 30; i++)
            appleBox1.addFruit(new Apple());
        for (int i = 0; i < 7; i++)
            appleBox2.addFruit(new Apple());
        for (int i = 0; i < 20; i++)
            orangeBox1.addFruit(new Orange());

        // Смотрим вес коробок
        System.out.println("Вес коробок после заполнения: ");
        System.out.println(appleBox1.getWeight());
        System.out.println(appleBox2.getWeight());
        System.out.println(orangeBox1.getWeight());
        System.out.println(orangeBox2.getWeight());

        // Сравниваем вес
        System.out.println("Сравнение веса:");
        System.out.printf("Коробки равны по весу: %s.\n", appleBox1.compareWeight(orangeBox1));
        System.out.printf("Коробки равны по весу: %s.\n", appleBox1.compareWeight(appleBox2));

        // Убираем фрукт из коробки апельсинов
        orangeBox1.removeFruit();
        System.out.printf("Коробка апельсинов теперь весит %.2f.\n", orangeBox1.getWeight());

        // Пересыпем яблоки из второй коробки в первую
        appleBox2.putAllFruitIn(appleBox1);
        System.out.printf("Первая коробка теперь весит: %.2f, а вторая %.2f.\n", appleBox1.getWeight(),
                appleBox2.getWeight());

    }
}
