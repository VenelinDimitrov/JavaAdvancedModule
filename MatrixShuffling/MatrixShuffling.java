import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = tokens[0];
        int cols = tokens[1];

        String[][] matrix = readMatrix(scanner, rows, cols);

        String[] command = scanner.nextLine().split("\\s+");

        if (command.length < 5) {
            System.out.println("Invalid input!");
            command = scanner.nextLine().split("\\s+");
        }

        while (!command[0].equals("END")) {
            String action = command[0];
            int swapFromRow = Integer.parseInt(command[1]);
            int swapFromCol = Integer.parseInt(command[2]);
            int swapToRow = Integer.parseInt(command[3]);
            int swapToCol = Integer.parseInt(command[4]);

            boolean isValidIndex = checkIfIndexIsValid(swapFromRow, swapFromCol, swapToRow, swapToCol, rows, cols);
            if (action.equals("swap") && isValidIndex && command.length == 5) {
                String temp = matrix[swapToRow][swapToCol];
                matrix[swapToRow][swapToCol] = matrix[swapFromRow][swapFromCol];
                matrix[swapFromRow][swapFromCol] = temp;

                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine().split("\\s+");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols] + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkIfIndexIsValid(int swapFromRow, int swapFromCol, int swapToRow, int swapToCol, int rows, int cols) {
        if (swapFromRow > rows || swapFromRow < 0 || swapToRow > rows || swapToRow < 0
        || swapFromCol > cols || swapFromCol < 0 || swapToCol > cols || swapToCol < 0) {
            return false;
        } else {
            return true;
        }
    }

    private static String[][] readMatrix(Scanner scanner, int rows, int cols) {
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] current = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = current[col];
            }
        }

        return matrix;
    }
}
