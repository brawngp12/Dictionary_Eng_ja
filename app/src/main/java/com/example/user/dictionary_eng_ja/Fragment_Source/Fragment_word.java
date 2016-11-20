package com.example.user.dictionary_eng_ja.Fragment_Source;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.dictionary_eng_ja.Object.JapanDic_English;
import com.example.user.dictionary_eng_ja.R;

/**
 * Created by Tung Lam on 07-Nov-16.
 */

public class Fragment_word extends android.support.v4.app.Fragment {
    public Fragment_word() {
    }
    private TextView fragment_wordenglist ,fragment_wordjapanese;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_word , container,false);
        fragment_wordenglist = (TextView) v.findViewById(R.id.fragment_wordenglish);
        fragment_wordjapanese = (TextView) v.findViewById(R.id.fragment_wordjapanese);

        Intent b = getActivity().getIntent();
        final JapanDic_English tu = (JapanDic_English) b.getSerializableExtra("tuchon");
        fragment_wordjapanese.setText(tu.getENG_MEAN());
        fragment_wordenglist.setText(tu.getENG_WORD());
        return v;

    }
}
