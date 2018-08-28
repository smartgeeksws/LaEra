package com.example.worldskills.laera;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.provider.BaseColumns;

public class AyudaBaseDatos extends SQLiteOpenHelper {

    private static final String NOMBRE_BASEDATOS = "prueba.db";
    private static final int VERSION_BASEDATOS = 1;

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedReaderContract.FeedEntry.TABLE_NAME + " (" +
                    FeedReaderContract.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_JUGADOR + " TEXT," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_PUNTAJE + " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedReaderContract.FeedEntry.TABLE_NAME;


    public final class FeedReaderContract {
        // To prevent someone from accidentally instantiating the contract class,
        // make the constructor private.
        private FeedReaderContract() {}

        /* Inner class that defines the table contents */
        public class FeedEntry implements BaseColumns {
            public static final String TABLE_NAME = "usuarios";
            public static final String COLUMN_NAME_JUGADOR = "jugador";
            public static final String COLUMN_NAME_PUNTAJE = "puntaje";
        }
    }

    public AyudaBaseDatos(Context context) {
        super(context, NOMBRE_BASEDATOS, null,VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
