import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsToMapExample {

    private static final List<Car> cars = new ArrayList<>(
            Arrays.asList(
                    new Car(1L, "Astra", "Opel", 100, 18000d),
                    new Car(2L, "Insignia", "Opel", 120, 22000d),
                    new Car(3L, "Golf", "VW", 90, 17000d),
                    new Car(4L, "Passat", "VW", 120, 25000d),
                    new Car(5L, "Gallardo", "Lamborghini", 350, 120000d)
            ));

    public static void main(String[] args) {
      collectorsToMap2Params();
      collectorsToMap3Params();
      collectorsToMap4Params();
    }


    private static void collectorsToMap2Params(){
        System.out.println("Calling collectors toMap with 2 params:\n");
        // Transform cars list to map (id, car_object)
        Map<Long, Car> carsMap = cars.stream()
                .collect(Collectors.toMap(Car::id, Function.identity()));

        carsMap.entrySet().forEach(System.out::println);

        // Transform cars list to map (id, model)
        Map<Long, String> idModelMap = cars.stream()
                .collect(Collectors.toMap(Car::id, Car::model));

        idModelMap.entrySet().forEach(System.out::println);
        System.out.println();

    }

    private static void collectorsToMap3Params(){
        System.out.println("Calling collectors toMap with 3 params:\n");
        Map<String, String> brandmodel = cars.stream()
                .collect(Collectors.toMap(
                        Car::brand,
                        Car::model,
                        (model1, model2) -> model1 + ", " + model2 )
                );

        brandmodel.entrySet().forEach(System.out::println);
        System.out.println();

    }

    private static void collectorsToMap4Params(){
        System.out.println("Calling collectors toMap with 4 params:\n");
        TreeMap<String, String> brandmodel = cars.stream()
                .collect(Collectors.toMap(
                        Car::brand,
                        Car::model,
                        (model1, model2) -> model1 + ", " + model2,
                        TreeMap::new)
                );

        brandmodel.entrySet().forEach(System.out::println);
        System.out.println();

    }


    private record Car(long id, String model, String brand, int horses, double price){};
}
