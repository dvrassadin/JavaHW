package homework08;

public class Plate implements Eatable {
    private int food;

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public void setFood(int amount) {
        if (amount > 0)
            food = amount;
    }

    public Plate(int food) {
        this.food = food;
    }
}
