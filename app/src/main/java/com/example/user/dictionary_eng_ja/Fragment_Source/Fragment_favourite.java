package com.example.user.dictionary_eng_ja.Fragment_Source;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.dictionary_eng_ja.Adapter.Adapter_danhsach_favour;
import com.example.user.dictionary_eng_ja.Meaning_Activity;
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


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_adapter_search , container,false);
        exec = SqliteHelper_Query.getInst(getActivity());
        japanDic_english = exec.getDanhsach_bookmark();
        final ListView listView = (ListView) v.findViewById(R.id.lst_word);
        listView.invalidateViews();
        Adapter_danhsach_favour arrayAdapter = new Adapter_danhsach_favour(getActivity(),R.layout.custom_lisview_favourite,japanDic_english);
        listView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), Meaning_Activity.class);
                JapanDic_English japanDic_english ;
                japanDic_english= (JapanDic_English) listView.getItemAtPosition(i);
                intent.putExtra("tuchon", japanDic_english);


                Fragment_favourite.this.startActivity(intent);

                /*String sSi = intent.toString();

                if(sSi != null) {
                    Toast.makeText(getActivity(), " Chuyển sang layout khác nào bookmark item ", Toast.LENGTH_SHORT).show();
                }*/
            }
        });
        return v;
    }
}
