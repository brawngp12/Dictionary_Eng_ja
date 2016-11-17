package com.example.user.dictionary_eng_ja.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.dictionary_eng_ja.Fragment_Source.Fragment_favourite;
import com.example.user.dictionary_eng_ja.Meaning_Activity;
import com.example.user.dictionary_eng_ja.Object.JapanDic_English;
import com.example.user.dictionary_eng_ja.R;
import com.example.user.dictionary_eng_ja.Sqlite_build.SqliteHelper_Query;

import java.util.List;

/**
 * Created by Tung Lam on 13-Nov-16.
 */

public class Adapter_danhsach_favour extends ArrayAdapter<JapanDic_English> {
    private Context context ;
    private int resource ;
    private List<JapanDic_English> objects;
    SqliteHelper_Query exec   ;

    private JapanDic_English japanDic_english1;
    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(resource,null);
        if(objects != null)
        {
            TextView txt_lst_danhsach_favour = (TextView) convertView.findViewById(R.id.txt_lst_danhsach_favour);
            JapanDic_English japanDic_english1;
            japanDic_english1 = objects.get(position);
            txt_lst_danhsach_favour.setText(japanDic_english1.getENG_WORD());

        }

        else
        {
            Log.d("Error","RIP");
        }

        final Button btn_favour = (Button) convertView.findViewById(R.id.btn_favour);
        btn_favour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JapanDic_English t;
//                t = view.get(position);
                Button btnFavour = (Button) view.findViewById(R.id.btn_favour);
                btn_favour.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        final AlertDialog.Builder alertDialog=new AlertDialog.Builder(getContext());
                        alertDialog.setTitle("Chọn chức năng");
                        AlertDialog.Builder  diag_update = new AlertDialog.Builder(getContext());
                        alertDialog.setNegativeButton("Xóa bookmark", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                exec = new SqliteHelper_Query(getContext());
                                japanDic_english1 = objects.get(position);
                                if(exec.deletebookmark(japanDic_english1.getID_ENG()) == true)
                                {
                                    Toast.makeText(getContext()," Remove bookmark is complete ",Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                                else
                                    Toast.makeText(getContext()," Fail to remove ",Toast.LENGTH_SHORT).show();


                            }
                        });
                        alertDialog.show();


                    }
                });


//
            }
        });





        notifyDataSetChanged();
        return convertView;
    }

    public Adapter_danhsach_favour(Context context, int resource, List<JapanDic_English> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }
}
