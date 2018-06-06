package classLoaders;

public class AppClassloader extends ApiClassLoader {

    @Override
    public Class loadClass(String name) throws ClassNotFoundException {
        System.out.println("Loading Class '" + name + "'");
        if (name.startsWith("app")) {
            System.out.println("Loading Class using AppClassloader");
            return getClass(name);
        }
        return super.loadClass(name);
    }
}
