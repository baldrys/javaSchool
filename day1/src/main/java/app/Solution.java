package app;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    private static int[] readSizeAndArray(InputStream in){
        Scanner scanner = new Scanner(in);
        int N = scanner.nextInt();
        int[] array = IntStream
                .range(0, N)
                .map(i -> scanner.nextInt())
                .toArray();
        return array;
    }

    private Solution(){}
    // Индекс первого минимума
    public static void task2005(InputStream in, PrintStream out){
        int[] array = readSizeAndArray(in);

        int minIdxOfArray = IntStream
                .range(0, array.length)
                .reduce((i,j) -> array[i] > array[j] ? j : i)
                .getAsInt();
        minIdxOfArray++;
        out.print(minIdxOfArray);
    }

    // Задан массив из n чисел (a1, a2,..., an).
    // Ваша задача — подсчитать количество пар (i, j), 1 ≤ i ≤ j ≤ n,
    // что сумма чисел, стоящих на позициях i, i+1,..., j-1, j равна 0.
    public static void task2030(InputStream in, PrintStream out){
        int[] array = readSizeAndArray(in);

        long n = IntStream.range(0, array.length)
                .flatMap(i -> IntStream.range(i, array.length)
                        .map(j -> {
                            int sum = Arrays.stream(Arrays.copyOfRange(array, i, j+1)).sum();
                            return sum == 0?1:0;
                        })).sum();
        out.print(n);
    }

    // Задан массив a. Требуется каждый его элемент заменить на ближайший справа больший.
    // Результаты замен не влияют на другие, то есть считайте, что все замены производятся
    // одновременно.
    // Если справа нет большего элемента, то замените элемент на число 0.
    public static void task2026(InputStream in, PrintStream out){
        int[] array = readSizeAndArray(in);

        String strOutput = IntStream
                .range(0, array.length)
                .map(i ->{
                            int firstMax = Arrays.stream(array)
                                    .skip(i)
                                    .filter(x -> x > array[i])
                                    .findFirst().orElse(0);

                            return firstMax;
                        }
                )
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" "));;
        out.print(strOutput);
    }

    // Определим слово как последовательность латинских букв алфавита.
    // Все остальные символы являются разделителями.
    // Дан текст, состоящий из символов с номерами от 32 до 127 (см. таблицу символов ASCII).
    // Ваша задача — найти количество букв в наидлинейшем слове из этого текста.
    public static void task2038(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in);
        String str = scanner.nextLine();
        String[] strs = str.split("\\P{IsAlphabetic}+");
        int maxN = Arrays.stream(strs)
                .mapToInt(String::length)
                .max().getAsInt();
        out.print(maxN);
    }

    // Дан текст, состоящий только из маленьких латинских букв и запятых.
    // Последовательность подряд идущих букв, окруженную запятыми (началом, концом строки),
    // назовем словом. Слово может быть пустым.
    // Ваша задача — удалить из текста все слова короче k символов.
    public static void task2037(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in);
        String str = scanner.nextLine();

        int desireLength = scanner.nextInt();
        String[] strList = str.split(",");
        String strOutput = Arrays.stream(strList)
                .filter(s -> s.length() >= desireLength)
                .collect(Collectors.joining(","));

        out.print(strOutput);
    }

}
