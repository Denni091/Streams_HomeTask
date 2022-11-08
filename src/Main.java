import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

//        1. Создать пустой поток с двумя любыми промежуточными операциями
//        и одной терминальной-которая напечатает результат коллекции;
        Stream<Object> empty = Stream.empty();
        empty.skip(1).distinct().forEach(System.out::println);
        List<String> strings = Arrays.asList("Ukraine cities: ", "Odessa ", "Mykolaiv ", "Kyiv");
        Stream<String> stringStream = strings.stream();
        stringStream.forEach(System.out::println);

//        2. Создать поток с Листом данных(на Ваше усмотрения),
//        который будет иметь две промежуточные операции и результатом выполнения получить Набор данных;

        List<String> name = Arrays.asList("\nName: ", "Nik ", "Andrew ", "Alex");
        Stream<String> nameStream = name.stream();
        nameStream.
                filter(valid -> valid.length() > 2)
                .skip(0)
                .forEach(System.out::println);

//        3. Создать поток Набора данных(на Ваше усмотрение),
//        который не будет иметь промежуточных данных и результатом будет Лист данных;

        Stream.of("\nCar: ", "Toyota ", "Mustang ", "Mercedes").forEach(System.out::println);

//        4. Создать Коллекцию в виде “ключ-значение”,
//        наполнить, получив значение ключей пройтись по всем,
//        напечатать их значение и результатом сохранить в виде коллекции;

        HashMap<String, String> key = new HashMap<>();
        key.put("Ukraine", "Kyiv");
        key.put("Germany", "Berlin");
        key.put("France", "Paris");
        List<String> getCapitalFromKey = new ArrayList<>(key.values());
        System.out.println(getCapitalFromKey);

//        5. Cоздать коллекцию из 10 строчных значений в виде чисел.
//        Используя стрим пропустить первое значение, указать лимит 8 значений, преобразовать все значения в int,
//        отфильтровать значения только четных значения и собрать результат в коллекцию ТОЛЬКО уникальных значений;

        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> valuesStream = values.stream();
        valuesStream
                .skip(1)
                .limit(8)
                .mapToInt(Integer::valueOf)
                .filter(filterEvenValues -> filterEvenValues % 2 == 0)
                .distinct()
                .forEach(System.out::println);

//        6. Создать поток, сразу наполнив его данными(не из коллекции),
//        преобразовать в многопоточный поток, отсортировать, задать фильтр(на свое усмотрение) и найти первый элемент,
//        который попадется(как результат выполнения);

        Stream<String> mobilePhones = Stream.of("\nSmart Phone: ", "Apple ", "Samsung ", "Huawei");
        Optional<String> result = mobilePhones.parallel()
                .filter(checkMobilePhone -> checkMobilePhone.length() > 3)
                .findFirst();
        if (result.isPresent()) {
            System.out.println(result.get());
        } else
            System.out.println("No value");

//        7. Создать поток, в котором показать применения всех 4х возможных вызовов Ссылочных методов.
//        На свое усмотрение, но должны быть примеры вызовов всех методов в одном потоке.
//        Можно создавать свои классы и методы для примера вызова, можно использовать представленные уже в Java;

        Stream<String> streams = Stream.of("first ", "second ", "third ", "fourth");
        streams
                .skip(1)
                .limit(5)
                .filter(checkString -> checkString.equals("third "))
                .map(element -> {
                    System.out.println("Result: " + element);
                    return element + "_mapped";
                })
                .forEach(System.out::println);
    }
}