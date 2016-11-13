package com.example.user.dictionary_eng_ja.Sqlite_build;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.example.user.dictionary_eng_ja.Object.JapanDic_English;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Tung Lam on 29-Oct-16.
 */

public class SqliteHelper_Query {
    protected static final String TAG = "Execute Query";
    SQLiteDatabase database;
    SqliteHelper mDbHelper;
    private final Context mContext;

    public SqliteHelper_Query(Context mContext) {
        this.mContext = mContext;
        mDbHelper = new SqliteHelper(mContext);
    }

    public static SqliteHelper_Query getInst(Context context) {
        SqliteHelper_Query sqliteHelper_query = new SqliteHelper_Query(context);
        try {
            sqliteHelper_query.createDatabase();
            sqliteHelper_query.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sqliteHelper_query;
    }

    public SqliteHelper_Query createDatabase() throws SQLException {
        try {
            mDbHelper.createDataBase();
        } catch (IOException mIOException) {
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase");
            throw new Error("UnableToCreateDatabase");
        }
        return this;
    }

    public SqliteHelper_Query open() throws SQLException {
        try {
            mDbHelper.openDataBase();
        } catch (SQLException mSQLException) {
            Log.e(TAG, "open >>" + mSQLException.toString());
            throw mSQLException;
        }
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    public ArrayList<JapanDic_English> getDanhsach() {
        ArrayList<JapanDic_English> listtu = new ArrayList<>();
        String sql=" SELECT * FROM tbl_english ";
        database = mDbHelper.getReadableDatabase();
        Cursor cursor_english = database.rawQuery(sql, null);
        if(cursor_english.moveToFirst()) {
            do {
                JapanDic_English word_eng = new JapanDic_English();
                word_eng.setID_ENG(cursor_english.getString(0));
                word_eng.setENG_WORD(cursor_english.getString(1));
                word_eng.setENG_MEAN(cursor_english.getString(2));
                word_eng.setENG_NOTE(cursor_english.getString(3));
                word_eng.setSAVE(cursor_english.getInt(4));
                listtu.add(word_eng);
            } while (cursor_english.moveToNext());
            cursor_english.close();

        }
        database.close();
        return listtu;
    }


    public ArrayList<JapanDic_English> getDanhsach_bookmark() {
        ArrayList<JapanDic_English> listtu = new ArrayList<>();
        String sql=" SELECT * FROM tbl_english where Save = '1' ";
        database = mDbHelper.getReadableDatabase();
        Cursor cursor_english = database.rawQuery(sql, null);
        if(cursor_english.moveToFirst()) {
            do {
                JapanDic_English word_eng = new JapanDic_English();
                word_eng.setID_ENG(cursor_english.getString(0));
                word_eng.setENG_WORD(cursor_english.getString(1));
                word_eng.setENG_MEAN(cursor_english.getString(2));
                word_eng.setENG_NOTE(cursor_english.getString(3));
                word_eng.setSAVE(cursor_english.getInt(4));
                listtu.add(word_eng);
            } while (cursor_english.moveToNext());
            cursor_english.close();

        }
        database.close();
        return listtu;
    }

}
