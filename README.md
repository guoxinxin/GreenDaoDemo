# GreenDaoDemo
[借鉴地址](http://www.tuicool.com/articles/iUfUBn6)
[greendao的官方网站](http://greenrobot.org/greendao/)
[greendao的github地址](https://github.com/greenrobot/greenDAO)
##Greendao的简单使用
###基于GreenDao3.2的简单基本使用，目前只实现了数据的插入的简单查询，在以后会不断的进行补充。
##GreenDao的基本的使用流程：
####1.添加依赖
#####第一步：先在app.gradle中添加依赖
```java
apply plugin: 'org.greenrobot.greendao'//千万记得添加这个，要不然编译会不通过，真是扎心


greendao{
    schemaVersion 1//版本号，升级时可配置
    daoPackage 'com.wyk.greendaodemo.greendao.gen'//通过gradle插件生成的数据库相关文件的包名，默认为你的entity所在的包名
    targetGenDir 'src/main/java'//就是我们上面说到的自定义生成数据库文件的目录了
}

compile 'org.greenrobot:greendao:3.2.0'

```
#####第二步：在project.gradle中添加依赖
```java
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.2.3'
        classpath 'org.greenrobot:greendao-gradle-plugin:3.2.1'
    }
}
```

####2.添加完依赖，编译一下，应该是没有没有什么不对的地方，接下来就可以创建实体类，创建bean类，在输入属性在greendao3.2中会自动生成DaoMaster,XXXDao,DaoSession
####3.接下来就是创建数据库
```java
//创建数据库
        DaoMaster.DevOpenHelper helper=new DaoMaster.DevOpenHelper(mContext,"shop.db",null);
        //获取可写的数据库
        SQLiteDatabase db=helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster=new DaoMaster(db);
        //获取数据库对象管里者
        daoSession=daoMaster.newSession();
```
####4进行数据库的操作：增，删，改，查
