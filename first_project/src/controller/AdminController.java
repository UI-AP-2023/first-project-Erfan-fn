package controller;

import model.Roles.AdminModel;
import model.Roles.ClientModel;
import model.Stuff.*;
import model.UserModelFacilities.CommentModel;
import model.UserModelFacilities.ScoreModel;

import java.util.ArrayList;

public class AdminController {
    private static ArrayList<ClientModel> clientList=new ArrayList<>();
    private static ArrayList<String> AllRequestList=new ArrayList<>();
    private static ArrayList<ScoreModel>AllScores=new ArrayList<>();


    public static ArrayList<ClientModel> getClientList() {
        return clientList;
    }

    public static ArrayList<String> getAllRequestList() {
        return AllRequestList;
    }

    public static ArrayList<ScoreModel> getAllScores() {
        return AllScores;
    }

    public int addStuff(String stuffInformation) {
        String array[] = stuffInformation.split(" ");
        if (array[1].equals("CarModel")) {
            CarModel carModel = new CarModel(array[2], Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], Integer.parseInt(array[6]), Boolean.parseBoolean(array[7]));
            AdminModel.getAdminModel().getStuffList().add(carModel);
         return 1;}

        if (array[1].equals("BicycleModel")) {
            if (array[6].equals(BicycleKindModel.MOUNTAINOUS)) {
                BicycleModel bicycleModel = new BicycleModel(array[2], Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], BicycleKindModel.MOUNTAINOUS);
            AdminModel.getAdminModel().getStuffList().add(bicycleModel);
            }
            if (array[6].equals(BicycleKindModel.ROAD)) {
                BicycleModel bicycleModel = new BicycleModel(array[2], Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], BicycleKindModel.ROAD);
                AdminModel.getAdminModel().getStuffList().add(bicycleModel);
            }
            if (array[6].equals(BicycleKindModel.HYBRID)) {
                BicycleModel bicycleModel = new BicycleModel(array[2], Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], BicycleKindModel.HYBRID);
                AdminModel.getAdminModel().getStuffList().add(bicycleModel);
            }
            if (array[6].equals(BicycleKindModel.URBAN)) {
                BicycleModel bicycleModel = new BicycleModel(array[2], Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], BicycleKindModel.URBAN);
                AdminModel.getAdminModel().getStuffList().add(bicycleModel);
            }
        return 1;}

        if (array[1].equals("FlashMemoryModel")) {
            FlashMemoryModel flashMemoryModel = new FlashMemoryModel(array[2], Double.parseDouble(array[3]), Integer.parseInt(array[4]),Double.parseDouble(array[5]),array[6],Double.parseDouble(array[7]),array[8]);
            AdminModel.getAdminModel().getStuffList().add(flashMemoryModel);
        return 1;}

        if (array[1].equals("FoodModel")) {
            FoodModel foodModel = new FoodModel(array[2], Double.parseDouble(array[3]), Integer.parseInt(array[4]),array[5],array[6]);
            AdminModel.getAdminModel().getStuffList().add(foodModel);
            return 1;}

        if (array[1].equals("NoteBookModel")) {
            NoteBookModel noteBookModel= new NoteBookModel(array[2], Double.parseDouble(array[3]), Integer.parseInt(array[4]),array[5],Integer.parseInt(array[6]),array[7]);
            AdminModel.getAdminModel().getStuffList().add(noteBookModel);
            return 1;}

        if (array[1].equals("PencilModel")) {
            if (array[6].equals(PencilKindModel.F)) {
                PencilModel pencilModel = new PencilModel(array[2], Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], PencilKindModel.F);
                AdminModel.getAdminModel().getStuffList().add(pencilModel);
                return 1;
            }
            if (array[6].equals(PencilKindModel.H2)) {
                PencilModel pencilModel = new PencilModel(array[2], Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], PencilKindModel.H2);
                AdminModel.getAdminModel().getStuffList().add(pencilModel);
                return 1;
            }
            if (array[6].equals(PencilKindModel.H)) {
                PencilModel pencilModel = new PencilModel(array[2], Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], PencilKindModel.H);
                AdminModel.getAdminModel().getStuffList().add(pencilModel);
                return 1;
            }
            if (array[6].equals(PencilKindModel.B)) {
                PencilModel pencilModel = new PencilModel(array[2], Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], PencilKindModel.B);
                AdminModel.getAdminModel().getStuffList().add(pencilModel);
                return 1;
            }
            if (array[6].equals(PencilKindModel.HB)) {
                PencilModel pencilModel = new PencilModel(array[2], Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], PencilKindModel.HB);
                AdminModel.getAdminModel().getStuffList().add(pencilModel);
                return 1;
            }
        }

            if (array[1].equals("PenModel")) {
                PenModel penModel= new PenModel(array[2], Double.parseDouble(array[3]), Integer.parseInt(array[4]),array[5],array[6]);
                AdminModel.getAdminModel().getStuffList().add(penModel);
                return 1;}

            if (array[1].equals("PersonalComputerModel")) {
                PersonalComputerModel personalComputerModel=new PersonalComputerModel(array[2], Double.parseDouble(array[3]), Integer.parseInt(array[4]),Double.parseDouble(array[5]),array[6],array[7],Integer.parseInt(array[8]));
                AdminModel.getAdminModel().getStuffList().add(personalComputerModel);
                return 1;}
            if (array[1].equals("SsdModel")) {
                SsdModel ssdModel=new SsdModel(array[2], Double.parseDouble(array[3]), Integer.parseInt(array[4]),Double.parseDouble(array[5]),array[6],Double.parseDouble(array[7]),Double.parseDouble(array[8]),Double.parseDouble(array[9]));
                AdminModel.getAdminModel().getStuffList().add(ssdModel);
                return 1;}

    return 0;}
