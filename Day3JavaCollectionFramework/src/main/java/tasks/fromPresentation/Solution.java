package tasks.fromPresentation;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class
Solution {
    // Задание 1: Подсчитайте количество различных слов в файле.
    public static int fisrtTask(File text) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(text));
        return (int) br.lines()
                .map(line -> line.split("\\s+")) // Stream<String[]>
                .flatMap(Arrays::stream) // Stream<String>
                .distinct()
                .count();
    }

    // Задание 2: Выведите на экран список различных слов файла,
    // отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту).
    public static SortedSet<String> secondTask(File text) throws FileNotFoundException {
        class ExampleComparator implements Comparator<String> {
            public int compare(String s1, String s2) {
                int value;
                if (s1.length() == s2.length())
                    value = 0;
                else if (s1.length() < s2.length())
                    value = -1;
                else
                    value = 1;
                if (value == 0) {
                    return s1.compareTo(s2);
                }
                return value;

            }
        }

        BufferedReader br = new BufferedReader(new FileReader(text));
        return br.lines()
                .map(line -> line.split("\\s+")) // Stream<String[]>
                .flatMap(Arrays::stream)
                .collect(
                        Collectors.toCollection(() -> new TreeSet<>(new ExampleComparator())));
    }
    // Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
    public static Map<String, Long> thirdTask(File text) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(text));
        return br.lines()
                .map(line -> line.split("\\s+")) // Stream<String[]>
                .flatMap(Arrays::stream)
                .collect(groupingBy(identity(), counting()));
    }
    // Задание 4: Выведите на экран все строки файла в обратном порядке.
    public static List<String> fourthTask(File text) throws FileNotFoundException  {
        BufferedReader br = new BufferedReader(new FileReader(text));
        return br.lines()
                .map(s -> new StringBuilder(s).reverse().toString())
                .collect(Collectors.toList());
    }

    // Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
    public static void sixthhTask(File text, InputStream in, PrintStream out) throws FileNotFoundException {

        Scanner scnr = new Scanner(text);
        Scanner scnr2 = new Scanner(in);

        ArrayList<String> listOfLines = new ArrayList<String>();
        while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            listOfLines.add(line);
        }

        int n = scnr2.nextInt();

        for (int i = 0; i<n; i++){
            int j = scnr2.nextInt() - 1;
            out.println(listOfLines.get(j));
        }
    }

    public static void main(String[] args) throws FileNotFoundException {


        ClassLoader classLoader = Solution.class.getClassLoader();
        File text = new File(Objects.requireNonNull(classLoader.getResource("input.txt")).getFile());
        List<String> listOfReversedStrings;
        listOfReversedStrings = fourthTask(text);
        System.out.println(listOfReversedStrings.toString());

    }
}
