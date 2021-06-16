package com.poly.demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class MySqlite extends SQLiteOpenHelper {

    Context mContext;

    public MySqlite(Context context) {
        super(context, "tenfi.db", null, 1);
        mContext = context;
    }
//    String ID interger primary key;
//    String NAME varchar;
//    String PRICE float;
//    String PRO_ID varchar;

    @Override
    public void onCreate(SQLiteDatabase db) {
        String phone = "create table phone(ID integer primary key,NAME varchar,PRICE float,PRO_ID varchar)";
        db.execSQL(phone);

    }

    public void them(Phone phone) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID", phone.getID());
        values.put("NAME", phone.getNAME());
        values.put("PRICE", phone.getPRICE());
        values.put("PRO_ID", phone.getPRO_ID());

        long kq = database.insert("phone", null, values);
        if (kq > 0) {
            Toast.makeText(mContext, "THANH CONG", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, "KHONG THANH CONG", Toast.LENGTH_SHORT).show();
        }


    }

    public void sua(Phone phone) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID", phone.getID());
        values.put("NAME", phone.getNAME());
        values.put("PRICE", phone.getPRICE());
        values.put("PRO_ID", phone.getPRO_ID());

        long kq = database.update("phone", values, "ID=?",
                new String[]{phone.getID()});
        if (kq > 0) {
            Toast.makeText(mContext, "THANH CONG", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, "KHONG THANH CONG", Toast.LENGTH_SHORT).show();
        }
    }

    public void xoa(Phone phone) {
        SQLiteDatabase database = getWritableDatabase();
        long kq = database.delete("phone", "ID=?",
                new String[]{phone.getID()});
        if (kq > 0) {
            Toast.makeText(mContext, "THANH CONG", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, "KHONG THANH CONG", Toast.LENGTH_SHORT).show();
        }
    }

    public ArrayList<Phone> danhSachPhone() {
        ArrayList<Phone> arrayList = new ArrayList<>();
        SQLiteDatabase database = getWritableDatabase();
        String get_All = "select * from phone";
        Cursor cursor = database.rawQuery(get_All, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {

                String ID = cursor.getString(0);
                String NAME = cursor.getString(1);
                String PRICE = cursor.getString(2);
                String PRO_ID = cursor.getString(3);

                Phone phone = new Phone(ID, NAME, PRICE, PRO_ID);
                arrayList.add(phone);

                cursor.moveToNext();
            }
            cursor.close();
        }
        return arrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
