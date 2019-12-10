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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class CheckFragment extends Fragment {
    private String gender, Kesimpulan;
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
                            listDataDiris = new ArrayList<>();
                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                ListDataDiri listDataDiri = ds.getValue(ListDataDiri.class);
                                listDataDiris.add(listDataDiri);
                            }
                            int index = 0;
                            for (int i = 0; i < listDataDiris.size(); i++) {
                                if (listDataDiris.get(index).getTb().toString().equals(tBadan.getText().toString()) &&
                                        listDataDiris.get(index).getBb().toString().equals(berat.getText().toString()) &&
                                        listDataDiris.get(index).getLp().toString().equals(lingkar.getText().toString())) {
                                    double IMT = listDataDiris.get(index).getKes();
                                    System.out.println(index+" "+listDataDiris.get(index).getKet());
                                    if (IMT < 18.5){
                                        Kesimpulan = "Kurus (underweight)";
                                    }else if (IMT >= 18.5 && IMT < 25.0){
                                        Kesimpulan = "Normal (ideal)";
                                    }else if (IMT >= 25.0 && IMT < 30.0){
                                        Kesimpulan = "Kegemukan (overweight)";
                                    }else if (IMT >= 30.0 && IMT < 35.0){
                                        Kesimpulan = "Obesitas Tingkat 1";
                                    }else if (IMT >= 35.0 && IMT < 40.0){
                                        Kesimpulan = "Obesitas Tingkat 2";
                                    } else if (IMT >= 40.0){
                                        Kesimpulan = "Obesitas Tingkat 3";
                                    }
                                    textView.setText(listDataDiris.get(index).getKet() + " " + Kesimpulan);
                                } else {

                                }
//                                System.out.println(i + "Index : " + index);
                                index++;
                            }

                            InputMethodManager inm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                            inm.hideSoftInputFromWindow(nama.getWindowToken(), 0);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.e("The read failed: ", databaseError.getMessage());
                        }
                    });
                } else if(gender.equals("Perempuan")){
                    final Query query = database.child("tabelPerempuan");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            listDataDiris = new ArrayList<>();
                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                ListDataDiri listDataDiri = ds.getValue(ListDataDiri.class);
                                listDataDiris.add(listDataDiri);
                            }
                            int index = 0;
                            for (int i = 0; i < listDataDiris.size(); i++) {
                                if (listDataDiris.get(index).getTb().toString().equals(tBadan.getText().toString()) &&
                                        listDataDiris.get(index).getBb().toString().equals(berat.getText().toString()) &&
                                        listDataDiris.get(index).getLp().toString().equals(lingkar.getText().toString())) {
                                    double IMT = listDataDiris.get(index).getKes();
                                    System.out.println(index+" "+listDataDiris.get(index).getKet());
                                    if (IMT < 18.5){
                                        Kesimpulan = "Kurus (underweight)";
                                    }else if (IMT >= 18.5 && IMT < 25.0){
                                        Kesimpulan = "Normal (ideal)";
                                    }else if (IMT >= 25.0 && IMT < 30.0){
                                        Kesimpulan = "Kegemukan (overweight)";
                                    }else if (IMT >= 30.0 && IMT < 35.0){
                                        Kesimpulan = "Obesitas Tingkat 1";
                                    }else if (IMT >= 35.0 && IMT < 40.0){
                                        Kesimpulan = "Obesitas Tingkat 2";
                                    } else if (IMT >= 40.0){
                                        Kesimpulan = "Obesitas Tingkat 3";
                                    }
                                    textView.setText(listDataDiris.get(index).getKet() + " " + Kesimpulan);
                                } else {

                                }
                                index++;
                            }

                            InputMethodManager inm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                            inm.hideSoftInputFromWindow(nama.getWindowToken(), 0);
                        }

                        //
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.e("The read failed: ", databaseError.getMessage());
                        }
                    });
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
