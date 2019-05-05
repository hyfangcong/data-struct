public class Singleton {
    String singleton = "begin";

    private Singleton(){}

    //双重检查，保证多线程的时候，也会是单例，不会出现多个实例对象


    public void init(String name){
        System.out.println("hello" + name);
    }

    /**
     * 使用静态内部类，来实现单利模式
     */
    private static class InnerSingleton{
        private static Singleton singleton = new Singleton();
    }




    private static Singleton getInstance2(){
        return InnerSingleton.singleton;
    }
}
