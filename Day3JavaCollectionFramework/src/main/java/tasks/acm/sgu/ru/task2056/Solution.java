package tasks.acm.sgu.ru.task2056;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

// Найти слово, которое встречается в тексте наибольшее количество раз
public class Solution {
    public static void task2056(InputStream in, PrintStream out) {
        Map<String, Long> grouped = new BufferedReader(new InputStreamReader(in)).lines()
                .map(w -> w.split(" "))
                .flatMap(Arrays::stream)
                .collect(groupingBy(identity(), counting()));

        long max = grouped.values().stream().max(Comparator.naturalOrder()).get();
        grouped.entrySet().stream()
                .filter(e -> e.getValue() == max)
                .map(Map.Entry::getKey)
                .sorted()
                .forEach(out::println);
    }
}
