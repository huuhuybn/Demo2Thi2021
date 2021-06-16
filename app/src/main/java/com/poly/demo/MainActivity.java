package com.poly.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText id;
    private EditText name;
    private EditText price;
    private EditText product;
    private Button them;
    private Button sua;
    private Button xoa;
    private ListView list;
    private MySqlite mySqlite;
    private PhoneAdapter phoneAdapter;
    private ArrayList<Phone> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySqlite = new MySqlite(this);
        id = findViewById(R.id.id);
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        product = findViewById(R.id.product);

        them = findViewById(R.id.them);
        sua = findViewById(R.id.sua);
        xoa = findViewById(R.id.xoa);
        list = findViewById(R.id.list);

        arrayList = mySqlite.danhSachPhone();
        phoneAdapter = new PhoneAdapter(arrayList);
        list.setAdapter(phoneAdapter);

        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID = id.getText().toString();
                String NAME = name.getText().toString();
                String PRICE = price.getText().toString();
                String PRO_ID = product.getText().toString();
                Phone phone = new Phone(ID, NAME, PRICE, PRO_ID);
                mySqlite.them(phone);

                arrayList = mySqlite.danhSachPhone();
                phoneAdapter = new PhoneAdapter(arrayList);
                list.setAdapter(phoneAdapter);
            }
        });
        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID = id.getText().toString();
                String NAME = name.getText().toString();
                String PRICE = price.getText().toString();
                String PRO_ID = product.getText().toString();
                Phone phone = new Phone(ID, NAME, PRICE, PRO_ID);
                mySqlite.sua(phone);

                arrayList = mySqlite.danhSachPhone();
                phoneAdapter = new PhoneAdapter(arrayList);
                list.setAdapter(phoneAdapter);
            }
        });
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID = id.getText().toString();
                String NAME = name.getText().toString();
                String PRICE = price.getText().toString();
                String PRO_ID = product.getText().toString();
                Phone phone = new Phone(ID, NAME, PRICE, PRO_ID);
                mySqlite.xoa(phone);

                arrayList = mySqlite.danhSachPhone();
                phoneAdapter = new PhoneAdapter(arrayList);
                list.setAdapter(phoneAdapter);
            }
        });


    }
}