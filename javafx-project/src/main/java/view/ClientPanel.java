package view;

import controller.AdminController;
import controller.ClientController;
import model.Roles.AdminModel;
import model.Roles.ClientModel;
import model.Stuff.*;
import model.UserModelFacilities.CommentModel;
import model.UserModelFacilities.PurchaseInvoiceModel;

import java.util.Scanner;

public class ClientPanel {
    Scanner sc = new Scanner(System.in);
    ClientController clientController = new ClientController();

    public int signUp() {
        System.out.println("This page means you are going to sign up" + '\n' + "enter your  userName(must be unique), email(must be like eeeee123(@gmail.com or @yahoo.com)), phoneNumber(must be 11number and start with 09), password(must be at least 8 character that has number,uppercase and lowercase)");
        System.out.println("enter your Username:");
        String userName = sc.nextLine();
        System.out.println("enter your email:");
        String email = sc.nextLine();
        System.out.println("enter your phoneNumber:");
        String phoneNumber = sc.nextLine();
        System.out.println("enter your password:");
        String password = sc.nextLine();
        String result = clientController.signUp(userName, email, phoneNumber, password);
        System.out.println(result);
        if (result.contains("Sign")) {
            return 1;
        }
        return 0;
    }

    public String login() {
        System.out.println("This page is login page:    1_login as client   2_login as admin ");
        int orderNum = sc.nextInt();
        sc.nextLine();
        if (orderNum == 1) {
            System.out.println("enter userName:");
            String orderString = sc.nextLine();
            System.out.println("enter password:");
            String orderString1 = sc.nextLine();
            if (orderString.equals("admin") || orderString1.equals("admin")) {
                return "failed to login";
            }
            String resultString;
            resultString = clientController.signIn(orderString, orderString1);
            return resultString;

        }
        if (orderNum == 2) {
            System.out.println("enter userName:");
            String orderString = sc.nextLine();
            System.out.println("enter password:");
            String orderString1 = sc.nextLine();
            if (orderString.equals("admin") && orderString1.equals("admin")) {
                return "admin";
            }
        }
        return "failed to login";
    }

    public String editInformation(String userName) {
        for (ClientModel clientModel : AdminController.getClientList()) {
            if (clientModel.getUserName().equals(userName)) {
                System.out.println(clientModel.toString());
            }
        }
        System.out.println("1_edit password    2_edit email   3_edit phoneNumber  4_back");
        int orderNum0 = sc.nextInt();
        sc.nextLine();
        if (orderNum0 == 1) {
            int result = 0;
            do {
                System.out.println("1_enter new password  2_back");
                int orderNumber=sc.nextInt();
                sc.nextLine();
                if (orderNumber==2){break;}
                String password = sc.nextLine();
                result = clientController.editPassword(userName, password);
            } while (result == 0);
            return "password changed";
        }
        if (orderNum0 == 2) {
            int result = 0;
            do {
                System.out.println("1_enter new email  2_back");
                int orderNumber=sc.nextInt();
                sc.nextLine();
                if (orderNumber==2){break;}
                String email = sc.nextLine();
                result = clientController.editEmail(userName, email);
            } while (result == 0);
            return "email changed";
        }
        if (orderNum0 == 3) {
            int result = 0;
            do {
                System.out.println("1_enter new phoneNumber  2_back");
                int orderNumber=sc.nextInt();
                sc.nextLine();
                if (orderNumber==2){break;}
                String phoneNumber = sc.nextLine();
                result = clientController.editPhoneNumber(userName, phoneNumber);
            } while (result == 0);
            return "phoneNumber changed";
        }
       if (orderNum0==4){return "nothing changed";}
        return "nothing changed";
    }