public int editStuffName(int stuffId,String name)
 {
     for (StuffModel stuffModel:AdminModel.getAdminModel().getStuffList())
     {
         if(stuffModel.getStuffId()==stuffId)
         {
             stuffModel.setStuffName(name);
             return 1;
         }
     }
 return 0;}
    public int editStuffInventory(int stuffId,int inventory)
    {
        for (StuffModel stuffModel:AdminModel.getAdminModel().getStuffList())
        {
            if(stuffModel.getStuffId()==stuffId)
            {
                stuffModel.setStuffInventory(inventory);
                return 1;
            }
        }
        return 0;}
   public int editStuffPrice(int stuffId,double price)
    {
        for (StuffModel stuffModel:AdminModel.getAdminModel().getStuffList())
        {
            if(stuffModel.getStuffId()==stuffId)
            {
                stuffModel.setStuffPrice(price);
                return 1;
            }
        }
        return 0;}
    public int removeStuff(int stuffId)
    {
        for (StuffModel stuffModel:AdminModel.getAdminModel().getStuffList())
        {
            if(stuffModel.getStuffId()==stuffId)
            {
                AdminModel.getAdminModel().getStuffList().remove(stuffModel);
                return 1;
            }
        }
    return 0;}
    public String acceptOrRejectRequests(int index,int orderNumber)
    {
     String string=AllRequestList.get(index);
       String array[]=string.split(" ");
       if (array[0].equals("commentRequest:"))
       {
        if (orderNumber==1)
        {
            for (StuffModel stuffModel:AdminModel.getAdminModel().getStuffList())
            {
                if (stuffModel.getStuffId()==Integer.parseInt(array[4]))
                {
                    for (ClientModel clientModel:AdminController.getClientList())
                    {   if(clientModel.getUserName().equals(array[2]))
                    {
                        CommentModel commentModel=new CommentModel(Integer.parseInt(array[4]),array[6],clientModel);
                        stuffModel.getStuffComments().add(commentModel);
                        AllRequestList.remove(AllRequestList.get(index));
                        return index+"_String(comment accepted)";
                    }

                    }
                }
            }
        }
           if (orderNumber==2)
           {
               AllRequestList.remove(AllRequestList.get(index));
               return index+"_String(comment rejected)";
           }
       }
         if (array[0].equals("accountChargeRequest:"))
         {
          if (orderNumber==1)
          {
              for (ClientModel clientModel:AdminController.getClientList())
              {
                  if(clientModel.getUserName().equals(array[1]))
                  {
                      clientModel.setAccountCredit(Double.parseDouble(array[2]));
                      AllRequestList.remove(AllRequestList.get(index));
                  return index+"_String(accountChargeRequest Accepted)";}
              }
          }
             if (orderNumber==2)
             {
                 AllRequestList.remove(AllRequestList.get(index));
                 return index+"_String(accountChargeRequest rejected)";
             }
         }
         if (array[0].equals("SignUpRequest:"))
         {
            if (orderNumber==1)
            {
                ClientModel clientModel=new ClientModel(array[1],array[2],array[3],array[4]);
                AdminController.getClientList().add(clientModel);
                AllRequestList.remove(AllRequestList.get(index));
                return index+"_String(SignUpRequest accepted)";
            }
             if (orderNumber==2)
             {
                 AllRequestList.remove(AllRequestList.get(index));
                 return index+"_String(SignUpRequest rejected)";
             }
         }


    return"failed to accept or reject any request";}



}
