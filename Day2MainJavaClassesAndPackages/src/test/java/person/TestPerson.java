package person;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class TestPerson {

    private Person maxim;
    private Person dasha;
    private Person vladimir;
    private Person diana ;

    @Before
    public void initialize(){
        maxim = new Person(true, "Максим");
        dasha = new Person(false, "Даша");
        vladimir = new Person(true, "Владимир");
        diana = new Person(false, "Диана");
        dasha.marry(maxim);
    }

    @Test
    public void testMarry(){
        assertEquals(dasha.getSpouse().getName(), maxim.getName());
        assertEquals(dasha.getName(), maxim.getSpouse().getName());
    }

    @Test
    public void testDivorce() {
        vladimir.marry(diana);
        vladimir.marry(dasha);
        assertNull(diana.getSpouse());
        assertNull(maxim.getSpouse());
    }

    @Test
    public void gayTest() {
        assertFalse(vladimir.marry(maxim));
    }
}
