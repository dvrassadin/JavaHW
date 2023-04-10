package homework05;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И вывести Доску. Пример вывода доски 8x8
// 0x000000
// 0000x000
// 00x00000

public class ThirdTask {
    public static int size = 8;
    static boolean[][] chessBoard = new boolean[size][size];

    public static void main(String[] args) {
        arrangeQueens();
        printChessBoard();
    }

    static void arrangeQueens() {
        boolean isSolved = false;
        while (!isSolved) {
            chessBoard = new boolean[size][size];
            boolean[][] exceptions = new boolean[size][size];
            Random random = new Random();
            byte queens = 0;

            for (byte i = 0; i < exceptions[0].length; i++) {
                Set<Integer> cells = new HashSet<>();
                while (cells.size() < exceptions[0].length) {
                    int cell = random.nextInt(exceptions[0].length);
                    if (!exceptions[i][cell]) {
                        chessBoard[i][cell] = true;
                        queens++;
                        for (byte j = 0; j < chessBoard.length; j++) {
                            exceptions[i][j] = true;
                            exceptions[j][cell] = true;
                        }
                        for (int k = 1; k < chessBoard.length - i && k <= cell; k++) {
                            exceptions[i + k][cell - k] = true;
                        }
                        for (int l = 1; l < chessBoard.length - i && l < chessBoard.length - cell; l++) {
                            exceptions[i + l][cell + l] = true;
                        }
                        break;
                    } else
                        cells.add(cell);
                }
            }
            if (queens == chessBoard.length)
                isSolved = true;
        }
    }

    static void printChessBoard() {
        System.out.println("Queens are ⬛️:");

        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                if (chessBoard[i][j])
                    System.out.print("⬛️");
                else
                    System.out.print("⬜️");
            }
            System.out.println();
        }
    }
}
