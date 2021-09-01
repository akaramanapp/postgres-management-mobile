package com.postgresmanagement.Recycler;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.postgresmanagement.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private TextView view;
    private ImageButton button;
    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView.findViewById(R.id.randomText);
        button = itemView.findViewById(R.id.deleteButton);
    }

    public TextView getView(){
        return view;
    }

    public ImageButton getButton(){
        return button;
    }
}
