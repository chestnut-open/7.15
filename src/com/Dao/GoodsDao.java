package com.Dao;

import com.entity.Goods;
import com.entity.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDao extends DaoFather {

    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/users?characterEncoding=utf8&useSSL=false&serverTimezone=CST";
    private static final String username = "root";
    private static final String password = "root";

    public List<Goods> findByGoods(Goods goods){
        Connection conn =null;
        ResultSet rs =null;
        PreparedStatement pra =null;
        List<Goods> list =new ArrayList<>();

        conn =this.getConnection();
        StringBuffer sf = new StringBuffer();
        List<Object> paramList =new ArrayList<>();
        sf.append("select * from goodsinfo where 1=1 ");
        if(goods!=null){
            if(goods.getId()>0){
                sf.append(" and Id= ? ");
                paramList.add(goods.getId());
            }
            if(goods.getGoodsName()!=null){
                sf.append("and goodsName= ? ");
                paramList.add(goods.getGoodsName());
            }
            if(goods.getGoodsPic()!=null){
                sf.append("and goodsPic= ? ");
                paramList.add(goods.getGoodsPic());
            }
            if(goods.getGoodsPrice()!=null){
                sf.append(" and goodsPrice = ? ");
                paramList.add(goods.getGoodsPrice());
            }
            if(goods.getGoodsDescription()!=null){
                sf.append(" and goodsDescription = ? ");
                paramList.add(goods.getGoodsDescription());
            }
            if(goods.getGoodsStock()!=null){
                sf.append(" and goodsStock = ? ");
                paramList.add(goods.getGoodsStock());
            }
            if(goods.getFlag()!=null){
                sf.append(" and Flag = ? ");
                paramList.add(goods.getFlag());
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
                Goods entity = new Goods();
                entity.setId(rs.getInt("Id"));
                entity.setGoodsName(rs.getString("goodsName"));
                entity.setGoodsPic(rs.getString("goodsPic"));
                entity.setGoodsPrice(rs.getString("goodsPrice"));
                entity.setGoodsDescription(rs.getString("goodsDescription"));
                entity.setGoodsStock(rs.getString("goodsStock"));
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

    public int  updataGoods(Goods goods){
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;

        try {
            conn = this.getConnection();
//            String sql="insert into userinfo(Id,goodsName,  goodsPic,  goodsPrice,  goodsDescription,  goodsStock ,flag) " +
//                    "values (?,?,?,?,?,?,?,?) ";
            String sql ="UPDATE goodsinfo SET goodsName = ? , goodsPic =?  , goodsPrice =?, goodsDescription= ? , goodsStock=? , Flag=? WHERE  Id= ?  ";
            List<Object> paramList = new ArrayList<>();

            paramList.add(goods.getGoodsName());
            paramList.add(goods.getGoodsPic());
            paramList.add(goods.getGoodsPrice());
            paramList.add(goods.getGoodsDescription());
            paramList.add(goods.getGoodsStock());
            paramList.add(goods.getFlag());
            paramList.add(goods.getId());
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
    public int  addGoods(Goods goods){
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;

        try {
            conn = this.getConnection();
//            String sql="insert into userinfo(Id,goodsName,  goodsPic,  goodsPrice,  goodsDescription,  goodsStock ,flag) " +
//                    "values (?,?,?,?,?,?,?,?) ";
            String sql ="insert into goodsinfo(goodsName,goodsPic,goodsPrice,goodsDescription,goodsStock,flag)" +
                    "values (?,?,?,?,?,?)";
            List<Object> paramList = new ArrayList<>();
            paramList.add(goods.getGoodsName());
            paramList.add(goods.getGoodsPic());
            paramList.add(goods.getGoodsPrice());
            paramList.add(goods.getGoodsDescription());
            paramList.add(goods.getGoodsStock());
            paramList.add(goods.getFlag());
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


    public int  deleteGoods(Goods goods){
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;

        try {
            conn = this.getConnection();
            String sql ="delete from goodsinfo WHERE  Id= ?  ";
            pra = conn.prepareStatement(sql);
            pra.setObject(1,goods.getId());
            int rows = pra.executeUpdate();
            return rows;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeAll(conn,pra,rs);
        }


        return 0;
    }












}
