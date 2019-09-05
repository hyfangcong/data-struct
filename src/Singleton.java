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
}
