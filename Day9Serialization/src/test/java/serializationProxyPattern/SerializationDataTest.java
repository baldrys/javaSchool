package serializationProxyPattern;

import org.junit.Test;

import java.io.IOException;
import static org.junit.Assert.*;
public class SerializationDataTest {

    @Test
    public void serializationTest() {
        String fileName = "data.ser";

        Data data = new Data("Text");
        try {
            Util.serialize(data, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Data newData = (Data) Util.deserialize(fileName);
            assertTrue(data.toString().equals(newData.toString()));
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

}
