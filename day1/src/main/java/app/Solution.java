package app;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private Solution(){}


    // Индекс первого минимума
    public static void task2005(InputStream in, PrintStream out){
        Scanner scanner = new Scanner(in);

        int count = scanner.nextInt();
        int previousNumber = scanner.nextInt();
        int minIndex = 1;
        int nextNumber;

        for (int i = 2; i < count; i++){
            nextNumber = scanner.nextInt();
            if (previousNumber > nextNumber){
                minIndex = i;
                previousNumber = nextNumber;
            }
        }
        out.print(minIndex);

    }

    // Задан массив из n чисел (a1, a2,..., an).
    // Ваша задача — подсчитать количество пар (i, j), 1 ≤ i ≤ j ≤ n,
    // что сумма чисел, стоящих на позициях i, i+1,..., j-1, j равна 0.
    public static void task2030(InputStream in, PrintStream out){
        Scanner scanner = new Scanner(in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        int count = 0;
        int sumOfArr;

        for (int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                sumOfArr = Arrays.stream(Arrays.copyOfRange(arr, i, j+1)).sum();
                if (sumOfArr == 0) count++;
            }
        }
        out.print(count);
    }

    // Задан массив a. Требуется каждый его элемент заменить на ближайший справа больший.
    // Результаты замен не влияют на другие, то есть считайте, что все замены производятся одновременно.
    // Если справа нет большего элемента, то замените элемент на число 0.
    public static void task2026(InputStream in, PrintStream out){
        Scanner scanner = new Scanner(in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        int maxElementInSufix;

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            maxElementInSufix = arr[i];
            for (int j = i + 1; j < n; j++) {
                if (maxElementInSufix < arr[j]){
                    maxElementInSufix = arr[j];
                    break;
                }
            }
            if (arr[i] < maxElementInSufix)
                arr[i] = maxElementInSufix;
            else arr[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            out.print(arr[i] + (i == n - 1 ? "" : " "));
        }
    }


    // Определим слово как последовательность латинских букв алфавита.
    // Все остальные символы являются разделителями.
    // Дан текст, состоящий из символов с номерами от 32 до 127 (см. таблицу символов ASCII).
    // Ваша задача — найти количество букв в наидлинейшем слове из этого текста.

    public static boolean isLatinLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    public static void task2038(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in);

        String str = scanner.nextLine();
        int lenOfWord = 0;
        int maxLenOfWord = 0;
        boolean wordIsEnded = true;

        for(char c: str.toCharArray()){
            if (isLatinLetter(c)) {
                lenOfWord++;
                wordIsEnded = false;
            }
            else if (!wordIsEnded){
                wordIsEnded = true;
                if (lenOfWord > maxLenOfWord) maxLenOfWord = lenOfWord;
                lenOfWord = 0;
            }

        }
        out.print(maxLenOfWord);
    }

    // Дан текст, состоящий только из маленьких латинских букв и запятых.
    // Последовательность подряд идущих букв, окруженную запятыми (началом, концом строки),
    // назовем словом. Слово может быть пустым.
    // Ваша задача — удалить из текста все слова короче k символов.
    public static void task2037(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in);
        String str = scanner.nextLine();
        String strNew = "";
        //StringBuilder strBld = new StringBuilder();
        int desireLength = scanner.nextInt();
        int lenOfStr = 0;

        boolean ifNewWordStarted = false;


        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ',' ){
                if (!ifNewWordStarted) ifNewWordStarted=true;
                else {
                    if (lenOfStr >= desireLength){
                        //strBld.append(str.substring(i-lenOfStr, i) + ",");
                        strNew = strNew + str.substring(i-lenOfStr, i) + ",";
                    }

                    lenOfStr = 0;
                }
            }
            else {
                lenOfStr++;
                if (i+1 == str.length() && lenOfStr >= desireLength){
                    //strBld.append(str.substring(i-lenOfStr+1 , i+1));
                    strNew = strNew + str.substring(i-lenOfStr+1 , i+1);
                }
            }
        }
        if (strNew.charAt(0)==',') strNew = strNew.substring(1,strNew.length()-1);
        if (strNew.charAt(strNew.length() - 1)==',') strNew = strNew.substring(0,strNew.length()-1);
        out.print(strNew);
    }

}
