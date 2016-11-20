package com.example.user.dictionary_eng_ja.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.user.dictionary_eng_ja.Object.JapanDic_English;
import com.example.user.dictionary_eng_ja.R;

import java.util.List;

/**
 * Created by Tung Lam on 04-Nov-16.
 */

public class Adapter_danhsachtu extends ArrayAdapter<JapanDic_English> {
    private  Context context ;
    private int resource ;
    private List<JapanDic_English> objects;

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(resource,null);
        if(objects != null)
        {
            TextView txt_lst_danhsach = (TextView) convertView.findViewById(R.id.txt_lst_danhsach);
            JapanDic_English japanDic_english1;
            japanDic_english1 = objects.get(position);
            txt_lst_danhsach.setText(japanDic_english1.getENG_WORD());
          ///  objects.remove(position);
            notifyDataSetChanged();


        }
        else
        {
            Log.d("Error","RIP");
        }


        return convertView;
    }

    public Adapter_danhsachtu(Context context, int resource, List<JapanDic_English> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

}
