package com.example.tarefas.model.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

abstract class DAO {
    private static br.edu.ifsuldeminas.mch.tarefas.model.db.DBHandler dbHandler = null;

    DAO(Context context) {
        if (dbHandler == null)
            dbHandler = new br.edu.ifsuldeminas.mch.tarefas.model.db.DBHandler(context);
    }

    SQLiteDatabase openToWrite() throws SQLException {
        return dbHandler.getWritableDatabase();
    }

    SQLiteDatabase openToRead() throws SQLException {
        return dbHandler.getReadableDatabase();
    }
}

