    package com.example.user.dictionary_eng_ja;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.user.dictionary_eng_ja.Adapter.Adapter_danhsachtu;
import com.example.user.dictionary_eng_ja.Fragment_Source.Fragment_favourite;
import com.example.user.dictionary_eng_ja.Fragment_Source.Fragment_listword;
import com.example.user.dictionary_eng_ja.Fragment_Source.Fragment_listword_japan;
import com.example.user.dictionary_eng_ja.Object.JapanDic_English;
import com.example.user.dictionary_eng_ja.Sqlite_build.SqliteHelper_Query;

import java.util.ArrayList;

    public class MainActivity_Intro extends AppCompatActivity implements View.OnClickListener{




    private TextView btn_test ,edt_search;
    private Button btn_word_english , btn_word_japan , btn_word_favourite , btn_setting ;
    private ListView lst_danhsach_tu;
    private Button btn_search;
    private Adapter_danhsachtu adapter_danhsachtu;
    private ArrayList<JapanDic_English> japanDic_englishArrayList;
    SqliteHelper_Query exec ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main__intro);


        exec = new SqliteHelper_Query(getApplicationContext());
        Loadcontrol();
        android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        Fragment fragment = new Fragment_listword();
        fragmentTransaction.replace(R.id.layout_fragment, fragment);
        fragmentTransaction.commit();

        btn_word_english.setOnClickListener(this);
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT, "Japanese Dictionary");
                    String sAux = "\nLet me recommend you this application\n\n";
                    sAux = sAux + "https://play.google.com/store/apps/details?id=Orion.Soft \n\n";
                    i.putExtra(Intent.EXTRA_TEXT, sAux);
                    startActivity(Intent.createChooser(i, "Select one of those"));

                } catch (Exception e) {
                }
            }
        });
        btn_word_japan.setOnClickListener(this);
        btn_word_favourite.setOnClickListener(this);
        edt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity_Intro.this, Search_Activity.class);
                startActivity(intent);
            }
        });

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
        edt_search = (TextView) findViewById(R.id.edt_search);
        lst_danhsach_tu = (ListView) findViewById(R.id.lst_word);
        btn_search = (Button) findViewById(R.id.btn_search);
        btn_word_english = (Button) findViewById(R.id.btn_word_english);
        btn_word_japan = (Button) findViewById(R.id.btn_word_japan);
        btn_word_favourite = (Button) findViewById(R.id.btn_word_favourite);
        btn_setting = (Button) findViewById(R.id.btn_setting);

    }


        @Override
        public void onClick(View view) {
            android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            Fragment fragment = null;
            switch (view.getId())
            {
               case R.id.btn_word_english:
                    fragment = new Fragment_listword();
                    break;
                case R.id.btn_word_japan:
                    fragment = new Fragment_listword_japan();
                    break;
                case R.id.btn_word_favourite:
                    fragment = new Fragment_favourite();
                    break;


            }
            fragmentTransaction.replace(R.id.layout_fragment, fragment);
            fragmentTransaction.commit();
        }

    }

