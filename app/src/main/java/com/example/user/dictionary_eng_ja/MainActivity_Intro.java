    package com.example.user.dictionary_eng_ja;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.user.dictionary_eng_ja.Adapter.Adapter_danhsachtu;
import com.example.user.dictionary_eng_ja.Fragment_Source.Fragment_listword;
import com.example.user.dictionary_eng_ja.Fragment_Source.Fragment_listword_japan;
import com.example.user.dictionary_eng_ja.Object.JapanDic_English;
import com.example.user.dictionary_eng_ja.Sqlite_build.SqliteHelper_Query;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.fragment;

    public class MainActivity_Intro extends AppCompatActivity implements View.OnClickListener {



    private EditText edt_search;
    private TextView btn_test;
    private ImageButton imgb_english , imgb_japan , imgb_favour , img_setting;
    private ListView lst_danhsach_tu;
    private Button btn_search;
    private Adapter_danhsachtu adapter_danhsachtu;
    private ArrayList<JapanDic_English> japanDic_englishArrayList;
    SqliteHelper_Query exec ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__intro);
        exec = new SqliteHelper_Query(getApplicationContext());


        img_setting.setOnClickListener(this);
        imgb_english.setOnClickListener(this);
        imgb_favour.setOnClickListener(this);
        imgb_japan.setOnClickListener(this);
        Loadcontrol();


////    LoadAdapter_dstu();



    }




  /*  private void LoadAdapter_dstu() {

        exec = SqliteHelper_Query.getInst(this);
        japanDic_englishArrayList = exec.getDanhsach();
        Adapter_danhsachtu arrayAdapter = new Adapter_danhsachtu(this,R.layout.custom_listview,japanDic_englishArrayList);
        lst_danhsach_tu.setAdapter(arrayAdapter);
    }*/


    private void Loadcontrol() {
        japanDic_englishArrayList =new  ArrayList<JapanDic_English>();
        edt_search = (EditText) findViewById(R.id.edt_search);
        lst_danhsach_tu = (ListView) findViewById(R.id.lst_word);
        btn_search = (Button) findViewById(R.id.btn_search);

        imgb_english = (ImageButton) findViewById(R.id.btn_word_english);
        imgb_japan = (ImageButton) findViewById(R.id.btn_word_japan);
        imgb_favour = (ImageButton) findViewById(R.id.btn_word_favourite);
        img_setting = (ImageButton) findViewById(R.id.btn_setting);

    }

        @Override
        public void onClick(View view) {
            android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            Fragment fragment = null;
            switch (view.getId())
                
        }
    }
