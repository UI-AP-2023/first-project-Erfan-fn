package view;

import java.util.Scanner;

public class MainPanel {
    ClientPanel clientPanel = new ClientPanel();
    Scanner sc = new Scanner(System.in);

    public void startPanel() {
        while (true) {
            System.out.println("welcome to Erf Online Shop select options by enter number" + '\n' + "1_sign up page" + '\n' + "2_login page and client page" + '\n' + "3_Stuffs page");
            int orderNum = sc.nextInt();
            sc.nextLine();
            if (orderNum == 1) {
                int orderNum1 = 0;
                do {
                    orderNum1 = clientPanel.signUp();
                } while (orderNum1 == 0);

            }

            if (orderNum == 2) {
                String result;
                do {
                    result = clientPanel.login();
                } while (result.equals("failed to login"));
                if (result != "admin") {
                    while (true) {
                        System.out.println(result + " welcome to your panel here are some efforts that you can do" + "\n 1_see your personal information and edit" +
                                "\n 2_see shop stuffs" + "\n 3_see stuffs/your cart/purchase operation/rate to your cart Stuffs \n 4_charge account \n 5_see buy history \n 6_back to main menu ");
                        int orderNum2 = sc.nextInt();
                        sc.nextLine();
                        if (orderNum2 == 1) {
                            String result1 = clientPanel.editInformation(result);
                            System.out.println(result1);
                        }
                        if (orderNum2 == 2) {
                            clientPanel.seeShopStuff();
                        }
                        if (orderNum2 == 3) {
                            int resultNumber;
                            resultNumber = clientPanel.seeShopStuff();
                            if (resultNumber == 1) {
                                System.out.println("1_addStuff to cart  2_removeStuff from cart  3_ultimatePurchase 4_rate to your cart Stuffs  5_write a comment  6_back");
                                int resultNumber2=sc.nextInt();
                                if (resultNumber2==1){
                                    clientPanel.addStuffToCart(result);}
                                if (resultNumber2==2){
                                    clientPanel.removeStuffFromCart(result);}
                                if (resultNumber2==3)
                                {clientPanel.purchaseOperation(result);}
                                if (resultNumber2==4)
                                {
                                 clientPanel.rateToStuff(result);
                                }
                                if (resultNumber2==5)
                                {
                                 clientPanel.writeComment(result);
                                }
                            }
                        }
                        if (orderNum2 == 4) {
                         String charge=clientPanel.chargeAccount(result);
                            System.out.println(charge);
                        }
                        if (orderNum2 == 5) {
                         clientPanel.showBuyHistory(result);
                        }
                        if (orderNum2 == 6) {
                         break;
                        }
                    }
                }
                ///////admin
                if (result.equals("admin")) {
                    AdminPanel adminPanel = new AdminPanel();
                    adminPanel.adminOperations();
                }

            }

            if (orderNum == 3) {
clientPanel.seeShopStuff();

            }

        }
    }
}
