package com.example.user.dictionary_eng_ja.Fragment_Source;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.dictionary_eng_ja.Object.JapanDic_English;
import com.example.user.dictionary_eng_ja.R;


/**
 * Created by Tung Lam on 17-Nov-16.
 */

public class Fragment_Note extends android.support.v4.app.Fragment {
    public Fragment_Note() {
    }
    private TextView fragment_note1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_note , container,false);
        fragment_note1 = (TextView) v.findViewById(R.id.fragment_note1);

        Intent b = getActivity().getIntent();
        final JapanDic_English tu = (JapanDic_English) b.getSerializableExtra("tuchon");
        fragment_note1.setText(tu.getENG_NOTE());
        return v;
    }
}
