package com.dev.greendaodemo;

import com.dev.greendaodemo.bean.Shop;
import com.dev.greendaodemo.global.BaseApplication;
import com.wyk.greendaodemo.greendao.gen.ShopDao;

import java.util.List;

/**
 * 作者：Michael
 * <p>
 * 时间：2017/3/1 15:46
 *
 * 数据库的操作
 */

public class LoveDao {

    //添加数据，如果有重复的则进行覆盖
    public static  void  insertLove(Shop shop){
        BaseApplication.getDaoInstant().getShopDao().insertOrReplace(shop);
    }
    //删除数据
    public static void deleteLove(long id){
        BaseApplication.getDaoInstant().getShopDao().deleteByKey(id);
    }
    //更新数据
    public static void updateLove(Shop shop){
        BaseApplication.getDaoInstant().getShopDao().update(shop);
    }
    //查询条件是XXX的数据
    public static List<Shop> queryLove(){
       return BaseApplication.getDaoInstant().getShopDao().queryBuilder().where(ShopDao.Properties.Type.eq(Shop.TYPE_LOVE))
                .list();
    }
    //查询所有的数据
    public static List<Shop> queryAll(){
        return BaseApplication.getDaoInstant().getShopDao().loadAll();
    }
}
