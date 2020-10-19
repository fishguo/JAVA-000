import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FishClassLoader extends ClassLoader {

    public static void main (String arg[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        final Class<?> aClass = new FishClassLoader().findClass("Hello");
        final Object obj = aClass.newInstance();

        Method method = null;
        try {
            method = aClass.getMethod("hello");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            method.invoke(obj);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        int buf_size = 1024;
        String path = "C:\\Users\\Autobots\\JAVA-000\\Week_01\\Hello.xlass";
        byte[] bytes = new byte[buf_size];
        final File file = new File(path);

        final ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
        BufferedInputStream in = null;

        try {
            in = new BufferedInputStream(new FileInputStream(file));

            int len = 0;
            while (-1 != (len = in.read())) {
                len = 255 -len;
                bos.write(len);
            }
            bytes = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return defineClass(name, bytes, 0, bytes.length);
    }

}
