package MultidimensionalArraysExercises;

import java.util.Scanner;

public class MatrixShuffling05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dimensions = scanner.nextLine();
        int rows = Integer.parseInt(dimensions.split("\\s+")[0]);
        int cols = Integer.parseInt(dimensions.split("\\s+")[1]);

        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix, scanner);

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            //1. first case -> invalid command
            if (!validateCommand(command, rows, cols)) {
                System.out.println("Invalid input!");
            } //2. second case -> valid command
            else {
                String[] commandParts = command.split("\\s+");
                int row1 = Integer.parseInt(commandParts[1]);
                int col1 = Integer.parseInt(commandParts[2]);
                int row2 = Integer.parseInt(commandParts[3]);
                int col2 = Integer.parseInt(commandParts[4]);

                String firstElement = matrix[row1][col1];
                String secondElement = matrix[row2][col2];

                matrix[row1][col1] = secondElement;
                matrix[row2][col2] = firstElement;

                printMatrix(matrix);

            }

            command = scanner.nextLine();
        }

    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = (scanner.nextLine().split("\\s+"));
        }
    }

    private static boolean validateCommand(String command, int rows, int cols) {
        //true -> if command is valid
        //false -> if command is not valid

        String[] commandParts = command.split("\\s+");
        //1. commandParts.length == 5;
        if (commandParts.length != 5) {
            return false;
        }

        //2. commandParts starts with -> "swap"
        if (!commandParts[0].equals("swap")) {
            return false;
        }

        //3. are rows and cols are valid?
        int row1 = Integer.parseInt(commandParts[1]);
        int col1 = Integer.parseInt(commandParts[2]);
        int row2 = Integer.parseInt(commandParts[3]);
        int col2 = Integer.parseInt(commandParts[4]);

        if (row1 < 0 || row1 >= rows || row2 < 0 || row2 >= rows
                || col1 < 0 || col1 >= cols || col2 < 0 || col2 >= cols) {
            return false;
        }

        return true;
    }
}
