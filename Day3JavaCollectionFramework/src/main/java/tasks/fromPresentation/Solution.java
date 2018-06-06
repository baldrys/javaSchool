package tasks.fromPresentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class
Solution {
    // Задание 1: Подсчитайте количество различных слов в файле.
    public static int fisrtTask(File text) throws FileNotFoundException {
        Set<String> uniqueWords = new HashSet<>();
        Scanner scnr = new Scanner(text);

        String[] parts;
        while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            parts = line.split("\\s*(=>|,|\\s)\\s*");
            int x = 12;
            for(String s: parts) {
                uniqueWords.add(s.toLowerCase());
            }
        }
        return uniqueWords.size();
    }

    // Задание 2: Выведите на экран список различных слов файла,
    // отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту).
    public static SortedSet<String> secondTask(File text) throws FileNotFoundException {
        //File text = new File("C:\\Users\\eban\\Documents\\java tasks\\task\\src\\input.txt");
        Set<String> uniqueWords = new HashSet<String>();

        Scanner scnr = new Scanner(text);
        class ExampleComparator  implements Comparator<String> {
            public int compare(String s1, String s2) {
                int value;
                if( s1.length() == s2.length())
                    value = 0;
                else if(s1.length() < s2.length())
                    value = -1;
                else
                    value = 1;
                if (value == 0) {
                    return s1.compareTo(s2);
                }
                return value;

            }
        }

        SortedSet<String> sortedUniqueWords = new TreeSet<String>( new ExampleComparator());
        String[] parts;

        while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            parts = line.split("\\s*(=>|,|\\s)\\s*");

            for(String s: parts) {
                sortedUniqueWords.add(s.toLowerCase());
            }

        }
        return sortedUniqueWords;

    }
    // Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
    public static Map<String, Integer> thirdTask(File text) throws FileNotFoundException {
        //File text = new File("C:\\Users\\eban\\Documents\\java tasks\\task\\src\\input.txt");
        Set<String> uniqueWords = new HashSet<String>();

        Scanner scnr = new Scanner(text);

        Map<String, Integer> countOfWords = new HashMap<String, Integer>();
        String[] parts;

        while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            parts = line.split("\\s*(=>|,|\\s)\\s*");
            for(String s: parts) {
                String word = s.toLowerCase();
                if (countOfWords.containsKey(word)){
                    countOfWords.put(word, countOfWords.get(word) + 1);
                } else {
                    countOfWords.put(word, 1);
                }
            }
        }
        return countOfWords;
    }
    // Задание 4: Выведите на экран все строки файла в обратном порядке.
    public static ArrayList<String> fourthTask(File text) throws FileNotFoundException  {
        Scanner scnr = new Scanner(text);
        ArrayList<String> listOfLines = new ArrayList<String>();
        ArrayList<String> listOfLinesOutput = new ArrayList<String>();
        while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            listOfLines.add(line);
        }
        for (String line: listOfLines){
            String reverse = new StringBuffer(line).reverse().toString();
            listOfLinesOutput.add(reverse);
            //System.out.println(reverse);
        }
        return listOfLinesOutput;
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
