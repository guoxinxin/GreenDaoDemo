package com.dev.greendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;

/**
 * 作者：Michael
 * <p>
 * 时间：2017/2/26 20:44
 *
 * 1.@Entity：告诉GreenDao该对象为实体，只有被@Entity注释的Bean类才能被dao类操作

 2.@Id：对象的Id，使用Long类型作为EntityId，否则会报错。(autoincrement = true)表示主键会自增，如果false就会使用旧值

 3.@Property：可以自定义字段名，注意外键不能使用该属性

 4.@NotNull：属性不能为空

 5.@Transient：使用该注释的属性不会被存入数据库的字段中

 6.@Unique：该属性值必须在数据库中是唯一值

 7.@Generated：编译后自动生成的构造函数、方法等的注释，提示构造函数、方法等不能被修改
 */
@Entity
public class Shop {
    private static final int TYPE_CART=0x01;//购物车列表
    private static final int TYPE_LOVE=0x02;//收藏的列表
    @Id(autoincrement = true)
    private long id ;//不能使用int,设置为自增
    @Unique
    private String name;//唯一约束,商品的名称
    @Property(nameInDb = "price")
    private String price;//商品的价格,propery表示的是可以自定义字段注意的是外键不能使用该属性
    //图标url
    private String image_url;
    //卖出的数量
    private String sell_num;
    //商家的地址
    private String address;
    //商品的列表类型
    private int type;
    @Generated(hash = 1773010509)
    public Shop(long id, String name, String price, String image_url,
            String sell_num, String address, int type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image_url = image_url;
        this.sell_num = sell_num;
        this.address = address;
        this.type = type;
    }
    @Generated(hash = 633476670)
    public Shop() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPrice() {
        return this.price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getImage_url() {
        return this.image_url;
    }
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
    public String getSell_num() {
        return this.sell_num;
    }
    public void setSell_num(String sell_num) {
        this.sell_num = sell_num;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }


}
