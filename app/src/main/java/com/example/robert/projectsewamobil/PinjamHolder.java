package com.example.robert.projectsewamobil;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;

/**
 * Created by Robert on 20/12/2017.
 */

public class PinjamHolder extends RecyclerView.ViewHolder {

    public TextView namauserpinjam;
    public TextView jenismobil;
    public TextView tanggal;

    public PinjamHolder(View itemView) {
        super(itemView);

        namauserpinjam = (TextView)itemView.findViewById(R.id.namauserpinjam);
        jenismobil = (TextView)itemView.findViewById(R.id.jenismobil);
        tanggal = (TextView)itemView.findViewById(R.id.tanggalpinjam);
    }
}
