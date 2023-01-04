package com.project.localez;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Sport extends Fragment {
    String apikey = "249e265624eb4b2c81406ca7a1db01dd";
    ArrayList<Model> modelArrayList;
    RecyclerViewAdapter adapter;
    String country="id";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.card, null);

        RecyclerView recyclerViewSports = v.findViewById(R.id.recycler);
        modelArrayList=new ArrayList<>();
        recyclerViewSports.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RecyclerViewAdapter(getContext(),modelArrayList);
        recyclerViewSports.setAdapter(adapter);

        findNews();
        return v;
    }

    private void findNews() {

        String category = "sports";
        API.getApiInterface().getCategoryNews(country, category, 70, apikey).enqueue(new Callback<Article>() {
            @Override
            public void onResponse(@NonNull Call<Article> call, @NonNull Response<Article> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    modelArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Article> call, @NonNull Throwable t) {}
        });
    }
}
