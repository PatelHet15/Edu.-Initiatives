//Advansed singleton design pattern

package singleton;

public class Singleton_Pattern_2 {
    private Singleton_Pattern_2(){}
    private static Singleton_Pattern_2 sgp_2 = new Singleton_Pattern_2();
    public static Singleton_Pattern_2 getinstance()
    {
        return sgp_2;
    }
    public void draw()
    {
        System.out.println("How are you ?");
    }

}