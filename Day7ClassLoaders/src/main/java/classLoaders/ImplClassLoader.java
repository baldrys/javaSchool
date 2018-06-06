package classLoaders;

public class ImplClassLoader extends ApiClassLoader{
    @Override
    public Class loadClass(String name) throws ClassNotFoundException {
        System.out.println("Loading Class '" + name + "'");
        if (name.startsWith("impl")) {
            System.out.println("Loading Class using ImplClassLoader");
            return getClass(name);
        }
        return super.loadClass(name);
    }
}
