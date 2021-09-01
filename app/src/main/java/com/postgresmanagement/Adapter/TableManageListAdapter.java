package com.postgresmanagement.Adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.postgresmanagement.Dto.CreateTableResponeDto;
import com.postgresmanagement.Model.TableManage;
import com.postgresmanagement.R;
import com.postgresmanagement.Recycler.RecyclerViewHolder;
import com.postgresmanagement.Service.Services;
import com.postgresmanagement.TableManageFragment;
import com.postgresmanagement.Util.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TableManageListAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private List<TableManage> _tables;
    private Fragment _fragment;

    public TableManageListAdapter(List<TableManage> tables, Fragment fragment) {
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
        holder.getView().setText(String.valueOf(_tables.get(position).getTablename()));
        holder.getView().setOnClickListener(v -> {
            int id = _tables.get(holder.getAdapterPosition()).getId();
            Bundle bundle = new Bundle();
            bundle.putInt("id", id);
            refreshBlockOverlay(position);

            NavHostFragment.findNavController(_fragment)
                    .navigate(R.id.action_FirstFragment_to_tableDetailFragment, bundle);
        });


        holder.getButton().setOnClickListener(v -> {
            int id = _tables.get(holder.getAdapterPosition()).getId();
            Services services = ApiClient.createService(Services.class);
            Call<Void> call = services.deleteTable(String.valueOf(id));
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    _tables.remove(holder.getAdapterPosition());
                    notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    System.out.print(t.toString());
                }
            });
        });
    }

    public void refreshBlockOverlay(int position) {
        notifyItemChanged(position);
    }

    @Override
    public int getItemCount() {
        return _tables.size();
    }
}
