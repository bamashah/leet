package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {
    static List<String> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();

    static Predicate<Integer> predicate = x -> x == 3;
    static Consumer<String> consumer = x -> list1.add(x);
    static Supplier<Integer> supplier = () -> new Random().nextInt();
    static BiConsumer<String, Integer> biConsumer = (x,y) -> {list1.add(x); list2.add(y);};

    public static void main(String[] args) {
        System.out.println(predicate.test(5));
        System.out.println(predicate.test(3));
        consumer.accept("Vroom");
        System.out.println(list1);
        System.out.println(supplier.get());
        biConsumer.accept("Ola", 66);
        System.out.println(list1);
        System.out.println(list2);
    }


}
