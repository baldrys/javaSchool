package main;

import classLoaders.*;


import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {

        ApiClassLoader apiClassLoaderoader = new ApiClassLoader();
        AppClassloader appClassloader = new AppClassloader();
        ImplClassLoader implClassLoader = new ImplClassLoader();

        MyAppClassLoader myAppClassLoader = new MyAppClassLoader();


//        Class<?> ApiClass = apiClassLoaderoader.loadClass("Day7ClassLoaders.api.Calculator");
        Class<?> ImplClass = implClassLoader.loadClass("impl.CalculatorImpl");
        Class<?> ApiClass = apiClassLoaderoader.loadClass("api.Calculator");
        Class<?> AppClass = appClassloader.loadClass("app.App");

        Class<?> MyAppClass = appClassloader.loadClass("app.MyApp");
//        System.out.println("ImplClass загружен: " + ImplClass.getClassLoader());
//
//        System.out.println("ApiClass загружен: " + ApiClass.getClassLoader());
//
        //System.out.println("MyApp загружен: " + MyAppClass.getClassLoader());
        System.out.println(ImplClass.getClassLoader().toString()+" = " +(implClassLoader.toString()));






    }
}