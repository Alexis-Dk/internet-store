package com.superinc.europe.onlineshopping.gu.entities.dto;

import com.superinc.europe.onlineshopping.gu.entities.pojo.Product;

import java.io.Serializable;

public class ExtendedProductDTO implements Serializable {

    private int productId;

    public int categoryId;

    private String name;

    private String image1Path;

    private String image2Path;

    private String image3Path;

    private String image4Path;

    private String image5Path;

    private String image6Path;

    private double price;

    private int oldprice;

    private String description;

    private String comment;

    private String characteristic1;

    private String characteristic2;

    private String characteristic3;

    private String characteristic4;

    private String characteristic5;

    private String characteristic6;

    private String characteristic7;

    private int characteristic8;

    private int characteristic9;

    private int characteristic10;

    private int characteristic11;

    private int deleteStatus;

    private String stockStatus;

    private int rating;

    private double intCharacteristic1;

    private double intCharacteristic2;

    private double intCharacteristic3;

    private double intCharacteristic4;

    private int intCharacteristic5;

    private Boolean boolCharacteristic1 = false;

    private Boolean boolCharacteristic2 = false;

    private Boolean boolCharacteristic3 = false;

    private Boolean boolCharacteristic4 = false;

    private Boolean boolCharacteristic5 = false;

    private int quantity;

    public ExtendedProductDTO() {
    }

    public ExtendedProductDTO(Product product) {
        this.productId = product.getProductId();
        this.categoryId = product.getCategoryFk().getCategoryId();
        this.name = product.getName();
        this.image1Path = product.getImage1Path();
        this.image2Path = product.getImage2Path();
        this.image3Path = product.getImage3Path();
        this.image4Path = product.getImage4Path();
        this.image5Path = product.getImage5Path();
        this.image6Path = product.getImage6Path();
        this.price = product.getPrice();
        this.oldprice = product.getOldprice();
        this.description = product.getDescription();
        this.comment = product.getComment();
        this.characteristic1 = product.getCharacteristic1();
        this.characteristic2 = product.getCharacteristic2();
        this.characteristic3 = product.getCharacteristic3();
        this.characteristic4 = product.getCharacteristic4();
        this.characteristic5 = product.getCharacteristic5();
        this.characteristic6 = product.getCharacteristic6();
        this.characteristic7 = product.getCharacteristic7();
        this.characteristic8 = product.getCharacteristic8();
        this.characteristic9 = product.getCharacteristic9();
        this.characteristic10 = product.getCharacteristic10();
        this.characteristic11 = product.getCharacteristic11();
        this.deleteStatus = product.getDeleteStatus();
        this.stockStatus = product.getStockStatus();
        this.rating = product.getRating();
        this.intCharacteristic1 = product.getIntCharacteristic1();
        this.intCharacteristic2 = product.getIntCharacteristic2();
        this.intCharacteristic3 = product.getIntCharacteristic3();
        this.intCharacteristic4 = product.getIntCharacteristic4();
        this.intCharacteristic5 = product.getIntCharacteristic5();
        this.boolCharacteristic1 = product.getBoolCharacteristic1();
        this.boolCharacteristic2 = product.getBoolCharacteristic2();
        this.boolCharacteristic3 = product.getBoolCharacteristic3();
        this.boolCharacteristic4 = product.getBoolCharacteristic4();
        this.boolCharacteristic5 = product.getBoolCharacteristic5();
    }

    public int getQuantity() {
        return quantity;
    }

    public int getProductId() {
        return productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public String getImage1Path() {
        return image1Path;
    }

    public String getImage2Path() {
        return image2Path;
    }

    public String getImage3Path() {
        return image3Path;
    }

    public String getImage4Path() {
        return image4Path;
    }

    public String getImage5Path() {
        return image5Path;
    }

    public String getImage6Path() {
        return image6Path;
    }

    public double getPrice() {
        return price;
    }

    public int getOldprice() {
        return oldprice;
    }

    public String getDescription() {
        return description;
    }

    public String getComment() {
        return comment;
    }

    public String getCharacteristic1() {
        return characteristic1;
    }

    public String getCharacteristic2() {
        return characteristic2;
    }

    public String getCharacteristic3() {
        return characteristic3;
    }

    public String getCharacteristic4() {
        return characteristic4;
    }

    public String getCharacteristic5() {
        return characteristic5;
    }

    public String getCharacteristic6() {
        return characteristic6;
    }

    public String getCharacteristic7() {
        return characteristic7;
    }

    public int getCharacteristic8() {
        return characteristic8;
    }

    public int getCharacteristic9() {
        return characteristic9;
    }

    public int getCharacteristic10() {
        return characteristic10;
    }

    public int getCharacteristic11() {
        return characteristic11;
    }

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public int getRating() {
        return rating;
    }

    public double getIntCharacteristic1() {
        return intCharacteristic1;
    }

    public double getIntCharacteristic2() {
        return intCharacteristic2;
    }

    public double getIntCharacteristic3() {
        return intCharacteristic3;
    }

    public double getIntCharacteristic4() {
        return intCharacteristic4;
    }

    public int getIntCharacteristic5() {
        return intCharacteristic5;
    }

    public Boolean getBoolCharacteristic1() {
        return boolCharacteristic1;
    }

    public Boolean getBoolCharacteristic2() {
        return boolCharacteristic2;
    }

    public Boolean getBoolCharacteristic3() {
        return boolCharacteristic3;
    }

    public Boolean getBoolCharacteristic4() {
        return boolCharacteristic4;
    }

    public Boolean getBoolCharacteristic5() {
        return boolCharacteristic5;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
