package app;
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
    public void testTask2005() throws UnsupportedEncodingException {

        ByteArrayInputStream in = new ByteArrayInputStream(("10\n" +
                "5 4 3 2 3 4 1 3 5 6\n").getBytes());

        Solution.task2005(in, ps);
        String output = os.toString("UTF8");

        assertEquals(7,  (int) Integer.valueOf(output));
    }

    @Test
    public void testTask2030() throws UnsupportedEncodingException{
        ByteArrayInputStream in = new ByteArrayInputStream(("3\n" +
                "-1 0 1\n").getBytes());

        Solution.task2030(in, ps);
        String output = os.toString("UTF8");
        assertEquals(2, (int) Integer.valueOf(output));
    }

    @Test
    public void testTask2026() throws UnsupportedEncodingException{
        ByteArrayInputStream in = new ByteArrayInputStream(("10\n" +
                "5 2 4 6 5 2 1 4 1 1\n").getBytes());

        Solution.task2026(in, ps);
        String output = os.toString("UTF8");
        assertEquals("6 4 6 0 0 4 4 0 0 0", output);
    }

    @Test
    public void testTask2038() throws UnsupportedEncodingException{
        ByteArrayInputStream in = new ByteArrayInputStream(("Professional1way2to3prepare4programming5contest6problem7890\n").getBytes());
        Solution.task2038(in, ps);
        String output = os.toString("UTF8");
        assertEquals(12, (int) Integer.valueOf(output));
    }

    @Test
    public void testTask2037() throws UnsupportedEncodingException{
        ByteArrayInputStream in = new ByteArrayInputStream((",a,ab,abc,abcd\n" +
                "2\n").getBytes());

        Solution.task2037(in, ps);
        String output = os.toString("UTF8");
        assertEquals("ab,abc,abcd", output);
    }

}
