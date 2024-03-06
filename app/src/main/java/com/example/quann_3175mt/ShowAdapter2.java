package com.example.quann_3175mt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ShowAdapter2 extends BaseAdapter {
    List<Show> adapterShowList2;

    public ShowAdapter2(List<Show> adapterShowList2) {
        this.adapterShowList2 = adapterShowList2;
    }

    @Override
    public int getCount() {
        return adapterShowList2.size();
    }

    @Override
    public Object getItem(int i) {
        return adapterShowList2.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_showitem2,parent,false);
        }

        TextView txtViewShowName2 = convertView.findViewById(R.id.txtViewShowName2);
        ImageView imgViewShowItem2 = convertView.findViewById(R.id.imgViewShowItem2);
        TextView txtViewShowPrice2 = convertView.findViewById(R.id.txtViewShowPrice2);
        ImageView imgViewPlay = convertView.findViewById(R.id.imgViewPlay);

        txtViewShowName2.setText(adapterShowList2.get(position).getShowName());
        imgViewShowItem2.setImageResource(adapterShowList2.get(position).getShowImage());

        return convertView;
    }
}
