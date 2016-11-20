package com.example.user.dictionary_eng_ja;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.dictionary_eng_ja.Adapter.Adapter_danhsachtu;
import com.example.user.dictionary_eng_ja.Fragment_Source.Fragment_listword;
import com.example.user.dictionary_eng_ja.Object.JapanDic_English;
import com.example.user.dictionary_eng_ja.Sqlite_build.SqliteHelper_Query;

import java.util.ArrayList;

/**
 * Created by Tung Lam on 16-Nov-16.
 */

public class Search_Activity  extends AppCompatActivity implements  android.support.v7.widget.SearchView.OnQueryTextListener {

    private Toolbar toolbar1;
    private SqliteHelper_Query exec;
    private JapanDic_English japanDic_english;
    private SearchView searchView;
    private ArrayList<String> lstStrJapan;
    private ListView lst_danhsach_tu;
    private ArrayList<JapanDic_English> japan ;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

       toolbar1 = (Toolbar) findViewById(R.id.tool_bar_search);
        lst_danhsach_tu = (ListView) findViewById(R.id.lst_search);

        LoadAdapter_dstu();

        ///// lấy sự kiện >>>chuyển DL
        lst_danhsach_tu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(Search_Activity.this , Meaning_Activity.class);
                japanDic_english= (JapanDic_English) japan.get(i);
               intent.putExtra("tuchon", japanDic_english);
               startActivity(intent);
                adapter.notifyDataSetChanged();

            }
        });


        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_toolbar, menu);
        MenuItem itemSearch = menu.findItem(R.id.menu_search);
        searchView = (SearchView) itemSearch.getActionView();
        searchView.setOnQueryTextListener( this);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_search) {
            return true;
        }
        else if(id== R.id.asc_tbs)
        {
            exec = SqliteHelper_Query.getInst(this);
            japan = exec.getDanhsach_ASC();
            lstStrJapan = new ArrayList<String>();
            for(int i=0;i<japan.size();i++){
                lstStrJapan.add(japan.get(i).getENG_WORD());
            }
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lstStrJapan);
            lst_danhsach_tu.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            return  true;
        }

        else if (id == R.id.desc_tbs)
        {

            exec = SqliteHelper_Query.getInst(this);
            japan = exec.getDanhsach_desc();

            lstStrJapan = new ArrayList<String>();
            for(int i=0;i<japan.size();i++){
                lstStrJapan.add(japan.get(i).getENG_WORD());
            }

            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lstStrJapan);
            lst_danhsach_tu.setAdapter(adapter);

            adapter.notifyDataSetChanged();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void LoadAdapter_dstu() {
        /// chỗ này gọi nó ra rồi gán vào
        exec = SqliteHelper_Query.getInst(this);

        japan = exec.getDanhsach();

        /// l
       lstStrJapan = new ArrayList<String>();
        for(int i=0;i<japan.size();i++) {
            lstStrJapan.add(japan.get(i).getENG_WORD());

        }
         adapter  = new ArrayAdapter(Search_Activity.this, android.R.layout.simple_list_item_1,lstStrJapan);
        Log.d(japan.toString(),"errr");
        lst_danhsach_tu.setAdapter(adapter);

    }
    @Override
    public boolean onQueryTextSubmit(String s) {
        return true;
    }


    //phương thúc lọc khi search
    @Override
    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)){
            adapter.getFilter().filter("");
           /// lstStrJapan.clearTextFilter();
        }else {
            adapter.getFilter().filter(newText);

        }
        return true;
    }
}
