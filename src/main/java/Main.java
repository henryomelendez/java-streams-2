import Model.*;
import Repo.DataRepo;

import javax.swing.text.NumberFormatter;
import java.util.*;
import java.text.NumberFormat;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ex9();
    }
    private static void ex1() {
        // TODO...
        var peopleList = DataRepo.getPeople();
        var retList = peopleList.stream()
                .filter(x -> x.getAge() > 30)
                        .collect(Collectors.toList());
        System.out.println(retList);
    }
    private static void ex2() {
        // TODO...
        var peopleList = DataRepo.getPeople();
        double avg = peopleList.stream().mapToDouble(x -> x.getAge()).average().orElse(0);
        System.out.println(avg);
    }
    private static void ex3() {
        // TODO...
        var catList = DataRepo.getCats();
          List<Cat> cats = catList.stream()
                  .filter(x -> x.getColor().equalsIgnoreCase("brown"))
                  .sorted(Comparator.comparing(Cat::getAge))
                  .collect(Collectors.toList());
        System.out.println(cats);
    }
    private static void ex4() {
        // TODO...
        Integer[] numbers = new Integer[] { 1, 2, 3, 1, 2, 3, 4};
        Arrays.stream(numbers)
                .collect(Collectors.toSet())
                .forEach(x -> System.out.print(x + " "));
    }
    private static void ex5() {
        // TODO...
        long engines = DataRepo.getCarsWithEngines().stream()
                .filter(p -> p.getEngine().getNumCylinders() > 6).count();
        System.out.println(engines);
    }
    private static void ex6() {
        // TODO...
        System.out.print("[");
        List<Person> personList = DataRepo.getPeople();
        personList.stream().map(person -> person.getFirstName().toUpperCase())
                .forEach(p -> System.out.print(p + ", "));
        System.out.print("]");
    }

    private static void ex7() {
        // TODO...
        NumberFormatter numberFormat = new NumberFormatter(NumberFormat.getCurrencyInstance());
        List<Car> cars = DataRepo.getCars();
        cars.stream()
                .forEach(x -> new Car(x.getId(), x.getMake(), x.getModel(),x.getPrice()));
        System.out.println(cars);
    }

    private static void ex8() {
        // TODO...
        List<Car> cars = DataRepo.getCars();
        List<Person> people = DataRepo.getPeople();

        Map<Integer, String> map = cars.stream()
                .collect(Collectors.toMap(Car::getId, Car::getModel));

        List<String> result = people.stream()
                .map(person -> map.getOrDefault(person.getCarId(), "none"))
                .collect(Collectors.toList());

        System.out.println(result.toString());
    }

    private static void ex9() {
        List<Car> cars = DataRepo.getCarsWithEngines();
        List<EngineRecord> engineRecords = cars.stream()
                .map(p -> new EngineRecord(p.getEngine().getNumCylinders(), p.getEngine().getDisplacment(), p.getEngine().getNumCylinders() >= 8 ?
                        p.getEngine().getDisplacment() * 100 : 0))
                .collect(Collectors.toList());
        System.out.println(engineRecords);;
    }
    private static void ex10() {
        // TODO...

    }
}
