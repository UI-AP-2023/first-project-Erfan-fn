package model.UserModelFacilities;

import model.Stuff.StuffModel;
import java.util.ArrayList;

public class PurchaseInvoiceModel {
    private static int purchaseInvoiceId=-1;
    private String purchaseDate;
    private double paidPrice;
    private ArrayList<StuffModel>purchasedStuffsList;

    PurchaseInvoiceModel(String purchaseDate,double paidPrice,ArrayList<StuffModel>purchasedStuffsList)
    {
        purchaseInvoiceId++;
        this.paidPrice=paidPrice;
        this.purchaseDate=purchaseDate;
        this.purchasedStuffsList=purchasedStuffsList;
    }

    public ArrayList<StuffModel> getPurchasedStuffsList() {
        return purchasedStuffsList;
    }

    public double getPaidPrice() {
        return paidPrice;
    }

    public static int getPurchaseInvoiceId() {
        return purchaseInvoiceId;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPaidPrice(double paidPrice) {
        this.paidPrice = paidPrice;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setPurchasedStuffsList(ArrayList<StuffModel> purchasedStuffsList) {
        this.purchasedStuffsList = purchasedStuffsList;
    }
}
