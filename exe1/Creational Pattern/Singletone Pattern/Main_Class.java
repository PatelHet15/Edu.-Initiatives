package singleton;

public class Main_Class {
    public static void main(String[] args) {
        Single_Pattern obj = Single_Pattern.getpattern();
        obj.draw();
        Singleton_Pattern_2 obj2 = Singleton_Pattern_2.getinstance();
        obj2.draw();
    }
}