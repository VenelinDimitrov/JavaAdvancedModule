import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = size[0];
        int cols = size[1];

        int[][] bigMatrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            bigMatrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int sum = Integer.MIN_VALUE;

        int[][] smallMatrix = new int[3][3];

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int currentSum = bigMatrix[row][col] + bigMatrix[row][col + 1] + bigMatrix[row][col + 2]
                        + bigMatrix[row + 1][col] + bigMatrix[row + 1][col + 1] + bigMatrix[row +1][col + 2]
                        + bigMatrix[row + 2][col] + bigMatrix[row + 2][col + 1] + bigMatrix[row + 2][col + 2];

                if (currentSum > sum) {
                    sum = currentSum;
                    smallMatrix[0][0] = bigMatrix[row][col];
                    smallMatrix[0][1] = bigMatrix[row][col + 1];
                    smallMatrix[0][2] = bigMatrix[row][col + 2];
                    smallMatrix[1][0] = bigMatrix[row + 1][col];
                    smallMatrix[1][1] = bigMatrix[row + 1][col + 1];
                    smallMatrix[1][2] = bigMatrix[row +1][col + 2];
                    smallMatrix[2][0] = bigMatrix[row + 2][col];
                    smallMatrix[2][1] = bigMatrix[row + 2][col + 1];
                    smallMatrix[2][2] = bigMatrix[row + 2][col + 2];
                }
            }
        }

        System.out.printf("Sum = %d\n", sum);

        for (int row = 0; row < smallMatrix.length; row++) {
            for (int col = 0; col < smallMatrix[row].length; col++) {
                System.out.print(smallMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
