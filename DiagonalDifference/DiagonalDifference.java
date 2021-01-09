import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int firstDiagonalSum = 0;
        for (int row = 0; row < size; row++) {
            firstDiagonalSum += matrix[row][row];
        }

        int secondDiagonalSum = 0;
        int rows = size - 1;
        int cols = 0;
        while (rows >= 0) {
            secondDiagonalSum += matrix[rows][cols];
            rows--;
            cols++;
        }

        System.out.println(Math.abs(firstDiagonalSum - secondDiagonalSum));
    }
}
