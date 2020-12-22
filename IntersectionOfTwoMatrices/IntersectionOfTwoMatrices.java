import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] first = readCharMatrix(scanner, rows, cols);
        char[][] second = readCharMatrix(scanner, rows, cols);

        char[][] output = new char[rows][cols];

        for (int row = 0; row < first.length; row++) {
            for (int col = 0; col < first[row].length; col++) {
                if (first[row][col] == second[row][col]) {
                    output[row][col] = first[row][col];
                } else {
                    output[row][col] = '*';
                }
            }
        }

        for (int row = 0; row < output.length; row++) {
            for (int col = 0; col < output[row].length; col++) {
                System.out.print(output[row][col] + " ");
            }
            System.out.println();
        }

    }

    private static char[][] readCharMatrix(Scanner scanner, int rows, int cols) {
        char[][] result = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String input = scanner.nextLine().replace(" ", "");
            char[] current = input.toCharArray();

            for (int col = 0; col < cols; col++) {
                result[row][col] = current[col];
            }
        }

        return result;
    }
}
