//lazy singleton design pattern

package singleton;

public class Single_Pattern {
    static Single_Pattern sgp = null;
    private Single_Pattern(){}
    public static Single_Pattern getpattern()
    {
        if(sgp==null){
            sgp = new Single_Pattern();
        }

        return sgp;
    }
    public void draw()
    {
        System.out.println("Hello");
    }
}