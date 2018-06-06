package countMap;

import java.util.HashMap;
import java.util.Map;

public class CountMapIml<K> implements CountMap<K>{
    private Map<K, Integer> countMap = new HashMap<>();

    // добавляет элемент в этот контейнер.
    public void add(K key){
        if (countMap.get(key) == null)
            countMap.put(key, 1);
        else
            countMap.put(key, countMap.get(key) + 1);
    }

    //Возвращает количество добавлений данного элемента
    public int getCount(K key){
        if (countMap.get(key) == null){
            return 0;
        }
        return countMap.get(key);
    }

    //Удаляет элемент и контейнера и возвращает количество его добавлений(до удаления)
    public int remove(K key){
        if (countMap.get(key) == null){
            return 0;
        }
        Integer count = countMap.get(key);
        countMap.remove(key);
        return count;
    }

    //количество разных элементов
    public int size(){
        return countMap.size();
    }

    //Добавить все элементы из source в текущий контейнер, при совпадении ключей, суммировать значения
    public void addAll(CountMap<K> source){
        Map<K, Integer> sourceCountMap =  source.toMap();
        for (K key : sourceCountMap.keySet()){
            if (countMap.get(key) != null){
                countMap.put(key, countMap.get(key) + sourceCountMap.get(key));
            } else {
                countMap.put(key, sourceCountMap.get(key));
            }
        }

    }

    //Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений
    public Map<K, Integer> toMap(){
        Map<K, Integer> map = new HashMap<>(countMap);
        return map;
    }

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    public void toMap(Map<K, Integer> destination){
        destination.putAll(countMap);
    }

    public String toString(){
        return countMap.toString();
    }

}
