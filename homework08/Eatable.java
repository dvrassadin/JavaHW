package homework08;

public interface Eatable {
    int getFood();

    void setFood(int amount);

    default void reduceFood(int amount) {
        if (getFood() - amount >= 0)
            setFood(getFood() - amount);
    }

    default void addFood(int amount) {
        setFood(getFood() + amount);
    }
}
