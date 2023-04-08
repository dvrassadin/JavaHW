package homework05;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Пусть дан список сотрудников:
// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
// Отсортировать по убыванию популярности Имени.

public class SecondTask {
    static String[] employees = { "Иван Иванов",
            "Светлана Петрова",
            "Кристина Белова",
            "Анна Мусина",
            "Анна Крутова",
            "Иван Юрин",
            "Петр Лыков",
            "Павел Чернов",
            "Петр Чернышов",
            "Мария Федорова",
            "Марина Светлова",
            "Мария Савина",
            "Мария Рыкова",
            "Марина Лугова",
            "Анна Владимирова",
            "Иван Мечников",
            "Петр Петин",
            "Иван Ежов" };

    public static void main(String[] args) {
        Map<String, Integer> names = new HashMap<>();

        // Заполнение словаря именами и количеством
        for (String fullName : employees) {
            String name = fullName.split(" ")[0];

            if (names.containsKey(name))
                names.put(name, names.get(name) + 1);
            else
                names.put(name, 1);
        }

        // Создание сортированного в обратном порядке массива количества имён
        Integer[] sortedValues = names.values().toArray(new Integer[names.size()]);
        Arrays.sort(sortedValues, Collections.reverseOrder());

        // Проход по массиву с количествами имён
        for (int i = 0; i < sortedValues.length; i++) {
            // Создание итератора с оставшимися в словаре именами
            Iterator<String> iterator = names.keySet().iterator();
            // Сравнение имени с количеством, печать и удаление имени из словаря.
            while (iterator.hasNext()) {
                String name = iterator.next();
                if (names.get(name) == sortedValues[i]) {
                    System.out.println(name + " — " + sortedValues[i]);
                    names.remove(name);
                    break;
                }
            }
        }
    }
}
