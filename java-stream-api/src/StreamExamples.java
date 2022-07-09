import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {

    private static List<Car> cars = Arrays.asList(
            new Car(1, "Opel", "Astra", 105, 20_000),
            new Car(2, "Lamborghini", "Gallardo", 320, 120_000),
            new Car(3, "Mercedes", "C180", 200, 40_000),
            new Car(4, "Opel", "Insignia", 120, 28_000),
            new Car(5, "VW", "Polo", 92, 17_000),
            new Car(6, "BMW", "M3", 250, 80_000)
    );

    public static void main(String[] args) {
        createStream();
        filter();
        map();
        flatMapGroup();
        mapMulti();
        distinct();
        sorted();
        sortedComparator();
        peek();
        limit();
        skip();
        takeWhile();
        dropWhile();
        iterate();
        iterateHasNext();
        concat();
        forEach();
        toArray();
        reduce();
        toList();
        minMax();
        count();
        match();
        find();
        collect();
        collectCollectors();
        exampleForStreamTrace();
    }


    static void filter(){
            cars
                .stream()
                .filter(car -> car.price() > 30_000)
                .forEach(System.out::println);
    }

    static void map(){
            cars
                .stream()
                .map(Car::model)
                .forEach(System.out::println);
    }

    static void mapGroup(){
        cars
            .stream()
            .mapToInt(Car::horsePower).average();

        cars
            .stream()
            .mapToDouble(Car::price).sum();
    }

    static void flatMap(){
        List<List<String>> brands = new ArrayList<>();
        brands.add(Arrays.asList("Ferrari", "Lamborghini", "Maserati"));
        brands.add(Arrays.asList("Opel", "VW", "Fiat"));
        brands.add(Arrays.asList("BMW", "Mercedes", "Audi"));

        List<String> brandsFlat = brands
                .stream()
                .flatMap(Collection::stream)
                .toList();
    }

    static void flatMapGroup(){
        List<List<Car>> carsDeepList = new ArrayList<>();
        carsDeepList.add(cars);
        carsDeepList.add(
                Collections.singletonList(
                        new Car(7L, "Opel", "Zafira", 100, 20_000))
        );
        carsDeepList.add(
                Collections.singletonList(
                        new Car(8L, "Opel", "Corsa", 80, 18_000))
        );

        double brandsFlat = carsDeepList
                .stream()
                .flatMapToDouble(carsList -> carsList.stream().mapToDouble(Car::price))
                .max()
                .orElse(-1);

        System.out.println(brandsFlat);
    }

    static void mapMulti(){
        List<List<Car>> carsDeepList = new ArrayList<>();
        carsDeepList.add(cars);
        carsDeepList.add(
                Collections.singletonList(
                        new Car(7L, "Opel", "Zafira", 100, 20_000))
        );
        carsDeepList.add(
                Collections.singletonList(
                        new Car(8L, "Opel", "Corsa", 80, 18_000))
        );

         carsDeepList.stream().<Map<String, String>>mapMulti(
                    ((carsList, consumer) -> {
                       for(Car car: carsList){
                           if(Math.random() < 0.05){
                               consumer.accept(
                                       Map.of(car.model(), car.brand())
                               );
                           }
                       }
                    }
                ));
    }


    static void distinct(){
        Stream.of(new Car(1, "Opel", "Astra", 105, 20_000),
                new Car(2, "Lamborghini", "Gallardo", 320, 120_000),
                new Car(3, "Mercedes", "C180", 200, 40_000),
                new Car(3, "Mercedes", "C180", 200, 40_000),
                new Car(4, "Mercedes", "C180", 200, 40_000))
                .distinct()
                .forEach(System.out::println);
    }


    static void sorted(){
        //Will print them in ascending order
        Stream.of(1, -1, 5,  100, 3, 0)
                        .sorted().forEach(System.out::println);

        //Will print them in ascending lexicographical order
        Stream.of("Code", "Learn", "Hub", "Hello", "World")
                .sorted().forEach(System.out::println);
        //Will fail as Car object does not implement comparable interface
        try {
            Stream.of(new Car(1, "Opel", "Astra", 105, 20_000),
                            new Car(2, "Lamborghini", "Gallardo", 320, 120_000),
                            new Car(3, "Mercedes", "C180", 200, 40_000))
                    .sorted()
                    .forEach(System.out::println);
        } catch (Exception e){
            e.printStackTrace();
        }

        Stream.of(      new CarComparable(1, "Opel", "Astra", 105, 20_000),
                        new CarComparable(2, "Lamborghini", "Gallardo", 320, 120_000),
                        new CarComparable(3, "Mercedes", "C180", 200, 40_000))
                .sorted()
                .forEach(System.out::println);

    }

    static void sortedComparator(){
        Stream.of(      new Car(1, "Opel", "Astra", 105, 20_000),
                        new Car(2, "Lamborghini", "Gallardo", 320, 120_000),
                        new Car(3, "Mercedes", "C180", 200, 40_000),
                        new Car(4, "BMW", "Z4", 180, 40_000),
                        new Car(5, "Opel", "Mokka", 180, 40_000)
                )
                .sorted(Comparator
                        .comparing(Car::price)
                        .thenComparing(Car::horsePower)
                        .thenComparing(Car::brand)
                        .reversed()
                )
                .forEach(System.out::println);
    }

    static void peek(){
        var x = Stream.of(      new Car(1, "Opel", "Astra", 105, 20_000),
                        new Car(2, "Lamborghini", "Gallardo", 320, 120_000),
                        new Car(3, "Mercedes", "C180", 200, 40_000),
                        new Car(4, "BMW", "Z4", 180, 40_000),
                        new Car(5, "Opel", "Mokka", 180, 40_000)
                )
                .filter(car -> car.brand().equals("Opel"))
                .peek(car -> System.out.println("Filtered car:" + car))
                .map(Car::model)
                .peek(model -> System.out.println("Mapped car object to model:" + model))
                .toList();
    }

    static void limit(){
         Stream.of(      new Car(1, "Opel", "Astra", 105, 20_000),
                        new Car(2, "Lamborghini", "Gallardo", 320, 120_000),
                        new Car(3, "Mercedes", "C180", 200, 40_000),
                        new Car(4, "BMW", "Z4", 180, 40_000),
                        new Car(5, "Opel", "Mokka", 180, 40_000)
                )
                .limit(1).forEach(System.out::println);
    }

    static void skip(){
        Stream.of(      new Car(1, "Opel", "Astra", 105, 20_000),
                        new Car(2, "Lamborghini", "Gallardo", 320, 120_000),
                        new Car(3, "Mercedes", "C180", 200, 40_000),
                        new Car(4, "BMW", "Z4", 180, 40_000),
                        new Car(5, "Opel", "Mokka", 180, 40_000)
                )
                .skip(4)
                .forEach(System.out::println);
    }

    static void takeWhile(){
        Stream.of(      new Car(1, "Lamborghini", "Gallardo", 320, 120_000),
                        new Car(2, "Opel", "Astra", 105, 20_000),
                        new Car(3, "Mercedes", "C180", 200, 40_000),
                        new Car(4, "BMW", "Z4", 180, 40_000),
                        new Car(5, "Opel", "Mokka", 180, 40_000)
                )
                .takeWhile(car -> car.price()  > 40_000)
                .forEach(System.out::println);
    }

    static void dropWhile(){
        Stream.of(      new Car(1, "Lamborghini", "Gallardo", 320, 120_000),
                        new Car(2, "Opel", "Astra", 105, 20_000),
                        new Car(3, "Mercedes", "C180", 200, 40_000),
                        new Car(4, "BMW", "Z4", 180, 40_000),
                        new Car(5, "Opel", "Mokka", 180, 40_000)
                )
                .dropWhile(car -> car.price()  > 20_000)
                .forEach(System.out::println);
    }

    static void createStream(){
        Stream<String> streamString = Stream.of("Hello", "World");
        Stream<Integer> streamInteger =  Stream.of(5);
        var s = Stream.ofNullable(null);
        Stream<Object> built = Stream.builder()
                .add("Code")
                .add("Learn")
                .add("Hub")
                .build();
        var sE = Stream.empty();
        Stream<List<String>> streamStringGen = Stream.generate(() -> {
            List<String> list = new ArrayList<>();
            list.add("hello");
            list.add("world");
            return list;
        });


    }

    static void streamConvertFromList(){
        List<String> list = List.of("C", "L", "H")
                .stream()
                .filter(l -> l.equals("C"))
                .toList();
        Set<String> set = Set.of("C", "L", "H")
                .stream()
                .filter(l -> l.equals("C"))
                .collect(Collectors.toSet());
        Map<Long, String> map = Map.of(1L, "C", 2L, "L", 3L, "H")
                .entrySet()
                .stream()
                .filter(l -> l.getValue().equals("C"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }

    static void iterate(){

        Stream
                .iterate(1, i -> i * 2)
                .limit(20).
                forEach(System.out::println);

        Stream
                .iterate(Arrays.asList(0, 1), fibList ->
                    Arrays.asList(fibList.get(1), fibList.get(0) + fibList.get(1)
                ))
                .limit(10)
                .map(list -> list.get(0))
                .forEach(System.out::println);


    }

    static void iterateHasNext(){

        Stream
                .iterate(1, i -> i < 10, i -> i + 1)
                .limit(20)
                .forEach(System.out::println);

    }

    static void concat(){

        Stream<String> clh = Stream.of("Code", "Learn", "Hub");
        Stream<String> programmingLanguages = Stream.of("Java", "SQL", "Swift", "Python");

        Stream
                .concat(clh, programmingLanguages)
                .forEach(System.out::println);

    }

    static void forEach(){
        System.out.println("Using forEach in simple stream:");
        Stream.of("C", "L", "H").forEach(System.out::println);

        System.out.println("Using forEach in parallel stream:");
        Stream.of("C", "L", "H").parallel().forEach(System.out::println);

        System.out.println("Using forEachOrdered in parallel stream:");
        Stream.of("C", "L", "H").parallel().forEachOrdered(System.out::println);

        List<CarPojo> carPojoList = Arrays.asList(      new CarPojo("Lamborghini", "Gallardo", 320, 120_000),
                new CarPojo("Opel", "Astra", 105, 20_000),
                new CarPojo("Mercedes", "C180", 200, 40_000),
                new CarPojo("BMW", "Z4", 180, 40_000),
                new CarPojo("Opel", "Mokka", 180, 40_000)
        );

        carPojoList
                .stream()
                .forEach(carPojo -> {
                    switch (carPojo.getBrand()){
                        case "Opel" -> carPojo.setPrice(carPojo.getPrice() * 1.1);
                        case "Mercedes", "BMW" -> carPojo.setPrice(carPojo.getPrice() * 1.2);
                        case "Lamborghini" -> carPojo.setPrice(carPojo.getPrice() * 1.4);
                    }
                });
        carPojoList.forEach(System.out::println);
    }

    static void toArray(){
        Object[] strings = Stream.of("C", "L", "H")
                .toArray();
        String[] stringsArr = Stream.of("C", "L", "H")
                .toArray(String[]::new);

    }

    static void reduce(){
        //simple reduce without initial value
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(Integer::sum).get();
        System.out.println(sum);
        // reduce with initial value
        int sumWithSeed = numbers.stream().reduce(100,Integer::sum);
        System.out.println(sumWithSeed);
        // reduce with initial value and a combiner, allows you to change return value
        List<Integer> clh = Arrays.asList(1, 2, 3);
        String result = clh.stream()
                .reduce("String is: ",
                        (firstNumber, secondNumber) -> firstNumber + secondNumber,
                        String::concat
                );
        System.out.println(result);

    }

    static void toList(){
        List<String> listCollectors = Stream.of("C", "L", "H").collect(Collectors.toList());
        List<String> list = Stream.of("C", "L", "H").toList();
        listCollectors.add("A");
        list.add("A");
    }

    static void minMax(){
        List<Car> list = Arrays.asList(
                new Car(1L,"Lamborghini", "Gallardo", 320, 120_000),
                new Car(2L, "Opel", "Astra", 105, 20_000),
                new Car(3L, "Mercedes", "C180", 200, 40_000),
                new Car(4L, "BMW", "Z4", 180, 40_000),
                new Car(5L, "Opel", "Mokka", 180, 40_000)
        );

        Car expensive = list.stream().max(Comparator.comparing(Car::price)).orElse(null);
        Car cheap = list.stream().min(Comparator.comparing(Car::price)).orElse(null);
        System.out.println("Most expensive car is: "+expensive);
        System.out.println("Cheapest car is: "+cheap);
    }

    static void count(){
        List<Car> list = Arrays.asList(
                new Car(1L,"Lamborghini", "Gallardo", 320, 120_000),
                new Car(2L, "Opel", "Astra", 105, 20_000),
                new Car(3L, "Mercedes", "C180", 200, 40_000),
                new Car(4L, "BMW", "Z4", 180, 40_000),
                new Car(5L, "Opel", "Mokka", 180, 40_000)
        );

        System.out.println(list.stream().count());
    }

    static void match(){
        List<Car> list = Arrays.asList(
                new Car(1L,"Lamborghini", "Gallardo", 320, 120_000),
                new Car(2L, "Opel", "Astra", 105, 20_000),
                new Car(3L, "Mercedes", "C180", 200, 40_000),
                new Car(4L, "BMW", "Z4", 180, 40_000),
                new Car(5L, "Opel", "Mokka", 180, 40_000)
        );

        boolean allHavePriceLessThan150k = list
                .stream().
                allMatch(car -> car.price() < 150_000); //true

        boolean atLeastOneIsLamborghini = list
                .stream()
                .anyMatch(car -> car.brand().equals("Lamborghini")); //true

        boolean noneIsFerrari = list
                .stream()
                .allMatch(car -> car.brand().equals("Ferrari"));
    }

    static void find(){
        var any = Stream.of("C", "L", "H")
                .parallel()
                .findAny()
                .orElse(null);

        var first = Stream.of("C", "L", "H")
                .parallel()
                .findFirst()
                .orElse(null);

        System.out.print(any);
        System.out.print(first);
    }

    static void collect(){
        Map<Long, String> carMap = Stream.of(
                new Car(1L,"Lamborghini", "Gallardo", 320, 120_000),
                new Car(2L, "Opel", "Astra", 105, 20_000),
                new Car(3L, "Mercedes", "C180", 200, 40_000),
                new Car(4L, "BMW", "Z4", 180, 40_000),
                new Car(5L, "Opel", "Mokka", 180, 40_000)
        ).collect(
                HashMap::new,
                (map, car) -> map.put(car.id(), car.model()),
                HashMap::putAll
        );

        String combined = Stream.of("Code", "Learn", "Hub", "is", "the", "best.")
                .collect(StringBuilder::new,
                        (sb, aString) -> sb.append(aString).append(" "),
                        StringBuilder::append
                ).toString();
        System.out.println(combined);
    }

    static void collectCollectors(){
        List<Car> cars = Arrays.asList(
                new Car(1, "Opel", "Astra", 105, 20_000),
                new Car(2, "Lamborghini", "Gallardo", 320, 120_000),
                new Car(3, "Mercedes", "C180", 200, 40_000),
                new Car(4, "Opel", "Insignia", 120, 28_000),
                new Car(5, "VW", "Polo", 92, 17_000),
                new Car(6, "BMW", "M3", 250, 80_000)
        );

        //Map cars to models and collect them to a list
        List<String> models = cars.
                stream()
                .map(Car::model)
                .collect(Collectors.toList());

        //Map cars to brands and convert them to set, will remove duplicates
        Set<String> brandsSet = cars.
                stream()
                .map(Car::brand)
                .collect(Collectors.toSet());

        // Use toCollection to produce a LinkedHashSet with brands
        LinkedHashSet<String> brandsLinkedHashSet = cars.
                stream()
                .map(Car::brand)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        // Use joining to reduce strings to one string
        String brandsString = cars.
                stream()
                .map(Car::brand)
                .distinct()
                .collect(Collectors.joining(","));
        // Will print Opel,Lamborghini,Mercedes,VW,BMW
        //Get average price
        double averagePrice = cars.
                stream()
                .collect(Collectors.averagingDouble(Car::price));
        // Filter all the cars that cost > $50k
        List<Car> carsMoreThan50k = cars.
                stream()
                .collect(
                        Collectors.filtering(
                                car -> car.price() > 50_000,
                                Collectors.toList())
                );
        // Group cars by brand
        Map<String, List<Car>> carsGroup = cars.
                stream()
                .collect(
                        Collectors.groupingBy(
                                Car::brand,
                                Collectors.toList()
                        )
                );
        //Create two partions, one with cars <=50k price and one with >50k price
        Map<Boolean, List<Car>> carsPartitionByPrice = cars.
                stream()
                .collect(Collectors.partitioningBy(car -> car.price() > 50_000));
        carsPartitionByPrice.entrySet().forEach(System.out::println);

    }

    static void exampleForStreamTrace(){
        List<Car> cars = Arrays.asList(
                new Car(1, "Opel", "Astra", 105, 20_000),
                new Car(2, "Lamborghini", "Gallardo", 320, 120_000),
                new Car(3, "Mercedes", "C180", 200, 40_000),
                new Car(4, "Opel", "Insignia", 120, 28_000),
                new Car(5, "VW", "Polo", 92, 17_000),
                new Car(6, "BMW", "M3", 250, 80_000)
        );

        String[] modelsArray = cars.stream()
                .filter(car -> car.price() > 50_000)
                .sorted(Comparator.comparing(Car::price).reversed())
                .map(Car::model)
                .toArray(String[]::new);
    }

    private record Car(long id, String brand, String model, int horsePower, double price) {};

    private record CarComparable(long id, String brand, String model, int horsePower, double price) implements Comparable<CarComparable>{
        @Override
        public int compareTo(CarComparable o) {
            double priceDif = this.price - o.price;
            if(priceDif > 0){
                return 1;
            } else if(priceDif == 0){
                return 0;
            } else {
                return -1;
            }
        }
    };

}