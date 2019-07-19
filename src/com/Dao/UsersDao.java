package com.Dao;
import com.entity.users;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDao extends DaoFather{
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/users?characterEncoding=utf8&useSSL=false&serverTimezone=CST";
    private static final String username = "root";
    private static final String password = "root";

   public int  insertUsers(users use){
       Connection conn = null;
       PreparedStatement pra = null;
       ResultSet rs = null;

       try {
       conn = this.getConnection();
       String sql="insert into userinfo(userName,userPassword,userSex,userHobbys," +
               "userPhone,userEmail,userAddrs,Flag) " +
               "values (?,?,?,?,?,?,?,?) ";
       List<Object> paramList = new ArrayList<>();
       paramList.add(use.getUserName());
       paramList.add(use.getUserPassword());
       paramList.add(use.getUserSex());
       paramList.add(use.getUserHobbys());
       paramList.add(use.getUserPhone());
       paramList.add(use.getUserEmail());
       paramList.add(use.getUserAddrs());
       paramList.add(use.getFlag());
       pra = conn.prepareStatement(sql);
       if(paramList!=null && paramList.size()>0){
           for(int i=0;i<paramList.size();i++){
               pra.setObject(i+1, paramList.get(i));
           }
       }
        int rows = pra.executeUpdate();
       return rows;

       } catch (SQLException e) {
           e.printStackTrace();
       }finally {
           this.closeAll(conn,pra,rs);
       }


       return 0;
   }












    public List<users> findByUser(users use){
     Connection conn =null;
     ResultSet rs =null;
     PreparedStatement pra =null;
     List<users> list =new ArrayList<>();

     conn =this.getConnection();
     StringBuffer sf = new StringBuffer();
     List<Object> paramList =new ArrayList<>();
     sf.append("select * from userinfo where 1=1 ");
     if(use!=null){
         if(use.getId()>0){
             sf.append(" and Id=? ");
             paramList.add(use.getId());
         }
         if(use.getUserName()!=null){
           sf.append("and userName=? ");
           paramList.add(use.getUserName());
         }
         if(use.getUserPassword()!=null){
             sf.append("and userPassword=? ");
             paramList.add(use.getUserPassword());
         }
         if(use.getUserSex()!=null){
             sf.append(" and userSex=? ");
             paramList.add(use.getUserSex());
         }
         if(use.getUserHobbys()!=null){
             sf.append(" and userHobbys=? ");
             paramList.add(use.getUserHobbys());
         }
         if(use.getUserPhone()!=null){
             sf.append(" and userPhone=? ");
             paramList.add(use.getUserPhone());
         }
         if(use.getUserEmail()!=null){
             sf.append(" and userEmail=? ");
             paramList.add(use.getUserEmail());
         }
         if(use.getUserAddrs()!=null){
             sf.append(" and userAddrs=? ");
             paramList.add(use.getUserAddrs());
         }
         if(use.getFlag()!=null){
             sf.append(" and Flag=? ");
             paramList.add(use.getFlag());
         }
     }
        try {
            pra =conn.prepareStatement(sf.toString());

            if(paramList!=null && paramList.size()>0){
                for(int i=0;i<paramList.size();i++){
                    pra.setObject(i+1, paramList.get(i));
                }
            }
           rs = pra.executeQuery();
           while (rs.next()){
               users entity = new users();
               entity.setId(rs.getInt("Id"));
               entity.setUserName(rs.getString("userName"));
               entity.setUserPassword(rs.getString("userPassword"));
               entity.setUserSex(rs.getString("userSex"));
               entity.setUserHobbys(rs.getString("userHobbys"));
               entity.setUserPhone(rs.getString("userPhone"));
               entity.setUserEmail(rs.getString("userEmail"));
               entity.setUserAddrs(rs.getString("userAddrs"));
               entity.setFlag(rs.getString("Flag"));
               list.add(entity);
           }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
         this.closeAll(conn,pra,rs);
        }
        return list;
    }
}
