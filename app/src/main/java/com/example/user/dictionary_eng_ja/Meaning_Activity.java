package com.example.user.dictionary_eng_ja;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

import com.example.user.dictionary_eng_ja.Object.JapanDic_English;

/**
 * Created by Tung Lam on 15-Nov-16.
 */

public class Meaning_Activity extends AppCompatActivity {
    private Toolbar toolbar1;
    private TextView txt_word, txt_meaning, txt_note;
    private JapanDic_English japanDic_english;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_detail);
        Loadcontrol();
        setSupportActionBar(toolbar1);
       //// getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Hitextra();

    }
    private void Hitextra() {
        Intent intent = this.getIntent();
        japanDic_english = (JapanDic_English) intent.getSerializableExtra("tuchon");
        txt_word.setText(japanDic_english.getENG_WORD());
        txt_meaning.setText(japanDic_english.getENG_MEAN());
        txt_note.setText(japanDic_english.getENG_NOTE());
    }
    private void Loadcontrol() {
        txt_word = (TextView) findViewById(R.id.txt_word);
        txt_meaning = (TextView) findViewById(R.id.txt_meaning);
        txt_note = (TextView) findViewById(R.id.txt_note);
        toolbar1 = (Toolbar) findViewById(R.id.layout_tbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.update_menu )
        {
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}
