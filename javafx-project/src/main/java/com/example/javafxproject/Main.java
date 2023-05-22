package com.example.javafxproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Roles.AdminModel;
import model.Stuff.*;
import model.UserModelFacilities.DiscountModel;
import view.MainPanel;

import java.io.IOException;
import java.time.LocalDate;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

    }

    public static void main(String[] args) {
//        launch();
        DiscountModel discountModel=new DiscountModel(33,"2003/02/22",3);
        System.out.println(discountModel.getDiscountCode());
        CarModel carModel=new CarModel("cls",30000,2,"mercedes",3300,true);
        AdminModel.getAdminModel().getStuffList().add(carModel);
        PersonalComputerModel personalComputerModel=new PersonalComputerModel("acer",3500,1,2,"2*2*2","corei7",16);
        AdminModel.getAdminModel().getStuffList().add(personalComputerModel);
        PersonalComputerModel personalComputerModel1=new PersonalComputerModel("asus",3501,1,2,"2*2*2","corei7",16);
        AdminModel.getAdminModel().getStuffList().add(personalComputerModel1);
        PersonalComputerModel personalComputerModel2=new PersonalComputerModel("hp",3502,1,2,"2*2*2","corei7",16);
        AdminModel.getAdminModel().getStuffList().add(personalComputerModel2);
        PersonalComputerModel personalComputerModel3=new PersonalComputerModel("dell",3503,1,2,"2*2*2","corei7",16);
        AdminModel.getAdminModel().getStuffList().add(personalComputerModel3);
        PersonalComputerModel personalComputerModel4=new PersonalComputerModel("lenovo",3504,1,2,"2*2*2","corei7",16);
        AdminModel.getAdminModel().getStuffList().add(personalComputerModel4);
        PersonalComputerModel personalComputerModel5=new PersonalComputerModel("nitro",3505,1,2,"2*2*2","corei7",16);
        AdminModel.getAdminModel().getStuffList().add(personalComputerModel5);
        PersonalComputerModel personalComputerModel6=new PersonalComputerModel("rog",3500,3,2,"2*2*2","corei7",16);
        AdminModel.getAdminModel().getStuffList().add(personalComputerModel6);
        PersonalComputerModel personalComputerModel7=new PersonalComputerModel("lg",3500,4,2,"2*2*2","corei7",16);
        AdminModel.getAdminModel().getStuffList().add(personalComputerModel7);
        PersonalComputerModel personalComputerModel8=new PersonalComputerModel("mc book",3500,5,2,"2*2*2","corei7",16);
        AdminModel.getAdminModel().getStuffList().add(personalComputerModel8);
        PersonalComputerModel personalComputerModel9=new PersonalComputerModel("aspire",3501,1,2,"2*2*2","corei7",16);
        AdminModel.getAdminModel().getStuffList().add(personalComputerModel9);
        PersonalComputerModel personalComputerModel10=new PersonalComputerModel("legion",3501,1,2,"2*2*2","corei7",16);
        AdminModel.getAdminModel().getStuffList().add(personalComputerModel10);
        SsdModel ssdModel=new SsdModel("er",20,8,1,"2*2*2",16,34,23);
        AdminModel.getAdminModel().getStuffList().add(ssdModel);
        FoodModel foodModel=new FoodModel("chch",36,2,"222","222");
        BicycleModel bicycleModel=new BicycleModel("viva",2333,34,"gagag",BicycleKindModel.MOUNTAINOUS);
        MainPanel mainPanel=new MainPanel();
        mainPanel.startPanel();

    }
}