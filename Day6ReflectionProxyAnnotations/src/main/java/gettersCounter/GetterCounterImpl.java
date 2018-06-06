package gettersCounter;

import java.lang.reflect.Method;

public class GetterCounterImpl implements GetterCounter {

    @Override
    public int calcGetterCount(Class<?> clazz) {
        int countOfGetters = 0;
        Method[] methods = clazz.getDeclaredMethods();

        for(Method method : methods){
            if (isGetter(method) & !method.isAnnotationPresent(Skip.class)){
                // System.out.println("getter: " + method);
                countOfGetters++;
            }

        }
        return countOfGetters;
    }

    private static boolean isGetter(Method method){
        if(!method.getName().startsWith("get"))      return false;
        if(method.getParameterTypes().length != 0)   return false;
        if(void.class.equals(method.getReturnType())) return false;
        return true;
    }
}