    public int seeShopStuff() {
        for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
            System.out.println(stuffModel.toString());
        }
        while (true) {
            System.out.println("1_go to a stuff page with id code \n 2_back to clientMenu \n 3_filter by \n 4_search \n 5_show all stuff");
            int decision = sc.nextInt();
            sc.nextLine();

            if (decision == 1) {
                System.out.println("enter stuff id:");
                int id = sc.nextInt();
                sc.nextLine();
                for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                    if (stuffModel.getStuffId() == id) {
                        System.out.println(stuffModel.toString() + " averageScore" + stuffModel.getAverageScore());
                        if (stuffModel.getStuffComments()!=null)
                        {for (CommentModel commentModel : stuffModel.getStuffComments()) {
                            System.out.println(commentModel.getCommentText());
                        }}
                        System.out.println("1_do more if you are signed in");
                        int decision1 = sc.nextInt();
                        sc.nextLine();
                        if (decision1 == 1) {
                            return 1;
                        }
                    }
                }
            }
            if (decision==5)
            {
                for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                    System.out.println(stuffModel.toString());
                }
            }

            if (decision == 2) {
                return 0;
            }
            if (decision == 4) {
                System.out.println("enter the stuffName to search for it in shop");
                String searchString= sc.nextLine();
                for (StuffModel stuffModel:AdminModel.getAdminModel().getStuffList())
                {
                    if (stuffModel.getStuffName().contains(searchString))
                    {
                        System.out.println(stuffModel.toString());
                    }
                }
            }
            if (decision == 3) {
                System.out.println("filter options(please type):\n (by StuffKind) 1_model.Stuff.BicycleModel  2_model.Stuff.CarModel  3_DigitalStuffModel  4_model.Stuff.FlashMemoryModel  5_model.Stuff.FoodModel  6_model.Stuff.NoteBookModel \n" +
                        "7_model.Stuff.PencilModel  8_model.Stuff.PersonalComputerModel  9_model.Stuff.SsdModel  10_StationeryModel  11_StorageEquipmentModel  12_VehicleModel" +
                        "\n (by stuffProperty) 1_StuffPrice  2_Is Stuff available  3_averageScore" +
                        "\n 4_CarCompanyName  5_StorageEquipment capacity  6_Pc cpu model  7_pc ram capacity 8_penColor ");
                String orderString = sc.nextLine();
                if (orderString.equals("model.Stuff.BicycleModel") || orderString.equals("model.Stuff.CarModel") || orderString.equals("model.Stuff.FlashMemoryModel") ||
                        orderString.equals("model.Stuff.FoodModel") || orderString.equals("model.Stuff.NoteBookModel") || orderString.equals("model.Stuff.PencilModel") || orderString.equals("model.Stuff.PersonalComputerModel") ||
                        orderString.equals("model.Stuff.SsdModel")) {
                    for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                        if (stuffModel.getClass().getName().equals(orderString)) {
                            System.out.println(stuffModel.toString());
                        }
                    }
                }
                if (orderString.equals("DigitalStuffModel")) {
                    for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                        if (stuffModel instanceof DigitalStuffModel) {
                            System.out.println(stuffModel.toString());
                        }
                    }
                }
                if (orderString.equals("StationeryModel")) {
                    for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                        if (stuffModel instanceof StationeryModel) {
                            System.out.println(stuffModel.toString());
                        }
                    }
                }
                if (orderString.equals("StorageEquipmentModel")) {
                    for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                        if (stuffModel instanceof StorageEquipmentModel) {
                            System.out.println(stuffModel.toString());
                        }
                    }
                }
                if (orderString.equals("VehicleModel")) {
                    for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                        if (stuffModel instanceof VehicleModel) {
                            System.out.println(stuffModel.toString());
                        }
                    }
                }
                if (orderString.equals("StuffPrice")) {
                    System.out.println("enter minimum price:");
                    double minimumPrice = sc.nextDouble();
                    System.out.println("enter maximum price:");
                    double maximumPrice = sc.nextDouble();
                    sc.nextLine();
                    for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                        if (minimumPrice <= stuffModel.getStuffPrice() && maximumPrice >= stuffModel.getStuffPrice()) {
                            System.out.println(stuffModel.toString());
                        }
                    }
                }
                if (orderString.equals("averageScore")) {
                    System.out.println("enter minimum score:");
                    int minimumScore = sc.nextInt();
                    System.out.println("enter maximum score:");
                    int maximumScore = sc.nextInt();
                    sc.nextLine();
                    for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                        if (minimumScore <= stuffModel.getAverageScore() && maximumScore >= stuffModel.getAverageScore()) {
                            System.out.println(stuffModel.toString());
                        }
                    }
                }
                if (orderString.equals("Is Stuff available")) {
                    for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                        if (stuffModel.getStuffInventory() > 0) {
                            System.out.println(stuffModel.toString());
                        }
                    }
                }
                if (orderString.equals("CarCompanyName")) {
                    System.out.println("enter car company name to filter stuff");
                    String orderString1 = sc.nextLine();
                    for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                        if (stuffModel instanceof CarModel) {
                            if (((CarModel) stuffModel).getCompanyName().equals(orderString1)) {
                                System.out.println(stuffModel.toString());
                            }
                        }
                    }
                }
                if (orderString.equals("StorageEquipment capacity")) {
                    System.out.println("enter a capacity");
                    int orderString1 = sc.nextInt();
                    sc.nextLine();
                    for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                        if (stuffModel instanceof StorageEquipmentModel) {
                            if (((StorageEquipmentModel) stuffModel).getCapacity() == orderString1) {
                                System.out.println(stuffModel.toString());
                            }
                        }
                    }
                }
                if (orderString.equals("Pc cpu model")) {
                    System.out.println("enter a cpu model");
                    String orderString1 = sc.nextLine();
                    for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                        if (stuffModel instanceof PersonalComputerModel) {
                            if (((PersonalComputerModel) stuffModel).getCpuModel().equals(orderString1)) {
                                System.out.println(stuffModel.toString());
                            }
                        }
                    }
                }
                if (orderString.equals("pc ram capacity")) {
                    System.out.println("enter a ram capacity");
                    int orderString1 = sc.nextInt();
                    sc.nextLine();
                    for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                        if (stuffModel instanceof PersonalComputerModel) {
                            if (((PersonalComputerModel) stuffModel).getRamCapacity() == orderString1) {
                                System.out.println(stuffModel.toString());
                            }
                        }
                    }
                }
                if (orderString.equals("penColor")) {
                    System.out.println("enter a Color");
                    String orderString1 = sc.nextLine();
                    for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                        if (stuffModel instanceof PenModel) {
                            if (((PenModel) stuffModel).getColor().equals(orderString1)) {
                                System.out.println(stuffModel.toString());
                            }
                        }
                    }
                }
            }


        }

    }

    public String purchaseOperation(String userName) {
        for (ClientModel clientModel : AdminController.getClientList()) {
            if (clientModel.getUserName().equals(userName)) {
                for (StuffModel stuffModel : clientModel.getCart()) {
                    System.out.println(stuffModel.toString());
                }}
                System.out.println("Do you wanna to ultimate your purchase?\n 1_yes  2_No");
                int orderNumber = sc.nextInt();
                sc.nextLine();
                if (orderNumber == 1) {
                    String resultString;
                    resultString = clientController.ultimatePurchase(userName);
                    for(ClientModel clientModel1:AdminController.getClientList())
                    {
                        if (clientModel1.getUserName().equals(userName))
                        {
                            clientModel1.getCart().clear();
                        }
                    }
                    return resultString;
                }
                if (orderNumber == 2) {
                    return "back to Menu";
                }
            }

        return "back to Menu";
    }

    public String chargeAccount(String userName) {
        System.out.println("enter the amount of chargeRequest:");
        int amount = sc.nextInt();
        sc.nextLine();
        System.out.println("enter your cardNumber:");
        String cardNumber = sc.nextLine();
        System.out.println("enter your cvv2:");
        String cvv2 = sc.nextLine();
        System.out.println("enter your password:");
        String password = sc.nextLine();
        String resultString3;
        resultString3 = clientController.accountChargeRequest(userName, cardNumber, cvv2, password, amount);
        if (resultString3 != "An error acquired") {
            return resultString3;
        }
        return "An error acquired";
    }
    public void addStuffToCart(String userName)
    {
        System.out.println("enter stuffId:");
        int orderNumber0= sc.nextInt();
        System.out.println("enter stuff number:");
        int orderNumber00= sc.nextInt();
        int resultNumber=clientController.addStuffToCart(userName,orderNumber0,orderNumber00);
        if (resultNumber==1)
        {
            System.out.println(" stuff added to cart");
        }
        if (resultNumber==0)
        {
            System.out.println(" stuff not added to cart");
        }

    }
    public void removeStuffFromCart(String userName)
    {
        System.out.println("enter stuffId");
        int orderNumber0= sc.nextInt();
        int resultNumber=clientController.removeStuffFromCart(userName,orderNumber0);
        if (resultNumber==1)
        {
            System.out.println(" stuff removed from cart");
        }
        if (resultNumber==0)
        {
            System.out.println(" stuff not removed from cart");
        }

    }
    public void rateToStuff(String userName)
    {
        System.out.println("enter Id of stuff that you want to rate it:(only if you purchase that stuff)");
        int stuffIdForRate= sc.nextInt();
        System.out.println("enter the score:");
        int stuffScore= sc.nextInt();
        sc.nextLine();
        int resultOfRate=clientController.rateToStuff(stuffScore,userName,stuffIdForRate);
        if (resultOfRate==1)
        {
            System.out.println("thanks for rating");
        }
        if (resultOfRate==0)
        {
            System.out.println("you are not allowed to rate for this stuff");
        }

    }

    public  void writeComment(String userName)
    {
        System.out.println("enter the stuff Id you want to write a comment about:");
        int stuffIdForComment= sc.nextInt();
        sc.nextLine();
        System.out.println("enter the comment text");
        String commentText= sc.nextLine();
        String resultCheck =clientController.writeComment(userName,stuffIdForComment,commentText);
        System.out.println(resultCheck);
    }
    public void showBuyHistory(String userName)
    {
        for (ClientModel clientModel:AdminController.getClientList())
        {
            if (clientModel.getUserName().equals(userName))
            {
                for (PurchaseInvoiceModel purchaseInvoiceModel:clientModel.getClientInvoicesList())
                {
                    System.out.println(purchaseInvoiceModel.toString());
                    for (StuffModel stuffModel: purchaseInvoiceModel.getPurchasedStuffsList())
                    {
                        System.out.println(stuffModel.toString());
                    }
                }
            }
        }
    }


}
