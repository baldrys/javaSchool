package classLoadersTesting;

import classLoaders.ApiClassLoader;
import classLoaders.AppClassloader;
import classLoaders.ImplClassLoader;
import classLoaders.MyAppClassLoader;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClassLoadersTest {

    private ApiClassLoader apiClassLoader;
    private AppClassloader appClassloader;
    private ImplClassLoader implClassLoader;
    private MyAppClassLoader myAppClassLoader;

    private Class<?> ImplClass;
    private Class<?> ApiClass;
    private Class<?> AppClass;
    private Class<?> MyAppClass;

    @Before
    public void initializeClassLoaders() throws ClassNotFoundException {
        apiClassLoader = new ApiClassLoader();
        appClassloader = new AppClassloader();
        implClassLoader = new ImplClassLoader();
        myAppClassLoader = new MyAppClassLoader();


        ImplClass = implClassLoader.loadClass("impl.CalculatorImpl");
        ApiClass = apiClassLoader.loadClass("api.Calculator");
        AppClass = appClassloader.loadClass("app.App");
        MyAppClass = myAppClassLoader.loadClass("app.MyApp");
    }

    @Test
    public void testClassLoaders(){
        assertEquals(ImplClass.getClassLoader(), implClassLoader);
        assertEquals(ApiClass.getClassLoader(), apiClassLoader);
        assertEquals(AppClass.getClassLoader(), appClassloader);
    }

    @Test
    public void testCantLoadBrother() throws ClassNotFoundException {
        Class<?> ImplClass1 = appClassloader.loadClass("impl.CalculatorImpl");
        assertNotEquals(ImplClass1.getClassLoader(), appClassloader);
    }

    @Test
    public void testLoadMyappClass(){
        assertEquals(MyAppClass.getClassLoader(), myAppClassLoader);
    }



}
