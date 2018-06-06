package gettersCounter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CachedGetterCounterInvocationHandler implements InvocationHandler {
    private Map<Integer, Integer> cachedGetters = new HashMap<>();
    private Object target;

    public CachedGetterCounterInvocationHandler(Object target) {
        this.target = target;

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Integer result;

        Integer getterCount = cachedGetters.get(Arrays.hashCode(args));
        if (getterCount != null) {
            result = getterCount;
            System.out.println("Используется кэш.");
        } else {
            result = (Integer) method.invoke(target, args);
            cachedGetters.put(Arrays.hashCode(args), result);
            System.out.println("Первый раз.");
        }
        return result;
    }
}
