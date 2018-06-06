package tasks.acm.sgu.ru.task2056;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

// Найти слово, которое встречается в тексте наибольшее количество раз
public class Solution {
    public static void task2056(InputStream in, PrintStream out) {

        Scanner scanner;
        HashMap<String, Integer> countOfWords = new HashMap<>();
        ArrayList<String> listOfPopularWords = new ArrayList<>();
        int maxNubmerOfWord = 1;
        String word;

        scanner = new Scanner(in);
        while (scanner.hasNext()){
            word = scanner.next().toLowerCase();
            if (countOfWords.containsKey(word)){
                countOfWords.put(word, countOfWords.get(word) + 1);
            } else {
                countOfWords.put(word, 1);
            }

            if (maxNubmerOfWord < countOfWords.get(word)){
                maxNubmerOfWord = countOfWords.get(word);
            }

        }

        for (HashMap.Entry<String, Integer> pair: countOfWords.entrySet()) {
            if (pair.getValue() == maxNubmerOfWord){
                listOfPopularWords.add(pair.getKey());
            }
        }
        Collections.sort(listOfPopularWords);

        for (String temp : listOfPopularWords) {
            out.println(temp);
        }
    }
}
