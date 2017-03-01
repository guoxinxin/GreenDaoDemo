package com.dev.greendaodemo.global;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.wyk.greendaodemo.greendao.gen.DaoMaster;
import com.wyk.greendaodemo.greendao.gen.DaoSession;

/**
 * 作者：Michael
 * <p>
 * 时间：2017/3/1 15:24
 *
 * 在这里进行创建数据库
 */

public class BaseApplication extends Application {
    private static DaoSession daoSession;
    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext  = this;
        setUpDataBase();
    }
    public static DaoSession getDaoInstant(){
        return daoSession;
    }

    /**
     * 配置数据库
     *
     * •DevOpenHelper：创建SQLite数据库的SQLiteOpenHelper的具体实现

      •DaoMaster：GreenDao的顶级对象，作为数据库对象、用于创建表和删除表

      •DaoSession：管理所有的Dao对象，Dao对象中存在着增删改查等API

     由于我们已经创建好了DaoSession和Shop的Bean对象，编译后会自动生成我们的ShopDao对象，可通过DaoSession获得
     ShopDao dao = daoSession.getShopDao();

     这里的Dao（Data access Object）是指数据访问接口，即提供了数据库操作一些API接口，可通过dao进行增删改查操作
     */
    private void setUpDataBase() {
        //创建数据库
        DaoMaster.DevOpenHelper helper=new DaoMaster.DevOpenHelper(mContext,"shop.db",null);
        //获取可写的数据库
        SQLiteDatabase db=helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster=new DaoMaster(db);
        //获取数据库对象管里者
        daoSession=daoMaster.newSession();
    }
}
