package gettersCounter;

import static java.lang.reflect.Proxy.newProxyInstance;

public class Main {
    public static void main(String[] args) {
        Class clazz = TestClass.class;
        GetterCounterImpl getterCounter = new GetterCounterImpl();
        System.out.println("Колличество гетеров: " + getterCounter.calcGetterCount(clazz));


        GetterCounter getterCounter1Proxy = (GetterCounter) newProxyInstance(GetterCounterImpl.class.getClassLoader(),
                GetterCounterImpl.class.getInterfaces(),
                new CachedGetterCounterInvocationHandler(getterCounter) {
                });

        System.out.println("Колличество гетеров: " + getterCounter1Proxy.calcGetterCount(clazz));

        System.out.println("Колличество гетеров: " + getterCounter1Proxy.calcGetterCount(clazz));

    }

}
