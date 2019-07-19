package com.entity;

public class Goods {
    private int id;
    private String goodsName;
    private String goodsPic;
    private String goodsPrice;
    private String goodsDescription;
    private String goodsStock;
    private String flag;

    public Goods() {
    }

    public Goods(int id) {
        this.id = id;
    }
    public Goods( String goodsName, String goodsPic, String goodsPrice, String goodsDescription, String goodsStock, String flag) {
        this.goodsName = goodsName;
        this.goodsPic = goodsPic;
        this.goodsPrice = goodsPrice;
        this.goodsDescription = goodsDescription;
        this.goodsStock = goodsStock;
        this.flag = flag;
    }
    public Goods(int id, String goodsName, String goodsPic, String goodsPrice, String goodsDescription, String goodsStock, String flag) {
        this.id = id;
        this.goodsName = goodsName;
        this.goodsPic = goodsPic;
        this.goodsPrice = goodsPrice;
        this.goodsDescription = goodsDescription;
        this.goodsStock = goodsStock;
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public String getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(String goodsStock) {
        this.goodsStock = goodsStock;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
