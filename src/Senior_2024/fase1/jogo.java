package Senior_2024.fase1;

import java.util.HashMap;
import java.util.Scanner;

public class jogo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        char[][] cells = new char[n][n];

        for (int i = 0; i < n; i++) {
            String row = sc.next();

            for (int j = 0; j < n; j++) {
                cells[i][j] = row.charAt(j);
            }
        }

        for (int i = 0; i < q; i++) {
            simulate(cells);
        }

        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells.length; col++) {
                System.out.print(cells[row][col]);
            }
            System.out.println();
        }

    }


    public static char [][] simulate(char [][] cells) {
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells.length; col++) {
                int amountNeighborsAlive = getAmountNeighborsAlive(cells, row, col);
                // 1 -> vivo
                // 0 -> morto
                // I -> vai morrer, mas ainda tá vivo
                // O -> vai ficar vivo, mas ainda ta morto
                boolean isAlive = isAlive(cells[row][col]) == 1;

                // vai ressucitar
                if (!isAlive && amountNeighborsAlive == 3) {
                    cells[row][col] = 'I';
                    continue;
                }

                //vai morrer
                if (isAlive && amountNeighborsAlive < 2 || isAlive && amountNeighborsAlive > 3  ) {
                    cells[row][col] = 'O';
                    continue;
                }
            }
        }

        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells.length; col++) {
                if (cells[row][col] == 'O') cells[row][col] = '0';
                if (cells[row][col] == 'I') cells[row][col] = '1';
            }
        }
        return cells;
    }

    public static int getAmountNeighborsAlive(char [][] cells, int row, int col) {


        int amountNeighborsAlive = 0;
        HashMap<Integer, Boolean> thereIsCol = new HashMap<>();
        thereIsCol.put(col, true);
        thereIsCol.put(col - 1, col - 1 >= 0);
        thereIsCol.put(col + 1, col + 1 < cells.length);

        HashMap<Integer, Boolean> thereIsRow = new HashMap<>();
        thereIsRow.put(row, true);
        thereIsRow.put(row - 1, row - 1 >= 0);
        thereIsRow.put(row + 1, row + 1 < cells.length);

        if (thereIsRow.get(row - 1) && thereIsCol.get(col) ) {
            amountNeighborsAlive += isAlive(cells[row-1][col]);
        }
        if (thereIsRow.get(row) && thereIsCol.get(col - 1) ) {
            amountNeighborsAlive += isAlive(cells[row][col - 1]);
        }
        if (thereIsRow.get(row + 1) && thereIsCol.get(col) ) {
            amountNeighborsAlive += isAlive(cells[row+1][col]);
        }
        if (thereIsRow.get(row) && thereIsCol.get(col + 1) ) {
            amountNeighborsAlive += isAlive(cells[row][col + 1]);
        }
        if (thereIsRow.get(row - 1) && thereIsCol.get(col - 1) ) {
            amountNeighborsAlive += isAlive(cells[row-1][col-1]);
        }
        if (thereIsRow.get(row + 1) && thereIsCol.get(col + 1) ) {
            amountNeighborsAlive += isAlive(cells[row + 1][col + 1]);
        }
        if (thereIsRow.get(row - 1) && thereIsCol.get(col + 1) ) {
            amountNeighborsAlive += isAlive(cells[row - 1 ][col + 1]);
        }
        if (thereIsRow.get(row + 1) && thereIsCol.get(col - 1) ) {
            amountNeighborsAlive += isAlive(cells[row + 1][col - 1]);
        }

        return amountNeighborsAlive;
    }

    public static int isAlive (char cell) {
        if (cell == '1' || cell == 'O') return 1;
        return 0;
    }

}
