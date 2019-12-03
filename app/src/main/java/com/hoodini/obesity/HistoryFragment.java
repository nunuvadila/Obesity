package com.hoodini.obesity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {
//    private DatabaseReference database;
//    private RecyclerView rvView;
//    private RecyclerView.Adapter adapter;
//    private RecyclerView.LayoutManager layoutManager;
//    private ArrayList<ListDataDiri> daftarIdentitas;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_history_fragment,
                container, false);
//        rvView = view.findViewById(R.id.rv_main);
//        rvView.setHasFixedSize(true);
//        rvView.setLayoutManager(layoutManager);
//        database = FirebaseDatabase.getInstance().getReference();
//        database.child("tabelLaki").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                daftarIdentitas = new ArrayList<>();
//                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()){
//                    ListDataDiri listDataDiri = noteDataSnapshot.getValue(ListDataDiri.class);
//                    listDataDiri.setKey(noteDataSnapshot.getKey());
//                    daftarIdentitas.add(listDataDiri);
//                }
//                adapter = new AdapterIdentitasRecyclerView(daftarIdentitas, HistoryFragment.this);
//                rvView.setAdapter(adapter);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                System.out.println(databaseError.getDetails()+ " "+ databaseError.getMessage());
//            }
//        });
        return view;
    }
//    public static Intent getActIntent(Activity activity){
//        Intent intent = new Intent(activity, HistoryFragment.class);
//        return intent;
//    }
}
