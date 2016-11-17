package com.example.user.dictionary_eng_ja.Fragment_Source;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.dictionary_eng_ja.R;

/**
 * Created by Tung Lam on 17-Nov-16.
 */

public class Fragment_meaning extends  android.support.v4.app.Fragment {
    public Fragment_meaning() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_search,container,false);
    }
}
