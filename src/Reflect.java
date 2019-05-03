import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class singletonClass = Class.forName("Singleton");
        Class clzz = Singleton.class;


        Field[] fields = singletonClass.getDeclaredFields();
        String fieldName = fields[0].getName();

        Constructor constructor = singletonClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton object = (Singleton) constructor.newInstance();

        Method method = singletonClass.getMethod("init", String.class);
        method.invoke(object,"fang cong");
        System.out.println(object.singleton );
         fields[0].set(object, "abc");


        System.out.println(object.singleton);
        System.out.println(fields.length);
    }
}
