package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine().split("\\s+")[0]);

        int[][] matrix = readMatrix(rows, scanner, "\\s+");

        int maxSum = 0;
        int[][] matrixMaxSum = new int[3][3];

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int firstRow1 = matrix[row][col];
                int secondRow1 = matrix[row][col + 1];
                int thirdRow1 = matrix[row][col + 2];
                int firstRow2 = matrix[row + 1][col];
                int secondRow2 = matrix[row + 1][col + 1];
                int thirdRow2 = matrix[row + 1][col + 2];
                int firstRow3 = matrix[row + 2][col];
                int secondRow3 = matrix[row + 2][col + 1];
                int thirdRow3 = matrix[row + 2][col + 2];


                int currentSum = firstRow1 + secondRow1 + thirdRow1 + firstRow2 + secondRow2 + thirdRow2
                        + firstRow3 + secondRow3 + thirdRow3;
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    matrixMaxSum = new int[][] {
                            {firstRow1, secondRow1, thirdRow1},
                            {firstRow2, secondRow2, thirdRow2},
                            {firstRow3, secondRow3, thirdRow3}
                    };
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        printMatrix(matrixMaxSum);

    }

    private static int[][] readMatrix(int rows, Scanner scanner, String splitPattern) {
        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(splitPattern))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int number : arr) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

    }
}
