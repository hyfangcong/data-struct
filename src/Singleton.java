public class Singleton {
    private Singleton(){}
    /**
     * 使用静态内部类，来实现单利模式
     */
    private static class InnerSingleton{
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getInstance(){
        return InnerSingleton.singleton;
    }

    private static volatile Singleton singleton;

    public static Singleton getInstance2(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
