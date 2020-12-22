package CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] command = scanner.nextLine().split("\\s+");

        CustomList list = new CustomList();

        while (!command[0].equals("END")) {
            if (command.length == 2) {
                String action = command[0];

                switch (action) {
                    case "Add":
                        String element = command[1];
                        list.add(element);
                        break;
                    case "Remove":
                        int index = Integer.parseInt(command[1]);
                        list.remove(index);
                        break;
                    case "Contains":
                        String toFind = command[1];
                        System.out.println(list.contains(toFind));
                        break;
                    case "Greater":
                        String toBeat = command[1];
                        System.out.println(list.countGreaterThan(toBeat));
                        break;
                }
            } else if (command.length == 1) {
                String action = command[0];

                switch (action) {
                    case "Max":
                        System.out.println(list.getMax());
                        break;
                    case "Min":
                        System.out.println(list.getMin());
                        break;
                    case "Print":
                        System.out.print(list);
                        break;
                    case "Sort":
                        list.sort();
                        break;
                }
            } else if (command.length == 3) {
                int index1 = Integer.parseInt(command[1]);
                int index2 = Integer.parseInt(command[2]);
                list.swap(index1, index2);
            }

            command = scanner.nextLine().split("\\s+");
        }
    }
}
