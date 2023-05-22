package view;

import controller.AdminController;
import model.Roles.AdminModel;
import model.Stuff.StuffModel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminPanel {
    Scanner sc=new Scanner(System.in);
    AdminController adminController=new AdminController();
    public void adminOperations()
    {
        while (true) {

            System.out.println("Type your command or type word 'back' for going back to main menu:");
            try {
                String command = sc.nextLine();
                String array[] = command.split(" ");
                if (array[0].equals("addStuff")) {
                    int resultNum = adminController.addStuff(command);
                    if (resultNum ==1)
                    {
                        System.out.println("stuff added to stuffList");
                    }
                    if (resultNum ==0)
                    {
                        System.out.println("stuff not added to stuffList");
                    }
                }
                if(array[0].equals("ShowRequestsList"))
                {  int index=-1;
                    for (String string:AdminController.getAllRequestList())
                    {   index++;
                        System.out.println(index+"_"+string);
                    }
                }
                if (array[0].equals("acceptOrRejectRequests"))
                {   String resultString;
                    resultString=adminController.acceptOrRejectRequests(Integer.parseInt(array[1]),Integer.parseInt(array[2]));
                    System.out.println(resultString);
                }
                if(array[0].equals("showStuffList"))
                {
                    showStuffList();
                }
                if(array[0].equals("editStuffName"))
                {
                    int resNumb=adminController.editStuffName(Integer.parseInt(array[1]),array[2]);
                    if (resNumb==1)
                    {
                        System.out.println("stuffNAme edited");
                    }
                    if (resNumb==0)
                    {
                        System.out.println("stuffNAme does not edited");
                    }
                }
                if(array[0].equals("editStuffInventory"))
                {
                    int resNumb=adminController.editStuffInventory(Integer.parseInt(array[1]),Integer.parseInt(array[2]));
                    if (resNumb==1)
                    {
                        System.out.println("stuffInventory edited");
                    }
                    if (resNumb==0)
                    {
                        System.out.println("stuffInventory does not edited");
                    }
                }
                if(array[0].equals("editStuffPrice"))
                {
                    int resNumb=adminController.editStuffPrice(Integer.parseInt(array[1]),Double.parseDouble(array[2]));
                    if (resNumb==1)
                    {
                        System.out.println("stuffPrice edited");
                    }
                    if (resNumb==0)
                    {
                        System.out.println("stuffPrice does not edited");
                    }
                }
                if(array[0].equals("removeStuff"))
                {
                    int resNumb=adminController.removeStuff(Integer.parseInt(array[1]));
                    if (resNumb==1)
                    {
                        System.out.println("stuff removed");
                    }
                    if (resNumb==0)
                    {
                        System.out.println("stuffPrice does not removed");
                    }
                }
                if(array[0].equals("help"))
                {
                    System.out.println("admin orders list: "+"1_addStuff(String stuffInformation)   "+"2_ShowRequestsList    "+"3_acceptOrRejectRequests(int index,int orderNumber)    "+"4_showStuffList    "+"\n5_editStuffName(int stuffId,String name)    "
                            +"6_editStuffInventory(int stuffId,int inventory)   "+"7_editStuffPrice(int stuffId,double price)    "+"\n8_removeStuff(int stuffId    "+"9_ShowClientsPurchaseStatus      "+"10_GiveDiscountToClients(String name,String category(double discountPercent, LocalDate discountExpiration, int discountCapacity(seperated by space)))     "+"11_help   "+"12_back ");
                }
                if(array[0].equals("back"))
                {
                    break;
                }
                if (array[0].equals("ShowClientsPurchaseStatus"))
                {
                    showClientsPurchaseStatus();
                }
                if (array[0].equals("GiveDiscountToClients"))
                {
                    System.out.println("enter name:");
                    String name=sc.nextLine();
                    System.out.println("enter Discount category:");
                    String category=sc.nextLine();
                    String result;
                    result=adminController.giveClientsDiscount(name,category);
                    System.out.println(result);
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println(e.getMessage());
                  adminOperations();
            }
        }
    }
    public void showStuffList()
    {
        for (StuffModel stuffModel: AdminModel.getAdminModel().getStuffList())
        {
            System.out.println(stuffModel.toString());
        }
    }
    public void showClientsPurchaseStatus()
    {
        System.out.println(adminController.showClientsPurchaseNumber());
    }
}
