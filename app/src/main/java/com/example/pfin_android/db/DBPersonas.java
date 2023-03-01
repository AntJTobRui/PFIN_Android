package com.example.pfin_android.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.pfin_android.modelo.Persona;

import java.text.ParseException;
import java.util.ArrayList;

public class DBPersonas extends DBHelper{

    Context context;

    public DBPersonas(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertar(){
        return 0;
    }

    public ArrayList<Persona> mostrarPersonas(){
        DBHelper dbHelper =  new DBHelper(this.context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Persona> listPers = new ArrayList<Persona>();
        Persona pers = null;
        Cursor cur = null;

        cur = db.rawQuery("SELECT * FROM " + TABLE_PERS, null);
        if(cur.moveToFirst()){
            do{
                pers = new Persona();
                pers.setId(cur.getInt(0));
                pers.setNom(cur.getString(1));
                pers.setApe1(cur.getString(2));
                pers.setApe2(cur.getString(3));
                pers.setCurso(cur.getString(4));
                pers.setFec_nac(com.example.fin_android.controlador.MyTools.stringToGregorianCalendar(cur.getString(5)));
                listPers.add(pers);
            }while(cur.moveToNext());
            cur.close();
        }
        return listPers;
    }

    public Persona mostrarDatos(int i){
        DBHelper dbHelper =  new DBHelper(this.context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Persona pers = new Persona();
        Cursor cur = null;

        cur = db.rawQuery("SELECT * FROM " + TABLE_PERS + " WHERE id = " + i, null);
        if(cur.moveToFirst()){
            //do{
                pers = new Persona();
                pers.setId(cur.getInt(0));
                pers.setNom(cur.getString(1));
                pers.setApe1(cur.getString(2));
                pers.setApe2(cur.getString(3));
                pers.setCurso(cur.getString(4));
                pers.setFec_nac(com.example.fin_android.controlador.MyTools.stringToGregorianCalendar(cur.getString(5)));
            //}while(cur.moveToNext());
            cur.close();
        }
        return pers;
    }
}
