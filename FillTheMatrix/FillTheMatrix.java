import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sizeAndPattern = scanner.nextLine().split(",\\s+");
        int size = Integer.parseInt(sizeAndPattern[0]);
        String pattern = sizeAndPattern[1];
        int[][] matrix = new int[size][size];

        int counter = 1;
        if (pattern.equals("A")) {
            for (int col = 0; col < size; col++) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = counter++;
                }
            }
        } else if (pattern.equals("B")) {
            for (int col = 0; col < size; col++) {
                if (col % 2 == 1) {
                    for (int row = matrix[col].length - 1; row >= 0; row--) {
                        matrix[row][col] = counter++;
                    }
                } else {
                    for (int row = 0; row < size; row++) {
                        matrix[row][col] = counter++;
                    }
                }
            }
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
