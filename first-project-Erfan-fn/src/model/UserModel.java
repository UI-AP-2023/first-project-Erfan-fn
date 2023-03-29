package model;

public abstract class UserModel {
    private final String userName;
    private String email;
    private String phoneNumber;
    private String password;
    public UserModel(String userName,String email,String phoneNumber,String password)
    {
        this.userName=userName;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.password=password;
    }
    public UserModel(String userName,String password)
    {
     this(userName,null,null,password);
    }
    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public String getUserName() {
        return this.userName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
