package com.hoodini.obesity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private ArrayList<News> mNewsData;
    private RecyclerView mRecyclerView;
    private AdapterNews mAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_home_fragment,
                container, false);

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mNewsData = new ArrayList<>();
        mAdapter = new AdapterNews(getContext(),mNewsData);
        mRecyclerView.setAdapter(mAdapter);

        Initialize();
        return view;
    }
    public void Initialize(){
        String[] fiturList = getResources()
                .getStringArray(R.array.judul_card);
        String[] fiturInfo = getResources()
                .getStringArray(R.array.judul_card);
        TypedArray fiturImageResources = getResources()
                .obtainTypedArray(R.array.images);

        // Clear the existing data (to avoid duplication).
        mNewsData.clear();

        // Create the ArrayList of Sports objects with the titles and
        // information about each sport
        for (int i = 0; i < fiturList.length; i++) {
            mNewsData.add(new News(fiturList[i], fiturInfo[i],
                    fiturImageResources.getResourceId(i, 0)));
        }

        // Recycle the typed array.
        fiturImageResources.recycle();

        // Notify the adapter of the change.
        mAdapter.notifyDataSetChanged();
    }
}
