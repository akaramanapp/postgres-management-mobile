package com.postgresmanagement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.postgresmanagement.Adapter.TableDetailAdapter;
import com.postgresmanagement.Dto.TableDetailResponseDto;
import com.postgresmanagement.Service.Services;
import com.postgresmanagement.Util.ApiClient;
import com.postgresmanagement.databinding.FragmentTableDetailBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TableDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TableDetailFragment extends Fragment {
    Services services;

    TableDetailAdapter adapter;

    private RecyclerView recyclerView;

    ArrayList<TableDetailResponseDto> tableDetailResponse;

    private FragmentTableDetailBinding binding;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TableDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TableDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TableDetailFragment newInstance(String param1, String param2) {
        TableDetailFragment fragment = new TableDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private void getData(View view, String id) {
        services = ApiClient.createService(Services.class);
        Call<ArrayList<TableDetailResponseDto>> call = services.getColumn(id);
        call.enqueue(new Callback<ArrayList<TableDetailResponseDto>>() {

            @Override
            public void onResponse(Call<ArrayList<TableDetailResponseDto>> call, Response<ArrayList<TableDetailResponseDto>> response) {
                tableDetailResponse = response.body();
                recyclerView = view.findViewById(R.id.recyclerview);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                recyclerView.setAdapter(new TableDetailAdapter(response.body(), TableDetailFragment.this));
            }

            @Override
            public void onFailure(Call<ArrayList<TableDetailResponseDto>> call, Throwable t) {
                System.out.print(t.toString());
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTableDetailBinding.inflate(inflater, container, false);
        Bundle bundle=getArguments();
        String id=bundle.get("id").toString();
        getData(binding.recyclerview, id);
        return binding.getRoot();
    }
}