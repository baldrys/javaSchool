package tasks.fromPresentation;

import org.junit.Before;
import org.junit.Test;
import tasks.fromPresentation.fifthTask.MyLinkedList;


import static org.junit.Assert.assertEquals;

import java.io.*;
import java.util.*;

public class TestPresentationTasks {
    private File text;
    @Before
    public void readFile(){
        ClassLoader classLoader = Solution.class.getClassLoader();
        text = new File(Objects.requireNonNull(classLoader.getResource("input.txt")).getFile());
    }

    @Test
    public void testTask1() throws FileNotFoundException {
        assertEquals(Solution.fisrtTask(text), 6);
    }

    @Test
    public void testTask2() throws FileNotFoundException {

        Set<String> uniqueWords;
        uniqueWords = Solution.secondTask(text);
        assertEquals(uniqueWords, new HashSet<>(Arrays.asList("p", "iop", "asdf", "rtyu", "zxcv", "qwerty")));
    }

    @Test
    public void testTask3() throws FileNotFoundException {
        Map<String, Long> countOfWords;
        Map<String, Long> actualCountOfWords = new HashMap<String, Long>(){
            {
                put("p", 1L);
                put("qwerty",2L);
                put("zxcv",1L);
                put("asdf",1L);
                put("rtyu", 1L);
                put("iop",1L);
            }
        };
        countOfWords = Solution.thirdTask(text);
        assertEquals(countOfWords, actualCountOfWords);
    }

    @Test
    public void testTask4() throws FileNotFoundException {
        List<String> reversedListOfstrings;

        reversedListOfstrings = Solution.fourthTask(text);

        assertEquals(reversedListOfstrings, Arrays.asList("vcxz fdsa ytrewq", "ytrewq p poi uytr"));
    }

    @Test
    public void testTask5(){
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Element 0");
        list.add("Element 1");
        list.add("Element 2");

        Iterator<String> iter = list.iteratorReverse();

        assertEquals(iter.next(), "Element 2");
        assertEquals(iter.next(), "Element 1");
        assertEquals(iter.next(), "Element 0");

    }

    @Test
    public void testTask6() throws UnsupportedEncodingException, FileNotFoundException {
        PrintStream ps;
        ByteArrayOutputStream os;

        os = new ByteArrayOutputStream();
        ps = new PrintStream(os);

        ByteArrayInputStream in = new ByteArrayInputStream(("2\n" +
                "2\n" +
                "1\n").getBytes());

        Solution.sixthhTask(text, in, ps);
        String output = os.toString("UTF8");
        assertEquals(output, "rtyu iop p qwerty\n" +
                "qwerty asdf zxcv\n");

    }
}
