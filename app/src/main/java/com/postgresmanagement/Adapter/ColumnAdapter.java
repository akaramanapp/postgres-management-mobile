package com.postgresmanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.postgresmanagement.Dto.ColumnDto;
import com.postgresmanagement.Model.Column;
import com.postgresmanagement.R;

import java.util.ArrayList;

public class ColumnAdapter extends ArrayAdapter<ColumnDto> {
    public ColumnAdapter(Context context, ArrayList<ColumnDto> columns) {
        super(context, 0, columns);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ColumnDto column = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_column, parent, false);
        }
        // Lookup view for data population
        TextView columnName = (TextView) convertView.findViewById(R.id.columnName);
        TextView columnType = (TextView) convertView.findViewById(R.id.columnType);
        // Populate the data into the template view using the data object
        columnName.setText(column.getColumnName());
        columnType.setText(column.getColumnType());
        // Return the completed view to render on screen
        return convertView;
    }
}