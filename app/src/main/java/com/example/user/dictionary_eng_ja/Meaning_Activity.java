package com.example.user.dictionary_eng_ja;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.user.dictionary_eng_ja.Object.JapanDic_English;

/**
 * Created by Tung Lam on 15-Nov-16.
 */

public class Meaning_Activity extends AppCompatActivity {
    private TextView txt_word, txt_meaning, txt_note;
    private JapanDic_English japanDic_english;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail);
        Loadcontrol();
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
    }
}
