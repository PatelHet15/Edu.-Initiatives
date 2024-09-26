package adaptor_final;

public class Vehicles implements Online_Shoping{
    Shopping_Adapter shopping_Adapter;

    @Override
    public void Product(String Vehicle_Type, String Brand_Name){

        if (Vehicle_Type.equalsIgnoreCase("Three Wheeler")){
            System.out.println("--> This is a three Wheeler. Its Brand Name is: " + Brand_Name);
        }

        else if (Vehicle_Type.equalsIgnoreCase("Two Wheeler") || Vehicle_Type.equalsIgnoreCase("Four Wheeler")){
            shopping_Adapter = new Shopping_Adapter(Vehicle_Type);
            shopping_Adapter.Product(Vehicle_Type, Brand_Name);
        }

        else {
            System.out.println("--> Invalid Vehicle Type: " + Vehicle_Type + ". And also invalid Brand name: " + Brand_Name);
        }
    }
}
