package collectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
      * Параметризация методов листа, используя правило PECS.


 */
public class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static<T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? extends T> source, T el) {
        return source.indexOf(el);
    }

    public static <T> List<T> limit(List<? extends T> source, int size) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i<size;i++){
            list.add(source.get(i));
        }
        return list;
    }

    public static <T> void add(List<? super T> source, T el) {
        source.add(el);
    }

    //public static void removeAll(List removeFrom, List c2)
    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    //true если первый лист содержит все элементы второго
    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    //true если первый лист содержит хотя-бы 1 второго
    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (T el: c2) {
            if (c1.contains(el))
                return true;
        }
        return false;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    public static <T extends Comparable<T>> List<T> range(List<? extends T> list, T min, T max) {
        List<T> list1 = new ArrayList<>();
        for (T el : list) {
            //System.out.println(el);
            if (el.compareTo(min) >= 0 && el.compareTo(max) <= 0) {
                list1.add(el);

            }
        }
        Collections.sort(list1);
        return list1;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    public static <T> List<T> range(List<? extends T> list, T min, T max, Comparator<T> comparator) {
        List<T> list1 = new ArrayList<>();
        for (T el : list) {
            if (comparator.compare(el, min) >= 0 && comparator.compare(el, max) <= 0)  {
                list1.add(el);
            }
        }
        list1.sort(comparator);
        return list1;

    }


}
