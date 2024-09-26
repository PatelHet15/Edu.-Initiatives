import com.esports.*;
public class gameselector {
    public static void main(String[] args) {
        gamefactory ph1 = new gamefactory();
        Games os1 = ph1.getInstance("Small");
        os1.unique_thing();
    }
}