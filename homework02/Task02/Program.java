package homework02.Task02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

// Дана строка (получение через обычный текстовый файл!!!)
// "фамилия":"Иванов","оценка":"5","предмет":"Математика"
// "фамилия":"Петрова","оценка":"4","предмет":"Информатика"
// Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида: 
// Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода в консоль:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

public class Program {
    static public final String path = System.getProperty("user.dir").concat("/homework02/Task02/text.txt");

    public static void main(String[] args) throws IOException {
        try {
            File file = new File(path);
            printJournal(loadData(file));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    static String loadData(File file) throws FileNotFoundException {
        StringBuilder result = new StringBuilder();

        Scanner sc = new Scanner(file);
        while (sc.hasNextLine())
            result.append(sc.nextLine() + "\n");
        sc.close();

        return result.toString();
    }

    static void printJournal(String str) {
        for (String line : str.replace("\"", "").split("\n")) {
            var splitLine = line.split(",");
            System.out.printf("Студент %s получил %s по предмету %s.\n",
                    splitLine[0].split(":")[1],
                    splitLine[1].split(":")[1],
                    splitLine[2].split(":")[1]);
        }
    }

}
