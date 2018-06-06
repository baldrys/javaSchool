package tasks.acm.sgu.ru;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

import java.io.*;

public class TestSolution {
    private PrintStream ps;
    private  ByteArrayOutputStream os;

    @Before
    public void createOutputStream(){
        os = new ByteArrayOutputStream();
        ps = new PrintStream(os);
    }

    @Test
    public void task2056() throws UnsupportedEncodingException {

        ByteArrayInputStream in = new ByteArrayInputStream(("a aa aaa aaaa\n" +
                "a aa aaa bbbb\n").getBytes());

        tasks.acm.sgu.ru.task2056.Solution.task2056(in, ps);
        String output = os.toString("UTF8");

        assertEquals( output, "a\n" +
                "aa\n" +
                "aaa\n");
    }

    @Test
    public void task2057() throws UnsupportedEncodingException{
        ByteArrayInputStream in = new ByteArrayInputStream(("6\n" +
                "1 3\n" +
                "1 2\n" +
                "1 1\n" +
                "2\n" +
                "2\n" +
                "2\n").getBytes());

        tasks.acm.sgu.ru.task2057.Solution.task2057(in, ps);
        String output = os.toString("UTF8");
        assertEquals(output, "1\n" +
                "2\n" +
                "3\n");
    }


}
