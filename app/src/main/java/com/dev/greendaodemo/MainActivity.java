package com.dev.greendaodemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.greendaodemo.bean.Shop;
import com.dev.greendaodemo.global.BaseApplication;
import com.wyk.greendaodemo.greendao.gen.ShopDao;

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
    @Bind(R.id.id)
    EditText id;
    @Bind(R.id.name)
    EditText name;
    @Bind(R.id.address)
    EditText address;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;
    private ShopDao loveDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.insert, R.id.delete, R.id.update, R.id.query})
    public void onClick(View view) {
        if (loveDao == null) {
            loveDao = BaseApplication.getDaoInstant().getShopDao();
        }

        Shop shop1 = new Shop();
        switch (view.getId()) {
            case R.id.insert:
                shop1.setAddress(address.getText().toString());
                shop1.setName(name.getText().toString());
                shop1.setId(Integer.parseInt(id.getText().toString()));
                loveDao.insert(shop1);
                Toast.makeText(this, "成功插入", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete://这里的删除的通过传入的id进行删除
                String s1 = id.getText().toString();
                Long aLong1 = Long.valueOf(s1);
                loveDao.deleteByKey(aLong1);
                break;
            case R.id.update:
               //更新的这里逻辑没有弄清，不知如何下手
                break;
            case R.id.query:
                String s = id.getText().toString();
                int i = Integer.parseInt(s);
                Shop load = loveDao.load((long) i);
                tv.setText(load.getName());

                break;
        }
    }
}
