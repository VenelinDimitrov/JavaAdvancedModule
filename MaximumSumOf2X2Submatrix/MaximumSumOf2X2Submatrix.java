import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] bigMatrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            bigMatrix[row] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] smallMatrix = new int[2][2];
        int sum = Integer.MIN_VALUE;
        for (int row = 0; row < bigMatrix.length - 1; row++) {
            for (int col = 0; col < bigMatrix[row].length - 1; col++) {
                int currentSum = bigMatrix[row][col] + bigMatrix[row][col + 1] + bigMatrix[row + 1][col] + bigMatrix[row + 1][col + 1];

                if (currentSum > sum) {
                    sum = currentSum;
                    smallMatrix[0][0] = bigMatrix[row][col];
                    smallMatrix[0][1] = bigMatrix[row][col + 1];
                    smallMatrix[1][0] = bigMatrix[row + 1][col];
                    smallMatrix[1][1] = bigMatrix[row + 1][col + 1];
                }
            }
        }

        for (int row = 0; row < smallMatrix.length; row++) {
            for (int col = 0; col < smallMatrix[row].length; col++) {
                System.out.print(smallMatrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println(sum);
    }
}