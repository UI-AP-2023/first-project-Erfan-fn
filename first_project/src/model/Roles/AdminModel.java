package model.Roles;

public class AdminModel extends UserModel {
    private static AdminModel adminModel=new AdminModel("admin","admin");
    private AdminModel(String userName,String password)
    {
        super(userName, password);
    }

    public static AdminModel getAdminModel() {
        return adminModel;
    }
}
