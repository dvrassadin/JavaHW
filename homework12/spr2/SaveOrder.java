package homework12.spr2;

import java.io.FileWriter;
import java.io.IOException;

public class SaveOrder {
    static public void toJson(Order order, String fileName) {
        try (FileWriter writer = new FileWriter(fileName + ".json", false)) {
            writer.write("{\n");
            writer.write("\"clientName\":\"" + order.getClientName() + "\",\n");
            writer.write("\"product\":\"" + order.getProduct() + "\",\n");
            writer.write("\"qnt\":" + order.getQnt() + ",\n");
            writer.write("\"price\":" + order.getPrice() + "\n");
            writer.write("}\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static public void toJson(Order order) {
        toJson(order, "order");
    }

    static public void toXML(Order order, String fileName) {
        try (FileWriter writer = new FileWriter(fileName + ".xml", false)) {
            writer.write("<Order>\n");
            writer.write("<clientName>" + order.getClientName() + "</clientName>\n");
            writer.write("<product>" + order.getProduct() + "</product>\n");
            writer.write("<qnt>" + order.getQnt() + "</qnt>\n");
            writer.write("<price>" + order.getPrice() + "</price>\n");
            writer.write("</Order>");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static public void toXML(Order order) {
        toXML(order, "order");
    }
}
