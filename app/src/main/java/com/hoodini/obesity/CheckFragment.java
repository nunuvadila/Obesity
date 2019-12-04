package com.hoodini.obesity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class CheckFragment extends Fragment {
    private String gender;
    private DatabaseReference database;
    private ArrayList<ListDataDiri> listDataDiris;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_check_fragment,
                container, false);
        final EditText nama = view.findViewById(R.id.editNama);
        final EditText tBadan = view.findViewById(R.id.editTbadan);
        final EditText berat = view.findViewById(R.id.editBeratBadan);
        final EditText lingkar = view.findViewById(R.id.editLingkar);
        final RadioGroup radioGroup = view.findViewById(R.id.gender);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = view.findViewById(selectedId);
                Log.d("tag", "radioButton.getText()" + radioButton.getText().toString());
                gender = radioButton.getText().toString();
            }
        });
        final TextView textView = view.findViewById(R.id.result);
        final Button btn = view.findViewById(R.id.checking);
        database = FirebaseDatabase.getInstance().getReference();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if (gender.equals("Laki - Laki")) {
                    final Query query = database.child("tabelLaki");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Log.e("Count ", "" + dataSnapshot.getChildrenCount());
                            listDataDiris = new ArrayList<>();
                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                ListDataDiri listDataDiri = ds.getValue(ListDataDiri.class);
                                listDataDiris.add(listDataDiri);
                            }
                            int index = 0;
                            for (int i=0;i<listDataDiris.size();i++){
                                if (listDataDiris.get(index).getTb().toString().equals(tBadan.getText().toString()) &&
                                        listDataDiris.get(index).getBb().toString().equals(berat.getText().toString())&&
                                        listDataDiris.get(index).getLp().toString().equals(lingkar.getText().toString())){
                                    textView.setText(listDataDiris.get(index).getKet());
                                    System.out.println(index+" "+listDataDiris.get(index).getKet());
                                } else {

                                }
                                System.out.println(i + "Index : "+ index);
                                index++;
                            }

//                            InputMethodManager inm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
//                            inm.hideSoftInputFromWindow(nama.getWindowToken(),0);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.e("The read failed: ", databaseError.getMessage());
                        }
                    });
                } else {
//                    database.child("tabelPerempuan").addValueEventListener(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                            for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()){
//                                ListDataDiri listDataDiri = noteDataSnapshot.getValue(ListDataDiri.class);
//                                listDataDiris.add(listDataDiri);
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError databaseError) {
//                            System.out.println(databaseError.getDetails()+" "+databaseError.getMessage());
//                        }
//                    });
                }
//                name = nama.getText().toString();
//                tB = tBadan.getText().toString();
//                bB = berat.getText().toString();
//                lp = lingkar.getText().toString();
//                nama.getText().clear();
//                tBadan.getText().clear();
//                berat.getText().clear();
//                lingkar.getText().clear();
//                textView.setText(name + " (" + gender + ") " + "dengan tinggi badan " + tB + " Cm, berat badan " + bB + " Kg dan lingkar perut " + lp + " Cm");
            }
        });
        return view;
    }

}
