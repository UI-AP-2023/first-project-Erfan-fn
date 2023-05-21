package model.Roles;

import model.Stuff.StuffModel;
import model.UserModelFacilities.PurchaseInvoiceModel;

import java.util.ArrayList;

public class ClientModel extends UserModel {
    private double accountCredit;
    private ArrayList<StuffModel>cart;
    private ArrayList<PurchaseInvoiceModel>clientInvoicesList;
    public ClientModel(String userName,String email,String phoneNumber,String password)
    {
        super(userName, password, phoneNumber, email);
        cart=new ArrayList<>();
        clientInvoicesList=new ArrayList<>();
    }

    public ArrayList<PurchaseInvoiceModel> getClientInvoicesList() {
        return clientInvoicesList;
    }

    public ArrayList<StuffModel> getCart() {
        return cart;
    }

    public double getAccountCredit() {
        return accountCredit;
    }

    public void setAccountCredit(double accountCredit) {
        this.accountCredit = accountCredit;
    }

    @Override
    public String toString() {
        return super.toString()+
                " accountCredit=" + accountCredit
                ;
    }
}
