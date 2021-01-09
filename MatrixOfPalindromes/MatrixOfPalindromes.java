import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        char sides = 'a';
        char middle = 'a';

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String current = "";
                current += sides;
                current += middle;
                current += sides;
                System.out.print(current + " ");
                middle += 1;
            }
            System.out.println();
            sides += 1;
            middle = sides;
        }

        System.out.println();
    }
}
