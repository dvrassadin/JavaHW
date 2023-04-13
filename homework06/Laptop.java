package homework06;

public class Laptop {
    private String name;
    private int memory;
    private int storage;
    private String os;
    private String color;

    public Laptop(String name, int memory, int storage, String os, String color) {
        this.name = name;
        this.memory = memory;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public String getName() {
        return this.name;
    }

    public int getStorage() {
        return this.storage;
    }

    public String getOS() {
        return this.os;
    }

    public String getColor() {
        return this.color;
    }

    public int getMemory() {
        return this.memory;
    }

    @Override
    public String toString() {
        return String.format("%s, %d GB memory, %d GB storage, %s, %s color",
                name, memory, storage, os, color);
    }
}
