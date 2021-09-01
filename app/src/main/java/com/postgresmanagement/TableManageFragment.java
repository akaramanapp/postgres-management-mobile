package com.postgresmanagement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.postgresmanagement.Adapter.ColumnAdapter;
import com.postgresmanagement.Dto.ColumnDto;
import com.postgresmanagement.Dto.CreateTableResponeDto;
import com.postgresmanagement.Dto.TableDto;
import com.postgresmanagement.Service.Services;
import com.postgresmanagement.Util.ApiClient;
import com.postgresmanagement.databinding.FragmentSecondBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TableManageFragment extends Fragment {

    private FragmentSecondBinding binding;

    private ArrayList<ColumnDto> columns = new ArrayList<>();

    ArrayAdapter<ColumnDto> columnAdaptor;

    TableDto tableDto = new TableDto();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        ListView list=(ListView) binding.columnTypeListView.findViewById(R.id.columnTypeListView);

        columnAdaptor = new ColumnAdapter(getActivity(), columns);
        list.setAdapter(columnAdaptor);

        // spinner
        Spinner dropdown = binding.columnTypeSpinner.findViewById(R.id.columnTypeSpinner);
        String[] items = new String[]{"SERIAL PRIMARY KEY", "TEXT", "INTEGER", "DATE"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.addColumn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText columnName = binding.columnName.findViewById(R.id.columnName);
                Spinner columnType = binding.columnTypeSpinner.findViewById(R.id.columnTypeSpinner);
                ColumnDto column = new ColumnDto();
                column.setColumnName(columnName.getText().toString());
                column.setColumnType(columnType.getSelectedItem().toString());
                column.setNullable(true);
                columns.add(column);
                columnAdaptor.notifyDataSetChanged();
            }
        });

        binding.complate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText tableName = binding.tableName.findViewById(R.id.tableName);
                tableDto.setColumns(columns);
                tableDto.setTableName(tableName.getText().toString());
                Services services = ApiClient.createService(Services.class);
                Call<CreateTableResponeDto> call = services.postTable(tableDto);
                call.enqueue(new Callback<CreateTableResponeDto>() {
                    @Override
                    public void onResponse(Call<CreateTableResponeDto> call, Response<CreateTableResponeDto> response) {
                        NavHostFragment.findNavController(TableManageFragment.this)
                              .navigate(R.id.action_SecondFragment_to_FirstFragment);
                    }

                    @Override
                    public void onFailure(Call<CreateTableResponeDto> call, Throwable t) {
                        System.out.print(t.toString());
                    }
                });
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}