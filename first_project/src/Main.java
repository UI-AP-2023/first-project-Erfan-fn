import model.Roles.AdminModel;
import model.Stuff.*;
import view.MainPanel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        CarModel carModel=new CarModel("cls",30000,2,"mercedes",3300,true);
        AdminModel.getAdminModel().getStuffList().add(carModel);
        PersonalComputerModel personalComputerModel=new PersonalComputerModel("acer",3500,1,2,"2*2*2","corei7",16);
        AdminModel.getAdminModel().getStuffList().add(personalComputerModel);
        MainPanel mainPanel=new MainPanel();
        mainPanel.startPanel();
    }
}
