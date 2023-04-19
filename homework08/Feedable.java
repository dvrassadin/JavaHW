package homework08;

public interface Feedable {
    int getAppetite();

    boolean getFull();

    void setFull(boolean isFull);

    default void eatFrom(Eatable dish) {
        if (dish.getFood() >= getAppetite() && !getFull()) {
            setFull(true);
            dish.reduceFood(getAppetite());
        }
    }
}
