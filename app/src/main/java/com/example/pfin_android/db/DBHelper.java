package com.example.pfin_android.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOM = "andro.db";
    public static final String TABLE_PERS = "t_pers";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NOM, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PERS + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nom TEXT NOT NULL," +
                "ape1 TEXT NOT NULL," +
                "ape2 TEXT NOT NULL," +
                "curso TEXT,"+
                "fec_nac DATE)");

        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_PERS +
                "(nom, ape1, ape2, curso, fec_nac) " +
                "VALUES ('Antonio J', 'Tobaruela', 'Ruiz', '2º DAM', '1988/12/18')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_PERS +
                "(nom, ape1, ape2, curso, fec_nac) " +
                "VALUES ('Álvaro J', 'Díaz', 'Barrios', '2º DAM', '1997/12/21')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_PERS +
                "(nom, ape1, ape2, curso, fec_nac) " +
                "VALUES ('Jose A', 'Rodrigues', 'Ruiz', '2º DAM', '2003/05/18')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_PERS +
                "(nom, ape1, ape2, curso, fec_nac) " +
                "VALUES ('Alberto', 'Hidalgo', 'Ruiz', '2º DAM', '2002/06/18')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_PERS);
        onCreate(sqLiteDatabase);
    }
}
