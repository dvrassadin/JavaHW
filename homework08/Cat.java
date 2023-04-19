package homework08;

public class Cat implements Feedable {
    private String name;
    private int appetite;
    private boolean isFull = false;

    public String getName() {
        return name;
    }

    @Override
    public int getAppetite() {
        return appetite;
    }

    @Override
    public boolean getFull() {
        return isFull;
    }

    @Override
    public void setFull(boolean isFull) {
        this.isFull = isFull;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }
}
