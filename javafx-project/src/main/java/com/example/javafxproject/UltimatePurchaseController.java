package com.example.javafxproject;

import com.example.Exceptions.InsufficientBalance;
import com.example.Exceptions.InsufficientInventory;
import com.example.Exceptions.InvalidDiscount;
import com.example.controller.AdminController;
import com.example.controller.ClientController;
import com.example.model.Roles.ClientModel;
import com.example.model.UserModelFacilities.DiscountModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UltimatePurchaseController implements Initializable {

    @FXML
    private Button btn_Back;

    @FXML
    private Button btn_SeeDiscounts;

    @FXML
    private Button btn_SubmitDiscounts;

    @FXML
    private Button btn_UndoDiscount;

    @FXML
    private Button btn_ultimatePurchase;

    @FXML
    private HBox hBox_Discounts;

    @FXML
    private TreeView<String> treeV_Prices;

    @FXML
    private TextField txt_Discount;

    static private int priceCounter=0;

    static private double [] price;
    @FXML
    void applyDiscount(ActionEvent event) {
        TreeItem<String> main=new TreeItem<String>("Prices");
        ClientController clientController=new ClientController();
        try {
            clientController.ultimatePurchase(LoginPageController.clientName,1);
        } catch (InsufficientBalance e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Insufficient Balance");
            alert.setContentText(e.getMessage());
            alert.show();
        } catch (InsufficientInventory e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("InsufficientInventory");
            alert.setContentText(e.getMessage());
            alert.show();
        } catch (InvalidDiscount e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("InvalidDiscount");
            alert.setContentText(e.getMessage());
            alert.show();
        }


    }

    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("PurchaseOperation.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 858, 750);
        Main.stage.setTitle("Purchase page");
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void seeDiscounts(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SeeDiscounts.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 765, 555);
        Main.stage.setTitle("Your Discount page");
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void ultimatePurchase(ActionEvent event) {
        ClientController clientController=new ClientController();
        try {
            String result=clientController.ultimatePurchase(LoginPageController.clientName,2);
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Purchase Success!!");
            alert.setContentText(result);
            alert.show();
            for(ClientModel clientModel1:AdminController.getClientList())
            {
                if (clientModel1.getUserName().equals(LoginPageController.clientName))
                {
                    clientModel1.getCart().clear();
                }
            }
        } catch (InsufficientBalance e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Insufficient Balance");
            alert.setContentText(e.getMessage());
            alert.show();
        } catch (InsufficientInventory e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("InsufficientInventory");
            alert.setContentText(e.getMessage());
            alert.show();
        } catch (InvalidDiscount e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("InvalidDiscount");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }


    //------------------------------------------------------------------------------------------------
    public DiscountModel enterClientDiscounts()
    {
            String code= txt_Discount.getText();
            for (ClientModel clientModel:AdminController.getClientList()) {

                if (clientModel.getUserName().equals(LoginPageController.clientName))
                {
                    for (DiscountModel discountModel:clientModel.getClientDiscounts())
                    {
                        if (discountModel.getDiscountCode().equals(code))
                        {
                            return discountModel;
                        }
                    }
                    try {
                        throw new InvalidDiscount();
                    } catch (InvalidDiscount e) {
                        Alert alert=new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Discount Error");
                        alert.setTitle(e.getMessage());
                        alert.show();
                    }
                }
            }
        return null;}
        //------------------------------------------------------------------------------------------------
        public int effectOfDiscount(double prePrice,double currentPrice)
        {
            TreeItem<String> main=new TreeItem<String>("Prices");
            TreeItem<String>item1=new TreeItem<String>("price"+priceCounter+" is "+prePrice);
            price[0]=prePrice;
            priceCounter++;
            TreeItem<String>item2=new TreeItem<String>("price"+priceCounter+" is "+currentPrice);
            price[priceCounter]=currentPrice;
            main.getChildren().add(item1);
            main.getChildren().add(item2);
            treeV_Prices.refresh();
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Continue or not??");
            alert.setContentText("result of discount is available in the table fo you want to continue use the discount on not? (select ok or cancel");
            alert.initModality(Modality.WINDOW_MODAL);
            alert.getButtonTypes().clear();
            alert.getButtonTypes().addAll(ButtonType.YES,ButtonType.NO);
            alert.show();

            int orderNumber=1;
            if (alert.getResult().getButtonData().equals(ButtonBar.ButtonData.NO))
            {
                 orderNumber=2;
            }
            if (alert.getResult().getButtonData().equals(ButtonBar.ButtonData.YES))
            {
                 orderNumber=1;
            }

        return orderNumber; }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        treeV_Prices.setRoot(null);
        TreeItem<String> main=new TreeItem<String>("Prices");
        treeV_Prices.setRoot(main);
        treeV_Prices.refresh();
    }
}
