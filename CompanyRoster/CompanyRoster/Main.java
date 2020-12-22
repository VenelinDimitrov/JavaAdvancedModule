package CompanyRoster;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Department> departments = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            Employee employee;

            if (tokens.length == 4) {
                String email ="n/a";
                int age = -1;
                employee = new Employee(name, salary, position, department, email, age);
            } else if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else {
                try {
                    int age = Integer.parseInt(tokens[4]);
                    String email ="n/a";
                    employee = new Employee(name, salary, position, department, email, age);
                } catch (NumberFormatException e) {
                    String email = tokens[4];
                    int age = -1;
                    employee = new Employee(name, salary, position, department, email, age);
                }
            }

            departments.putIfAbsent(department, new Department(department));
            departments.get(department).getEmployees().add(employee);
        }

        Department departmentWithHighestSalary = departments.entrySet()
                .stream()
                .max(Comparator.comparing(e -> e.getValue().getAverageSalary()))
                .get()
                .getValue();

        System.out.printf("Highest Average Salary: %s\n", departmentWithHighestSalary.getName());
        departmentWithHighestSalary.getEmployees().stream()
                .sorted((e1,e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(e -> System.out.printf("%s %.2f %s %d\n", e.getName(), e.getSalary(), e.getEmail(), e.getAge()));
    }
}
