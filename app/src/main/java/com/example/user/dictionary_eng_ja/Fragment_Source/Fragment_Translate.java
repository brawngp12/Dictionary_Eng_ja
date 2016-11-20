package com.example.user.dictionary_eng_ja.Fragment_Source;

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
 * Created by Tung Lam on 17-Nov-16.
 */

public class Fragment_Translate extends  android.support.v4.app.Fragment {
    public Fragment_Translate() {
    }
    private TextView fragment_translate_text;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_translalte , container,false);
        fragment_translate_text = (TextView) v.findViewById(R.id.fragment_translate);

        Intent b = getActivity().getIntent();
        final JapanDic_English tu = (JapanDic_English) b.getSerializableExtra("tuchon");
        fragment_translate_text.setText(tu.getENG_PHIENAM());
        return v;
    }
}
