package gettersCounter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetterCounterTest {
    @Test
    public void testgGetterCounter(){
        Class clazz = TestClass.class;
        GetterCounterImpl getterCounter = new GetterCounterImpl();
        assertEquals(getterCounter.calcGetterCount(clazz),2);
    }
}
