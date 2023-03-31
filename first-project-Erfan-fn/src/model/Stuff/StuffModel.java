package model.Stuff;

import model.UserModelFacilities.CommentModel;

import java.util.ArrayList;

public abstract class  StuffModel {
    private static int stuffCode=-1;
    private String stuffName;
    private double stuffPrice;
    private int stuffInventory;
    private double averageScore;
    private StuffKindModel stuffKindModel;
    private ArrayList<CommentModel>stuffComments;
    StuffModel(String stuffName,double stuffPrice,int stuffInventory,StuffKindModel stuffKindModel)
    {   stuffCode++;
        this.stuffName=stuffName;
        this.stuffKindModel=stuffKindModel;
        this.stuffInventory=stuffInventory;
        this.stuffPrice=stuffPrice;
    }

    public ArrayList<CommentModel> getStuffComments() {
        return stuffComments;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public double getStuffPrice() {
        return stuffPrice;
    }

    public static int getStuffCode() {
        return stuffCode;
    }

    public int getStuffInventory() {
        return stuffInventory;
    }

    public String getStuffName() {
        return stuffName;
    }

    public StuffKindModel getStuffKindModel() {
        return stuffKindModel;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public void setStuffComments(ArrayList<CommentModel> stuffComments) {
        this.stuffComments = stuffComments;
    }

    public void setStuffInventory(int stuffInventory) {
        this.stuffInventory = stuffInventory;
    }

    public void setStuffPrice(double stuffPrice) {
        this.stuffPrice = stuffPrice;
    }

    public void setStuffName(String stuffName) {
        this.stuffName = stuffName;
    }

    public static void setStuffCode(int stuffCode) {
        StuffModel.stuffCode = stuffCode;
    }
}
