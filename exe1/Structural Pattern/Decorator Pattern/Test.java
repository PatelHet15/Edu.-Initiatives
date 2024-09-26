package Decorator;

public class Test {
    public static void main(String[] args) {
        Plateforms amazon = new Amazon();

        Plateforms eleAmazon = new Electronics(new Amazon());

        Plateforms eleFlipcart = new Electronics(new Flipkart());

        System.out.println("Amazon website");
        amazon.Online_Plateform();

        System.out.println("Electronics items in Amazon");
        eleAmazon.Online_Plateform();

        System.out.println("Electronics items in Amazon");
        eleFlipcart.Online_Plateform();
    }
}