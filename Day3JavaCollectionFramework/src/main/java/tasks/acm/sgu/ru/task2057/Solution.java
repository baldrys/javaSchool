package tasks.acm.sgu.ru.task2057;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

// реализация мультимножества натуральных чисел
// в этой структуре могут одновременно храниться несколько равных элементов

public class Solution {
    public static void task2057(InputStream in, PrintStream out) {
        class SetDuplicate {

            private Queue<Integer> array = new PriorityQueue<>();

            public void add(int x){
                this.array.add(x);
            }

            public int remooveMin(){
                return this.array.remove();
            }
            public String toString(){
                return this.array.toString();
            }
        }

        Scanner scanner = new Scanner(in);
        SetDuplicate set = new SetDuplicate();


        int numberOfOperation = scanner.nextInt();
        int typeOfOperation;

        for (int i = 0; i < numberOfOperation; i++) {
            typeOfOperation = scanner.nextInt();
            if (typeOfOperation == 1)
                set.add(scanner.nextInt());
            else
                out.println(set.remooveMin());

        }
    }
}
