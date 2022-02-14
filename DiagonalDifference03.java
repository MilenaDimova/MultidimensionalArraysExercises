package MultidimensionalArraysExercises;

import java.util.Scanner;

public class DiagonalDifference03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        fillMatrix(matrix, scanner);

        int sumPrimary = getPrimaryDiagonalSum(matrix);
        int sumSecondary = getSecondaryDiagonalSum(matrix);

        System.out.println(Math.abs(sumPrimary - sumSecondary));

    }

    private static int getSecondaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int currentElement = matrix[row][col];
                if (col == matrix.length - row - 1) {
                    sum += currentElement;
                }
            }
        }
        return sum;
    }

    private static int getPrimaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int currentElement = matrix[row][col];
                if (row == col) {
                    sum += currentElement;
                }
            }
        }
        return sum;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}
