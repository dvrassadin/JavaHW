package homework04;

import java.util.Arrays;
import java.util.LinkedList;

// Пусть дан LinkedList с несколькими элементами. Реализуйте метод(не void), который вернет “перевернутый” список.

public class FirstTask {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        var reverseList = reversLinkedList(list);
        System.out.println(list);
        System.out.println(reverseList);
    }

    static LinkedList<Integer> reversLinkedList(LinkedList<Integer> list) {
        LinkedList<Integer> result = new LinkedList<>();
        System.out.println("test");
        for (int i = list.size() - 1; i >= 0; i--)
            result.add(list.get(i));
        return result;
    }
}
