package com.example.user.dictionary_eng_ja.Fragment_Source;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.user.dictionary_eng_ja.Adapter.Adapter_danhsach_favour;
import com.example.user.dictionary_eng_ja.Object.JapanDic_English;
import com.example.user.dictionary_eng_ja.R;
import com.example.user.dictionary_eng_ja.Sqlite_build.SqliteHelper_Query;

import java.util.ArrayList;

/**
 * Created by Tung Lam on 07-Nov-16.
 */

public class Fragment_favourite extends android.app.Fragment {
    public Fragment_favourite() {
    }
    SqliteHelper_Query exec  ;
    ArrayList<JapanDic_English> japanDic_english = new ArrayList<JapanDic_English>() ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_adapter_search , container,false);
        exec = new SqliteHelper_Query(getActivity());
        japanDic_english = exec.getDanhsach_bookmark();
        ListView listView = (ListView) v.findViewById(R.id.lst_word);
        Adapter_danhsach_favour arrayAdapter = new Adapter_danhsach_favour(getActivity(),R.layout.custom_lisview_favourite,japanDic_english);
        listView.setAdapter(arrayAdapter);

        return v;
    }
}
