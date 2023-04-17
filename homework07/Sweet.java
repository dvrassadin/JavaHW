package homework07;

public class Sweet extends Product {
    private int calories;

    public int getCalories() {
        return this.calories;
    }

    public Sweet(String brand, String name, double price, int calories) {
        super(brand, name, price);
        this.calories = calories;
    }

    public Sweet(String name, double price, int calories) {
        super(name, price);
        this.calories = calories;
    }

    public Sweet(String name, double price) {
        this(name, price, 0);
    }

    @Override
    String displayInfo() {
        return String.format("%s - %s - %.2f - калории: %d", brand, name, price, calories);
    }
}
