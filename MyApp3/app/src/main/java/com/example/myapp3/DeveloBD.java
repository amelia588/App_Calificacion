package com.example.myapp3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DeveloBD extends SQLiteOpenHelper {

    private static final String NOMBRE_BD = "Develo.bd";
    private static final int VERSION_BD = 1;
    private static final String TABLE_CURSOS = "CREATE TABLE CURSOS (NOMBRE TEXT PRIMARY KEY, CURSO TEXT, CALIFICACION REAL)";

    public DeveloBD(@Nullable Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CURSOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS CURSOS");
        sqLiteDatabase.execSQL(TABLE_CURSOS);
    }

    public void agregarCurso(String nombre, String curso, String calificacion) {
        SQLiteDatabase bd = getWritableDatabase();
        if (bd != null) {
            bd.execSQL("INSERT INTO CURSOS (NOMBRE, CURSO, CALIFICACION) VALUES('"
                    + nombre + "', '" + curso + "', '" + calificacion + "')");
            bd.close();
        }
    }
}
