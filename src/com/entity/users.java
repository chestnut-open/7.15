package com.entity;

public class users {
    private int Id;
    private String userName;
    private String userPassword;
    private String userSex;
    private String userHobbys;
    private String userPhone;
    private String userEmail;
    private String userAddrs;
    private String Flag;

    public users(String userName ,String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public users() {
    }

    public users(int id, String userName, String userPassword, String userSex, String userHobbys, String userPhone, String userEmail, String userAddrs, String flag) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userSex = userSex;
        this.userHobbys = userHobbys;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userAddrs = userAddrs;
        Flag = flag;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserHobbys() {
        return userHobbys;
    }

    public void setUserHobbys(String userHobbys) {
        this.userHobbys = userHobbys;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddrs() {
        return userAddrs;
    }

    public void setUserAddrs(String userAddrs) {
        this.userAddrs = userAddrs;
    }

    public String getFlag() {
        return Flag;
    }

    public void setFlag(String flag) {
        Flag = flag;
    }

    @Override
    public String toString() {
//        private int Id;
//        private String userName;
//        private String userPassword;
//        private String userSex;
//        private String userHobbys;
//        private String userPhone;
//        private String userEmail;
//        private String userAddrs;
//        private String Flag;

      return "users{" +
                "Id='" + Id + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword=" + userPassword +
                ", userSex='" + userSex + '\''+
              "userHobbys='" + userHobbys + '\'' +
              ", userPhone='" + userPhone + '\'' +
              ", userEmail=" + userEmail +
              ", userAddrs='" + userAddrs + '\''+
              ", Flag='" + Flag + '\'' +
                '}';
    }
}
