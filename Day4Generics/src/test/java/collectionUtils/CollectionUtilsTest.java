package collectionUtils;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static collectionUtils.CollectionUtils.*;
import static org.junit.Assert.*;

public class CollectionUtilsTest {
    private List<Integer> list;
    private List<Integer> list1;

    @Before
    public void initializeLists(){
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list1 = CollectionUtils.newArrayList();
//        list1.add(4);
//        list1.add(5);
    }

    @Test
    public void testAddAllToDest(){
        list1 = CollectionUtils.newArrayList();
        addAll(list,list1);
        assertEquals(list,list1);
    }

    @Test
    public void testLimit(){

        list1 = CollectionUtils.limit(list, 2);
        assertEquals(list1.size(), 2);
    }

    @Test
    public void testIndexOf(){
        assertEquals(indexOf(list,2),1);
    }

    @Test
    public void testAdd(){
        add(list1, 1);
        add(list1,2);
        add(list1,3);
        assertEquals(list,list1);
    }

    @Test
    public void testRemoveAll(){
        add(list1, 1);
        add(list1,2);
        removeAll(list,list1);
        assertEquals(list.size(),1);
        assertEquals(indexOf(list,3),0);
    }

    @Test
    public void testContains(){
        add(list1, 1);
        add(list1,2);
        assertTrue(containsAll(list,list1));
        assertTrue(containsAny(list,list1));
    }

    @Test
    public void testRange(){
        List<Integer> list2 = Arrays.asList(8,1,3,5,6, 4);
        list1 = range(list2, 3, 6);

        assertEquals(list1, Arrays.asList(3, 4, 5, 6));
        list1 = range(list2, 3, 6, Integer::compareTo);
        assertEquals(list1, Arrays.asList(3, 4, 5, 6));
    }

}
