package model.UserModelFacilities;

import model.Roles.ClientModel;

public class CommentModel {
    private ClientModel clientModel;
    private final int StuffID;
    private String commentText;
    private CommentStatusModel commentStatusModel;
    private boolean buy;
    CommentModel(int StuffID,String commentText,ClientModel clientModel)
    {
        this.StuffID=StuffID;
        this.commentText=commentText;
        this.clientModel=clientModel;
        commentStatusModel=CommentStatusModel.WAITINGFORACCEPT;
    }

    public ClientModel getClientModel() {
        return clientModel;
    }

    public boolean isBuy() {
        return buy;
    }

    public CommentStatusModel getCommentStatusModel() {
        return commentStatusModel;
    }

    public int getStuffID() {
        return StuffID;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }

    public void setCommentStatusModel(CommentStatusModel commentStatusModel) {
        this.commentStatusModel = commentStatusModel;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

}
