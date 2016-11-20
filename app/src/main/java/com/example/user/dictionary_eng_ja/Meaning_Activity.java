package com.example.user.dictionary_eng_ja;

import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.dictionary_eng_ja.Fragment_Source.Fragment_Note;
import com.example.user.dictionary_eng_ja.Fragment_Source.Fragment_Translate;
import com.example.user.dictionary_eng_ja.Fragment_Source.Fragment_listword;
import com.example.user.dictionary_eng_ja.Fragment_Source.Fragment_word;
import com.example.user.dictionary_eng_ja.Object.JapanDic_English;
import com.example.user.dictionary_eng_ja.Sqlite_build.SqliteHelper_Query;

import java.util.List;

/**
 * Created by Tung Lam on 15-Nov-16.
 */

public class Meaning_Activity extends AppCompatActivity  implements View.OnClickListener {
    private Toolbar toolbar1;
    private TextView txt_word_dialog;
    private EditText edt_dialog_meaning;
    private JapanDic_English japanDic_english;
    private SqliteHelper_Query exec;
    private Dialog dialog_update_meaning , dialog_update_note;
    private Button btn_diag_update , btn_diag_cancel ;

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_detail);
        Loadcontrol();

        Intent intent = this.getIntent();
        japanDic_english = (JapanDic_English) intent.getSerializableExtra("tuchon");
     /*   txt_word.setText(japanDic_english.getENG_WORD());
        txt_meaning.setText(japanDic_english.getENG_MEAN());
        txt_note.setText(japanDic_english.getENG_NOTE());*/


        setSupportActionBar(toolbar1);
       //// getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        viewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

    }



    private void Loadcontrol() {
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.pager);
      /*  txt_word = (TextView) findViewById(R.id.txt_word);
        txt_meaning = (TextView) findViewById(R.id.txt_meaning);
        txt_note = (TextView) findViewById(R.id.txt_note); */
        toolbar1 = (Toolbar) findViewById(R.id.layout_tbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        final int id = item.getItemId();
        if(id == R.id.update_meaning)
        {
            dialog_update_meaning = new Dialog(this);
            dialog_update_meaning.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog_update_meaning.setContentView(R.layout.dialog_update_meaning);
           dialog_update_meaning.setCancelable(true); /// thuộc tính có khả năng back lại nghĩa là từ DIALOG  back to MEANING
            Window window = dialog_update_meaning.getWindow();

            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

            txt_word_dialog = (TextView) dialog_update_meaning.findViewById(R.id.txt_word_dialog);
            edt_dialog_meaning = (EditText) dialog_update_meaning.findViewById(R.id.edt_meaning_dialog);
            btn_diag_cancel = (Button) dialog_update_meaning.findViewById(R.id.btn_cancel_dialog);
            btn_diag_update = (Button) dialog_update_meaning.findViewById(R.id.btn_update_dialog);

            txt_word_dialog.setText(japanDic_english.getENG_WORD());
            btn_diag_cancel.setOnClickListener(this);
            btn_diag_update.setOnClickListener(this);

            dialog_update_meaning.show();


            return  true;
        }

        if(id == R.id.bookmark_menu)
        {
            exec = SqliteHelper_Query.getInst(this);
            if (exec.updatebookmark(japanDic_english))
            {

                Toast.makeText(getApplicationContext(),"Successfully added", Toast.LENGTH_SHORT).show();

            }

            return true;

        }
        if(id == R.id.bookmark_menu_delteall)
        {
            exec = SqliteHelper_Query.getInst(this);
            if (exec.removebookmarkto0())
            {
                Toast.makeText(getApplicationContext(),"Successfully delete all bookmark", Toast.LENGTH_SHORT).show();
            }
            return true;


        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if(view == btn_diag_update)
        {
            String meaning = edt_dialog_meaning.getText().toString();
            exec = SqliteHelper_Query.getInst(this);
           if(exec.update_note(meaning) == true)
           {
               Toast.makeText(getApplicationContext(),"UPDATE to"+meaning+" ", Toast.LENGTH_SHORT).show();
               ///Log.d("text",meaning);


           }
            else {
               Toast.makeText(getApplicationContext(), "UPDATE FAIL", Toast.LENGTH_SHORT).show();
               Log.d("err", "huhu");
           }
            dialog_update_meaning.dismiss();
        }
        if(view == btn_diag_cancel)
        {
            dialog_update_meaning.dismiss();
        }
    }


    public class SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment frag=null;
            switch (position) {
                case 0:
                    frag = new Fragment_word();
                    break;
                case 1 :
                    frag = new Fragment_Translate();
                    break;
                case 2 :
                    frag = new Fragment_Note();
                    break;

            }
            return frag;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title ="";
            switch (position) {
                case 0:
                    title="WORD";
                    break;
                case 1 :
                    title="TRANSLATE";
                    break;
                case 2 :
                    title ="NOTE";

            }
            return title;
        }
    }
}
