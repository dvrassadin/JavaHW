package homework07;

import java.util.List;

public class VendingMachine {

    private final List<Product> products;

    public VendingMachine(List<Product> products) {
        this.products = products;
    }

    public BottleOfWater getBottleOfWater(String name, int volume) {

        for (Product product : products) {
            if (product instanceof BottleOfWater) {
                if (product.getName() == name && ((BottleOfWater) product).getVolume() == volume) {
                    return (BottleOfWater) product;
                }
            }
        }
        return null;
    }

    // TODO: Разработать метод получения бутылки с молоком самостоятельно

    public BottleOfMilk getBottleOfMilk(String name, int volume, int fat) {
        for (int i = 0; i < this.products.size(); i++) {
            if (products.get(i) instanceof BottleOfMilk)
                if (products.get(i).getName() == name
                        && ((BottleOfMilk) products.get(i)).getVolume() == volume
                        && ((BottleOfMilk) products.get(i)).getFat() == fat)
                    return (BottleOfMilk) products.remove(i);

        }
        return null;
    }

    public Sweet getSweet(String name, int calories) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) instanceof Sweet)
                if (products.get(i).getName() == name
                        && ((Sweet) products.get(i)).getCalories() == calories)
                    return (Sweet) products.remove(i);
        }
        return null;
    }

}
