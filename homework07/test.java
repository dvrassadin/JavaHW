package homework07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            if (itr.next() == 2) {
                itr.remove();
            }
        }
        System.out.println(list);
    }
}
