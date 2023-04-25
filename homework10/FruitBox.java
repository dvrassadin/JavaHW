package homework10;

import java.util.HashSet;

public class FruitBox<T extends Fruit> {

    private final HashSet<T> box = new HashSet<>();

    /**
     * 
     * @return вес фруктов в коробке
     */
    public float getWeight() {
        return this.box.isEmpty() ? 0f : this.box.size() * this.box.iterator().next().getWeight();
    }

    /**
     * Добавляет в коробку фрукт.
     * 
     * @param fruit фрукт типа коробки
     */
    public void addFruit(T fruit) {
        this.box.add(fruit);
    }

    /**
     * Убирает случайный фрукт из коробки.
     * 
     * @return убранный фрукт или {@code null} если коробка пуста
     */
    public T removeFruit() {
        if (!this.box.isEmpty()) {
            T firstOne = this.box.iterator().next();
            this.box.remove(firstOne);
            return firstOne;
        } else
            return null;
    }

    /**
     * 
     * @param box любая {@code FruitBox}
     * @return {@code true} если у коробок одинаковый вес
     */
    public boolean compareWeight(FruitBox<?> anotherBox) {
        return anotherBox.getWeight() == this.getWeight() ? true : false;
    }

    /**
     * Пересыпает все фрукты из текущей коробки в другую коробку.
     * 
     * @param anotherBox коробка для пересыпания такого же типа
     */
    public void putAllFruitIn(FruitBox<T> anotherBox) {
        while (!this.box.isEmpty())
            anotherBox.addFruit(this.removeFruit());
    }

}
