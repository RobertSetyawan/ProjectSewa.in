package com.example.robert.projectsewamobil;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Robert on 20/12/2017.
 */

public class MobilHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView namamobil;
    public ImageView gambarmobil;

    private ItemClickListener itemClickListener;

    public MobilHolder(View itemView) {
        super(itemView);
        namamobil = (TextView)itemView.findViewById(R.id.namamobil);
        gambarmobil = (ImageView) itemView.findViewById(R.id.gambarmobil);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
