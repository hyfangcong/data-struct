package bcz2019.bytedance;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Man {
    public void sayHello(Integer i){
        System.out.println("i say hello");
    }

    public void sayHello(Character c){
        System.out.println("c say hello");
        try {
            Class aClass = Class.forName("ff");
            try {
                Field field = aClass.getField("d");


                try {
                    Object ob  = aClass.newInstance();

                    try {
                        Method method = aClass.getMethod("dd");
                        try {
                            method.invoke(ob,null);
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void main(){
        sayHello(new Integer(1));
        sayHello(new Character('a'));
    }


}
