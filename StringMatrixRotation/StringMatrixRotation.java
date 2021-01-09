import java.util.ArrayList;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rotationAndDegrees = scanner.nextLine().split("[()]");
        int degrees = Integer.parseInt(rotationAndDegrees[1]) % 360;

        String input = scanner.nextLine();
        ArrayList<String> words = new ArrayList<>();
        int longestWord = 0;

        while (!input.equals("END")) {
            if (input.length() > longestWord){
                longestWord = input.length();
            }
            words.add(input);

            input = scanner.nextLine();
        }

        char[][] matrix = new char[words.size()][longestWord];
        for (int row = 0; row < words.size(); row++) {
            String currentWord = words.get(row);

            for (int col = 0; col < longestWord; col++) {
                if (col >= currentWord.length()){
                    matrix[row][col] = ' ';
                } else {
                    matrix[row][col] = currentWord.charAt(col);
                }
            }
        }

        printMatrix(matrix, degrees, longestWord);
    }

    private static void printMatrix(char[][] matrix, int degrees, int longestWord) {
        if (degrees == 90) {
            for (int col = 0; col < longestWord; col++) {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (degrees == 180) {
            for (int row = matrix.length - 1; row >= 0; row--) {
                for (int col = matrix[row].length - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (degrees == 270) {
            for (int col = longestWord - 1; col >= 0; col--) {
                for (int row = 0; row < matrix.length; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else {
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }
}
