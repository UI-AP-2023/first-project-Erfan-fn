package controller;

import model.Roles.*;
import model.Stuff.*;
import model.UserModelFacilities.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientController {
    public String signUp(String userName, String email, String phoneNumber, String password) {
        Pattern pattern = Pattern.compile("^\\D{5}(\\d{3})+(@gmail|@yahoo)\\.com$");
        Matcher matcher = pattern.matcher(email);
        Pattern pattern1 = Pattern.compile("^09\\d{9}$");
        Matcher matcher1 = pattern1.matcher(phoneNumber);
        Pattern pattern2 = Pattern.compile("(\\S){8,}");
        Pattern pattern20 = Pattern.compile("[a-z]+");
        Pattern pattern21 = Pattern.compile("[A-Z]+");
        Pattern pattern22 = Pattern.compile("[0-9]+");
        Matcher matcher2 = pattern2.matcher(password);
        Matcher matcher20 = pattern20.matcher(password);
        Matcher matcher21 = pattern21.matcher(password);
        Matcher matcher22 = pattern22.matcher(password);
        if (matcher.find() == true && matcher1.find() == true && matcher2.find() == true && matcher20.find() == true && matcher21.find() == true && matcher22.find() == true) {
            for (ClientModel clientModel : AdminController.getClientList()) {
                if (userName.equals(clientModel.getUserName())) {
                    return "This userName has been taken";
                }
            }
            for (ClientModel clientModel : AdminController.getClientList()) {
                if (phoneNumber.equals(clientModel.getPhoneNumber())) {
                    return "This phoneNumber has been taken";
                }
            }
            for (ClientModel clientModel : AdminController.getClientList()) {
                if (email.equals(clientModel.getEmail())) {
                    return "This email has been taken";
                }
            }
            AdminController.getAllRequestList().add("SignUpRequest: " + userName +
                    " " + email + " " + phoneNumber + " " + password);
            return "SignUpRequest: " + userName +
                    " " + email + " " + phoneNumber + " " + password;
        }

        return "Invalid information";
    }

    public String signIn(String userName, String password) {
        for (ClientModel clientModel : AdminController.getClientList()) {
            if (userName.equals(clientModel.getUserName()) && password.equals(clientModel.getPassword())) {
                return userName;
            }
        }
        return "failed to login";
    }

    public int editPassword(String userName,String password) {
        Pattern pattern2 = Pattern.compile("(\\S){8,}");
        Pattern pattern20 = Pattern.compile("[a-z]+");
        Pattern pattern21 = Pattern.compile("[A-Z]+");
        Pattern pattern22 = Pattern.compile("[0-9]+");
        Matcher matcher2 = pattern2.matcher(password);
        Matcher matcher20 = pattern20.matcher(password);
        Matcher matcher21 = pattern21.matcher(password);
        Matcher matcher22 = pattern22.matcher(password);
        if (matcher2.find() && matcher20.find() && matcher21.find() && matcher22.find()) {
            for (ClientModel clientModel:AdminController.getClientList())
            {
                if (clientModel.getUserName().equals(userName))
                {
                    if (clientModel.getPassword()!=password)
                    {clientModel.setPassword(password);
                    return 1;}
                }
            }
        }
        return 0;
    }

    public int editEmail(String userName,String email) {
        Pattern pattern = Pattern.compile("^\\D{5}(\\d{3})+(@gmail|@yahoo)\\.com$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()) {
            for (ClientModel clientModel : AdminController.getClientList()) {
                if (clientModel.getUserName().equals(userName)) {
                    if (clientModel.getEmail()!=email)
                    {clientModel.setEmail(email);
                    return 1;}
                }
            }
        }
        return 0;
    }

    public int editPhoneNumber(String userName,String phoneNumber) {
        Pattern pattern1 = Pattern.compile("^09\\d{9}$");
        Matcher matcher1 = pattern1.matcher(phoneNumber);
        if (matcher1.find()) {
            for (ClientModel clientModel : AdminController.getClientList()) {
                if (clientModel.getUserName().equals(userName)) {
                    if (clientModel.getPhoneNumber()!=phoneNumber)
                    {
                        clientModel.setPhoneNumber(phoneNumber);
                    return 1;}
                }
            }
        }
        return 0;
    }

    public int rateToStuff(int score, String userName, int stuffCode) {
        for (ClientModel clientModel : AdminController.getClientList()) {
            if (clientModel.getUserName().equals(userName)) {
                int scoreSum=0,scoreNumbers=0;
                for (PurchaseInvoiceModel purchaseInvoiceModel : clientModel.getClientInvoicesList()) {
                    for (StuffModel stuffModel : purchaseInvoiceModel.getPurchasedStuffsList()) {
                        if (stuffModel.getStuffId() == stuffCode) {
                            ScoreModel scoreModel=new ScoreModel(clientModel,score,stuffModel);
                            AdminController.getAllScores().add(scoreModel);
                            for (ScoreModel scoreModel1:AdminController.getAllScores())
                            {
                                if (scoreModel1.getStuffModel().getStuffId()==stuffCode)
                                {
                                    scoreSum+=scoreModel1.getScoreNumber();
                                    scoreNumbers++;
                                }
                            }
                            stuffModel.setAverageScore(scoreSum/scoreNumbers);
                       return 1; }
                    }
                }
            }
        }
   return 0; }

    public String accountChargeRequest(String userName, String cardNumber, String cvv2, String password,double chargeAmount) {
        Pattern pattern = Pattern.compile("^\\d{16}$");
        Matcher matcher = pattern.matcher(cardNumber);
        Pattern pattern1 = Pattern.compile("^\\d{3,4}$");
        Matcher matcher1 = pattern1.matcher(cvv2);
        Pattern pattern2 = Pattern.compile("^\\d{7}$");
        Matcher matcher2 = pattern2.matcher(password);
        for (ClientModel clientModel : AdminController.getClientList()) {
            if (clientModel.getUserName().equals(userName)) {
                if (matcher.find() && matcher1.find() && matcher2.find()) {
                    AdminController.getAllRequestList().add("accountChargeRequest: "+userName+" "+chargeAmount);
                    return "accountChargeRequest: " + userName+" "+chargeAmount;
                }
            }
        }
        return "An error acquired";
    }

    public int addStuffToCart(String userName, int stuffCode,int number) {
        int num=0;
        for (ClientModel clientModel : AdminController.getClientList())
        {
            if (clientModel.getUserName().equals(userName))
            {
              for (StuffModel stuffModel:AdminModel.getAdminModel().getStuffList())
              {
                  if (stuffModel.getStuffId()==stuffCode)
                  {
                      for (int i=0 ; i<number ;i++)
                      {
                          if (stuffModel.getStuffInventory()>num)
                          {
                              clientModel.getCart().add(stuffModel);
                               num++;
                          }
                      }
                  if (num==0){return 0;}
                  if (num!=0){return 1;}
                  }
              }
            }
        }
        return 0;}

    public int removeStuffFromCart(String userName, int stuffCode)
    {
        for (ClientModel clientModel : AdminController.getClientList())
        {
            if(clientModel.getUserName().equals(userName))
            {
                for (StuffModel stuffModel:clientModel.getCart())
                {
                    if (stuffModel.getStuffId()==stuffCode)
                    {
                        clientModel.getCart().remove(stuffModel);
                        return 1;
                    }
                }
            }
        }
    return 0;}

    public String writeComment(String userName,int stuffCode,String commentText)
    {
     for (ClientModel clientModel:AdminController.getClientList())
     {
         if (clientModel.getUserName().equals(userName))
         {
             for (PurchaseInvoiceModel purchaseInvoiceModel:clientModel.getClientInvoicesList()) {
                 for (StuffModel stuffModel:AdminModel.getAdminModel().getStuffList())
                 {
                     if(stuffModel.getStuffId()==stuffCode)
                     {
                         CommentModel commentModel=new CommentModel(stuffCode,commentText,clientModel);
                         commentModel.setBuy(true);
                         AdminController.getAllRequestList().add("commentRequest: "+commentModel.toString());
                         return "commentRequest: "+commentModel.toString();
                     }
                 }
             }
                 for (StuffModel stuffModel:AdminModel.getAdminModel().getStuffList())
                 {
                     if(stuffModel.getStuffId()==stuffCode)
                     {
                         CommentModel commentModel=new CommentModel(stuffCode,commentText,clientModel);
                         commentModel.setBuy(false);
                         AdminController.getAllRequestList().add("commentRequest: "+commentModel.toString());
                     return "commentRequest "+commentModel.toString();
                     }
                 }
         }
     }
    return "comment request failed";}
    public String ultimatePurchase(String userName)
    {  double sumOfStuffPrices=0;
        for (ClientModel clientModel:AdminController.getClientList())
        {
            if(clientModel.getUserName().equals(userName))
            {
                for(StuffModel stuffModel: clientModel.getCart())
                {
                    sumOfStuffPrices+=stuffModel.getStuffPrice();
                }
                if (clientModel.getAccountCredit()>=sumOfStuffPrices)
                {    PurchaseInvoiceModel purchaseInvoiceModel=new PurchaseInvoiceModel("1402/01/15",sumOfStuffPrices);
                    for(StuffModel stuffModel: clientModel.getCart())
                {
                    purchaseInvoiceModel.getPurchasedStuffsList().add(stuffModel);
                    stuffModel.setStuffInventory(stuffModel.getStuffInventory()-1);

                }
                    clientModel.setAccountCredit(clientModel.getAccountCredit()-sumOfStuffPrices);
                    clientModel.getClientInvoicesList().add(purchaseInvoiceModel);
                    for(StuffModel stuffModel1: purchaseInvoiceModel.getPurchasedStuffsList())
                    {
                       clientModel.getCart().remove(stuffModel1);

                    }


                return "purchase was successful";}
            }
        }
    return "purchase wasn't successful";}

    }
