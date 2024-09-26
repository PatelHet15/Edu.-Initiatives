package adaptor_final;

public class Shopping_Adapter implements Online_Shoping {
    Online_Shoping_for_EV online_Shoping_for_EV;

    public Shopping_Adapter(String Vehicle_Type){

        if (Vehicle_Type.equalsIgnoreCase("Two Wheeler")){
            online_Shoping_for_EV = new Two_Wheeler();
        }
        else if (Vehicle_Type.equalsIgnoreCase("Four Wheeler")){
            online_Shoping_for_EV = new Four_Wheeler();
        }

    }

    @Override
    public void Product(String Vehicle_Type, String Brand_Name) {

        if (Vehicle_Type.equalsIgnoreCase("Two Wheeler")){
            online_Shoping_for_EV.For_Two_Wheeler(Brand_Name);
        }
        else if (Vehicle_Type.equalsIgnoreCase("Four Wheeler")){
            online_Shoping_for_EV.For_Four_Wheeler(Brand_Name);
        }

    }
}
