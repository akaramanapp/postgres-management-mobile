package com.postgresmanagement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.postgresmanagement.Adapter.TableManageListAdapter;
import com.postgresmanagement.Model.TableManage;
import com.postgresmanagement.Service.Services;
import com.postgresmanagement.Util.ApiClient;
import com.postgresmanagement.databinding.FragmentFirstBinding;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {

    private FragmentFirstBinding binding;

    private RecyclerView recyclerView;

    Services services;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        getData(binding.recyclerview);
        return binding.getRoot();

    }

    private void getData(View view) {
        services = ApiClient.createService(Services.class);
        Call<List<TableManage>> call = services.getTable();
        call.enqueue(new Callback<List<TableManage>>() {
            @Override
            public void onResponse(Call<List<TableManage>> call, Response<List<TableManage>> response) {
                recyclerView = view.findViewById(R.id.recyclerview);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                recyclerView.setAdapter(new TableManageListAdapter(response.body(), MainFragment.this));
            }

            @Override
            public void onFailure(Call<List<TableManage>> call, Throwable t) {
                System.out.print("hata");
            }
        });
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}