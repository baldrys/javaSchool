package countMap;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CountMapTest {
    private CountMap<Integer> countMap1;

    @Before
    public void initializeCountMap() {
        countMap1 = new CountMapIml<>();
        countMap1.add(10);
        countMap1.add(10);
        countMap1.add(5);
        countMap1.add(6);
        countMap1.add(5);
        countMap1.add(10);
    }

    @Test
    public void testGetCount() {
        assertEquals(countMap1.getCount(10), 3);
    }

    @Test
    public void testSize() {
        assertEquals(countMap1.size(), 3);
    }

    @Test
    public void testRemove() {
        countMap1.remove(6);
        assertEquals(countMap1.size(), 2);
    }

    @Test
    public void testAddAll(){
        CountMap<Integer> countMap2 = new CountMapIml<>();
        countMap2.add(1);
        countMap2.add(5);
        countMap2.add(6);
        countMap2.add(10);
        countMap2.addAll(countMap1);

        assertEquals(countMap2.getCount(1),1);
        assertEquals(countMap2.getCount(5),3);
        assertEquals(countMap2.getCount(6),2);
        assertEquals(countMap2.getCount(10),4);
    }

    @Test
    public void testToMap() {
        Map<Integer, Integer> map1;

        map1 = countMap1.toMap();
        Map<Integer, Integer> map2 = new HashMap<>();
        map2.put(10,3);
        map2.put(5,2);
        map2.put(6,1);

        assertEquals(map1,map2);
    }
    @Test
    public void testToMapDest(){
        Map<Integer, Integer> map1 = new HashMap<>();

        countMap1.toMap(map1);
        Map<Integer, Integer> map2 = new HashMap<>();
        map2.put(10,3);
        map2.put(5,2);
        map2.put(6,1);

        assertEquals(map1,map2);
    }

}
