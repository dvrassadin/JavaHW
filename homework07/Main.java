package homework07;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        BottleOfWater bottleOfWater1 = new BottleOfWater("Вода", 100, 2);
        BottleOfWater bottleOfWater2 = new BottleOfWater("Вода1", 100, 2);
        BottleOfWater bottleOfWater3 = new BottleOfWater("Вода2", 110, 1);
        BottleOfWater bottleOfWater4 = new BottleOfWater("Вода3", 130, 3);
        BottleOfWater bottleOfWater5 = new BottleOfWater("Вода4", 100, 1);
        Sweet sweet1 = new Sweet("Sula", 65);
        Sweet sweet2 = new Sweet("Snickers", 70, 100);
        Sweet sweet3 = new Sweet("Mars", 65, 120);

        Product bottleOfMilk1 = new BottleOfMilk("Молоко", 100, 2, 10);

        List<Product> products = new ArrayList<>();
        products.add(bottleOfWater1);
        products.add(bottleOfWater2);
        products.add(bottleOfMilk1);
        products.add(bottleOfWater3);
        products.add(bottleOfWater4);
        products.add(bottleOfWater5);
        products.add(sweet1);
        products.add(sweet2);
        products.add(sweet3);

        VendingMachine machine = new VendingMachine(products);

        BottleOfWater bottleOfWaterRes = machine.getBottleOfWater("Вода3", 3);
        if (bottleOfWaterRes != null) {
            System.out.println("Вы купили: ");
            System.out.println(bottleOfWaterRes.displayInfo());
        } else {
            System.out.println("Такой бутылки с водой нет в автомате.");
        }

        BottleOfMilk bottleOfMilkRes = machine.getBottleOfMilk("Молоко", 2, 10);
        if (bottleOfMilkRes != null)
            System.out.printf("Вы купили: %s\n", bottleOfMilkRes.displayInfo());
        else
            System.out.println("Такого молока нет.");

        Sweet sweetRes = machine.getSweet("Sula", 0);
        if (sweetRes != null)
            System.out.printf("Вы купили: %s\n", sweetRes.displayInfo());
        else
            System.out.println("Такой сладости нет.");

        System.out.println("Remains:");
        for (Product product : products)
            System.out.println(product.displayInfo());

    }

}