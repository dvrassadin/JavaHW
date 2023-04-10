package homework05;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И вывести Доску. Пример вывода доски 8x8
// 0x000000
// 0000x000
// 00x00000

public class ThirdTask {
    // Можно указать другой размер
    public static byte size = 8;
    static boolean[][] chessBoard = new boolean[size][size];

    public static void main(String[] args) {
        arrangeQueens();
        printChessBoard();
    }

    static void arrangeQueens() {
        if (size < 4)
            return;
        boolean isSolved = false;
        while (!isSolved) {
            chessBoard = new boolean[size][size];
            // Создание доски для добавления исключений
            boolean[][] exceptions = new boolean[size][size];
            Random random = new Random();
            // Переменная для подсчёта поставленных на доску ферзей
            byte queens = 0;

            // Попытка добавления ферзя в каждый ряд пока не получится добавить восемь штук
            for (byte i = 0; i < size; i++) {
                // Множество для добавления индекса ячейки куда не получилось поставить ферзя
                Set<Integer> cells = new HashSet<>();
                while (cells.size() < size) {
                    int cell = random.nextInt(size);
                    // Если получилось добавить ферзя, то доске с исключениями отмечаются ячейки
                    // куда нельзя будет поставить следующих и увеличивается счётчик ферзей
                    if (!exceptions[i][cell]) {
                        chessBoard[i][cell] = true;
                        queens++;
                        // Исключения по вертикали
                        for (byte j = i; j < size; j++) {
                            exceptions[j][cell] = true;
                        }
                        // Исключения по диагонали вправо
                        for (byte k = 1; k < size - i && k <= cell; k++) {
                            exceptions[i + k][cell - k] = true;
                        }
                        // Исключения по диагонали влево
                        for (byte l = 1; l < size - i && l < size - cell; l++) {
                            exceptions[i + l][cell + l] = true;
                        }
                        break;
                    } else
                        cells.add(cell);
                }
            }
            if (queens == size)
                isSolved = true;
        }
    }

    static void printChessBoard() {
        System.out.println("Queens are ⬛️:");

        for (byte i = 0; i < size; i++) {
            for (byte j = 0; j < size; j++) {
                if (chessBoard[i][j])
                    System.out.print("⬛️");
                else
                    System.out.print("⬜️");
            }
            System.out.println();
        }
    }
}
