package stream;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class StreamsTest {
    private List<Person> list1;
    @Before
    public void initStreams(){
        Person p1 = new Person("Вася", 18);
        Person p2 = new Person("Петя", 28);
        Person p3 = new Person("Маша", 48);
        Person p4 = new Person("Катя", 23);
        Person p5 = new Person("Максим", 34);
        list1 = new ArrayList<>();
        list1.add(p1);
        list1.add(p2);
        list1.add(p3);
        list1.add(p4);
        list1.add(p5);

    }

    @Test
    public void test1(){
        List<Person> list2 = new ArrayList<>(list1);;
        Map m = Streams.of(list1)
                .filter(p -> p.getAge() > 20)
                .transform( p -> new Person(p.getName(),p.getAge() + 30))
                .toMap(p -> p.getName(), p -> p);

        Map m1 = list1.stream()
                .filter(p -> p.getAge() > 20)
                .map( p -> new Person(p.getName(),p.getAge() + 30))
                .collect(Collectors.toMap(p -> p.getName(), p -> p));

        assertEquals(m, m1);
        assertEquals(list1, list2);
    }

}
