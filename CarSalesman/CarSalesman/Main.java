package CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfEngines = Integer.parseInt(scanner.nextLine());

        List<Engine> engineList = new ArrayList<>();

        for (int i = 0; i < numberOfEngines; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            Engine engine = createEngine(input);
            engineList.add(engine);
        }

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            Car car = createCar(input, engineList);
            cars.add(car);
        }


        for (Car car : cars) {
            System.out.println(car.getModel() + ":");
            System.out.println(car.getEngine() + ":");
            engineList.forEach(engine -> {
                        if (engine.getModel().equals(car.getEngine())) {
                            System.out.println("Power: " + engine.getPower());

                            if (engine.getDisplacement() == 0) {
                                System.out.println("Displacement: n/a");
                            } else {
                                System.out.println("Displacement: " + engine.getDisplacement());
                            }

                            if (engine.getEfficiency() == null) {
                                System.out.println("Efficiency: n/a");
                            } else {
                                System.out.println("Efficiency: " + engine.getEfficiency());
                            }
                        }
                    }
            );
            if(car.getWeight() == 0) {
                System.out.println("Weight: n/a");
            } else {
                System.out.println("Weight: " + car.getWeight());
            }

            if (car.getColor() == null) {
                System.out.println("Color: n/a");
            } else {
                System.out.println("Color: " + car.getColor());
            }
        }
    }

    public static Car createCar(String[] input, List<Engine> engines) {
        Car car = null;
        String model = input[0];
        String engineModel = input[1];

        if(input.length == 2) {

            car = new Car(model, engineModel);
        } else if (input.length == 3) {

            if (Character.isDigit(input[1].charAt(0))) {
                int weight = Integer.parseInt(input[2]);

                car = new Car(model, engineModel, weight);
            } else {
                String color = input[2];

                car = new Car(model, engineModel, color);
            }
        } else if (input.length == 4) {
            int weight = Integer.parseInt(input[2]);
            String color = input[3];

            car = new Car(model, engineModel, weight, color);
        }

        return car;
    }

    public static Engine createEngine(String[] input) {

        Engine engine = null;

        if (input.length == 2) {
            String engineModel = input[0];
            int enginePower = Integer.parseInt(input[1]);

            engine = new Engine(engineModel, enginePower);
        } else if (input.length == 3) {
            String engineModel = input[0];
            int enginePower = Integer.parseInt(input[1]);

            if (Character.isDigit(input[2].charAt(0))) {
                int engineDisplacement = Integer.parseInt(input[2]);

                engine = new Engine(engineModel, enginePower, engineDisplacement);
            } else {
                String engineEfficiency = input[2];

                engine = new Engine(engineModel, enginePower, engineEfficiency);
            }
        } else if (input.length == 4) {
            String engineModel = input[0];
            int enginePower = Integer.parseInt(input[1]);
            int engineDisplacement = Integer.parseInt(input[2]);
            String engineEfficiency = input[3];

            engine = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
        }

        return engine;
    }
}
