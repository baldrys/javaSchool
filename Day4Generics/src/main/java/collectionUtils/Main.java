package collectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new  ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> list1 = CollectionUtils.newArrayList();

        CollectionUtils.addAll(list, list1);
        //System.out.println(list1); // [1, 2, 3]

        //System.out.println(CollectionUtils.indexOf(list1, 2)); // 1

        list1 = CollectionUtils.limit(list1, 2);
        //System.out.println(list1); // [1, 2]

        CollectionUtils.add(list1, 4);
        //System.out.println(list1); // [1, 2, 4]
        //System.out.println(list); // [1, 2, 3]
        CollectionUtils.removeAll(list1, list);
        //System.out.println(list1); // [4]

        List<Integer> list2 = new  ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        //System.out.println(CollectionUtils.containsAll(list, list2)); // true
        list2.remove(0);
        //System.out.println(CollectionUtils.containsAll(list2, list)); // false
        //System.out.println(CollectionUtils.containsAny(list2, list)); // true
        CollectionUtils.removeAll(list2, list);
        //System.out.println(CollectionUtils.containsAny(list2, list)); // false
        list2 = CollectionUtils.range(Arrays.asList(8,1,3,5,6, 4), 3, 6); // [3, 5, 6, 4]
        //System.out.println(list2);

        //list2 = CollectionUtils.range(Arrays.asList(8,1,3,5,6, 4), 3, 6, Integer::compareTo); // [3, 5, 6, 4]
        System.out.println(list2);
    }
}
