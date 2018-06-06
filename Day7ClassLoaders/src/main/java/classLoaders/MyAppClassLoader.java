package classLoaders;

import java.lang.reflect.Field;

public class MyAppClassLoader extends AppClassloader {
    @Override
    public Class loadClass(String name) throws ClassNotFoundException {

        Class<?> clazz = Class.forName(name);
        Class<?> superClazz = clazz.getSuperclass();
        if (superClazz != null){
            String superClassName = clazz.getSuperclass().getName();

            boolean isCalculatorImlFieldInFields = false;
            for (Field field : clazz.getDeclaredFields()) {
                if ("CalculatorImpl".equals(field.getType().getName())) {
                    isCalculatorImlFieldInFields = true;
                    break;
                }
            }
            System.out.println("Loading Class '" + name + "'");
            if (name.equals("app.MyApp") &
                    superClassName.equals("app.App") &
                    isCalculatorImlFieldInFields) {
                System.out.println("Loading Class using MyAppClassLoader");
                return getClass(name);
            }
            return super.loadClass(name);
        }

        return super.loadClass(name);
    }
}
