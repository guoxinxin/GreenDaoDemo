package com.dev.greendaodemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.greendaodemo.bean.Shop;
import com.dev.greendaodemo.global.BaseApplication;
import com.wyk.greendaodemo.greendao.gen.ShopDao;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * greenDao3.0以后的版本更加的好用
 */
public class MainActivity extends Activity {

    @Bind(R.id.insert)
    Button insert;
    @Bind(R.id.delete)
    Button delete;
    @Bind(R.id.update)
    Button update;
    @Bind(R.id.query)
    Button query;
    @Bind(R.id.tv)
    TextView tv;
    private ShopDao loveDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.insert, R.id.delete, R.id.update, R.id.query})
    public void onClick(View view) {
       if(loveDao==null){
           loveDao=BaseApplication.getDaoInstant().getShopDao();
       }
        final Shop shop=new Shop();
        switch (view.getId()) {
            case R.id.insert:

                shop.setAddress("济南");
                shop.setName("哎呦  啊");
                shop.setSell_num("10");
                shop.setPrice("20");
                shop.setImage_url("null");
                shop.setId(1);
                loveDao.insertOrReplace(shop);
                Toast.makeText(this,"成功插入",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                loveDao.delete(shop);//无法删除数据？
                break;
            case R.id.update:
                shop.setName("lisi");
                loveDao.updateInTx(shop);//为什么这么更新后的数据没有变化？
                Toast.makeText(this,"更新",Toast.LENGTH_SHORT).show();
                break;
            case R.id.query:
                List<Shop> shops = loveDao.loadAll();
                if(shops.size()==0&&shops.isEmpty()){
                    Toast.makeText(this,"数据库为空",Toast.LENGTH_SHORT).show();
                }
                for (int i = 0; i <shops.size() ; i++) {
                    Shop shop1 = shops.get(i);
                    tv.setText(shop1.getName()+shop1.getAddress()+shop1.getImage_url()+shop1.getImage_url());
                }

                break;
        }
    }
}
