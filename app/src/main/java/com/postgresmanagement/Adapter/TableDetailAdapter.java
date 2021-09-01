package com.postgresmanagement.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.postgresmanagement.Dto.TableDetailResponseDto;
import com.postgresmanagement.R;
import com.postgresmanagement.Recycler.RecyclerViewHolder;

import java.util.List;

public class TableDetailAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private List<TableDetailResponseDto> _tables;
    private Fragment _fragment;

    public TableDetailAdapter(List<TableDetailResponseDto> tables, Fragment fragment) {
        this._tables = tables;
        this._fragment = fragment;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.frame_textview;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.getView().setText(String.valueOf(_tables.get(position).getColumnname()));
        /*holder.getView().setOnClickListener(v -> {
            int id = _tables.get(holder.getAdapterPosition()).getId();
            Bundle bundle = new Bundle();
            bundle.putInt("id", id);


            NavHostFragment.findNavController(_fragment)
                    .navigate(R.id.action_FirstFragment_to_tableDetailFragment, bundle);
        });*/
    }

    @Override
    public int getItemCount() {
        return _tables.size();
    }
}
