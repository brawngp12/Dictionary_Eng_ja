package com.example.user.dictionary_eng_ja;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.user.dictionary_eng_ja.Adapter.Adapter_danhsachtu;
import com.example.user.dictionary_eng_ja.Object.JapanDic_English;
import com.example.user.dictionary_eng_ja.Sqlite_build.SqliteHelper_Query;

import java.util.ArrayList;

/**
 * Created by Tung Lam on 16-Nov-16.
 */

public class Search_Activity  extends AppCompatActivity {
    private Toolbar toolbar1;
    private SqliteHelper_Query exec;
    private ListView lst_danhsach_tu;
    JapanDic_English japanDic_english;
    ArrayList<JapanDic_English>  japanDic_englishArrayList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

       toolbar1 = (Toolbar) findViewById(R.id.tool_bar_search);
        lst_danhsach_tu = (ListView) findViewById(R.id.lst_search);
        LoadAdapter_dstu();

        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void LoadAdapter_dstu() {

        exec = SqliteHelper_Query.getInst(this);
        japanDic_englishArrayList = exec.getDanhsach();
        Adapter_danhsachtu arrayAdapter = new Adapter_danhsachtu(this, R.layout.custom_listview, japanDic_englishArrayList);
        lst_danhsach_tu.setAdapter(arrayAdapter);
    }
}
