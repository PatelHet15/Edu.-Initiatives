package adaptor_final;

public class Four_Wheeler implements Online_Shoping_for_EV {
    
    @Override
    public void For_Two_Wheeler(String Brand_Name){
    }

    @Override
    public void For_Four_Wheeler(String Brand_Name){
        System.out.println("--> These is a EV brand in four wheeler: " + Brand_Name);
    }
}