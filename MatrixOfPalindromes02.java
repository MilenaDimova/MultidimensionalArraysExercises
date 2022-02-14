package MultidimensionalArraysExercises;

import java.util.Scanner;

public class MatrixOfPalindromes02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix) {
        char firstElement = 'a';
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String palindrome = "" + firstElement + (char)(firstElement + col) + firstElement;
                matrix[row][col] = palindrome;
            }
            firstElement++;

        }
    }
}
