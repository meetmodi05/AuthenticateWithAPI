package com.example.authenticatewithapi;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity {
    ListView lv1;
    MaterialTextView mtvfname, mtvlname;
    ArrayList<RegistraionModel> registrationModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lv1 = findViewById(R.id.lv1);
        mtvfname = findViewById(R.id.mtv_fname);
        mtvlname = findViewById(R.id.mtv_lname);


        SharedPreferences sharedPreferences = getSharedPreferences("spfirst", MODE_PRIVATE);
        String firstName = sharedPreferences.getString("firstName", "");
        String lastname = sharedPreferences.getString("lastName", "");
        mtvfname.setText(firstName);
        mtvlname.setText(lastname);
        System.out.println("++++++++++++++++++++ABC++++++++++++++++++++++++" + registrationModelArrayList);
        GetMethod getMethod = RetrofitClient.getRetrofit().create(GetMethod.class);
        Call<RegistraionModel> call = getMethod.getData();
        call.enqueue(new Callback<RegistraionModel>() {
            @Override
            public void onResponse(@NonNull Call<RegistraionModel> call, @NonNull Response<RegistraionModel> response) {

                registrationModelArrayList = response.body().getRegistrationModelArrayList();
                String[] names = new String[registrationModelArrayList.size()];
                if (registrationModelArrayList != null) {
                } else {
                    for (int i = 0; i <= registrationModelArrayList.size(); i++) {
                        names[i] = "First Name : " + registrationModelArrayList.get(i).getFname() + "\nLast Name : " + registrationModelArrayList.get(i).getLname();
                    }
                }
                lv1.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, names));
            }

            @Override
            public void onFailure(@NonNull Call<RegistraionModel> call, Throwable t) {
                Toast.makeText(Home.this, "Error Occurred....", Toast.LENGTH_SHORT).show();
                Log.e("Error Tag", "onFailure: " + t.getLocalizedMessage());
            }
        });


    }
}