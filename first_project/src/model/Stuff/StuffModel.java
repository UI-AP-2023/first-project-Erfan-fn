package model.Stuff;

import model.UserModelFacilities.CommentModel;

import java.util.ArrayList;

public abstract class  StuffModel {
    private static int stuffCode=-1;
    private int stuffId=0;
    private String stuffName;
    private double stuffPrice;
    private int stuffInventory;
    private double averageScore;
    private final StuffKindModel stuffKindModel;
    private ArrayList<CommentModel>stuffComments;
    public StuffModel(String stuffName,double stuffPrice,int stuffInventory,StuffKindModel stuffKindModel)
    {   stuffCode++;
        this.stuffId=stuffCode;
        this.stuffName=stuffName;
        this.stuffKindModel=stuffKindModel;
        this.stuffInventory=stuffInventory;
        this.stuffPrice=stuffPrice;
        stuffComments=new ArrayList<>();
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

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public int getStuffId() {
        return stuffId;
    }

    @Override
    public String toString() {
        return
                "stuffName='" + stuffName + '\'' +
                ", stuffPrice=" + stuffPrice +
                        ", stuffId=" + stuffId +
                ", stuffInventory=" + stuffInventory +
                ", stuffKind=" + stuffKindModel+
                        "average score:"+averageScore
                ;
    }

}
