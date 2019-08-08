/**
 * @author: fangcong
 * @date: 2019/8/4
 */
public class Dog implements Animal {
    @Override
    public void say() {
        System.out.println("汪汪汪");
    }

    public static void main(String[] args) {
        Animal animal = new Dog();
        try{
            Dog dog = (Dog) animal;
            dog.say();
        }catch (Exception e){
            System.out.println("error");
        }
    }
}
