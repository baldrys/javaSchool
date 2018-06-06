package countMap;

import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        CountMap<Integer> countMap1 = new CountMapIml<>();
        countMap1.add(10);
        countMap1.add(10);
        countMap1.add(5);
        countMap1.add(6);
        countMap1.add(5);
        countMap1.add(10);

        //int count = countMap1.getCount(5); // 2
        //System.out.println(count);
        //int count = countMap1.getCount(6); // 1
        //System.out.println(count);
        //int count = countMap1.getCount(10); // 3
        //System.out.println(countMap1.remove(5));
        //System.out.println(countMap1.size());
        //int count = countMap1.getCount(10); // 3
        System.out.println(countMap1);
        CountMap<Integer> countMap2 = new CountMapIml<>();
        countMap2.addAll(countMap1);
        countMap2.add(5);

        System.out.println(countMap2); // {5=3, 6=1, 10=3}

        Map<Integer, Integer> map1;

        map1 = countMap2.toMap();
        System.out.println(map1.toString()); // {10=3, 5=3, 6=1}

        Map<Integer, Integer> map2 = new HashMap<>();

        countMap2.toMap(map2);

        System.out.println(map2); //{10=3, 5=3, 6=1}
    }


}
