package com.example.authenticatewithapi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    MaterialTextView mtv, lblOutput;
    TextInputEditText fname, lname, email;
    MaterialButton submit;
    HashMap<String, String> hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtv = findViewById(R.id.mtv);
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fname.getText().toString() == "") {
                    Toast.makeText(MainActivity.this, "Enter Firstname", Toast.LENGTH_SHORT).show();
                } else if (lname.getText().toString() == "") {
                    Toast.makeText(MainActivity.this, "Enter Lastname", Toast.LENGTH_SHORT).show();
                } else {
                    PostMethod apiInterface = RetrofitClient.getRetrofit().create(PostMethod.class);
                    hashMap.put("firstName", fname.getText().toString());
                    hashMap.put("lastName", lname.getText().toString());
                    Call<RegistraionModel> registrationModelCall = apiInterface.getRegistrationModelCall(hashMap);
                    registrationModelCall.enqueue(new Callback<RegistraionModel>() {
                        @Override
                        public void onResponse(Call<RegistraionModel> call, @NonNull Response<RegistraionModel> response) {
//                            Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                            Log.d("TAG", "onResponse: Main Activity Successfully Done " + response.body());
                            SharedPreferences sp = getSharedPreferences("spfirst", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putString("firstName", fname.getEditableText().toString());
                            editor.putString("lastName", lname.getEditableText().toString());
                            editor.commit();
                            Intent intent = new Intent(MainActivity.this, Home.class);
                            startActivity(intent);

                        }

                        @Override
                        public void onFailure(Call<RegistraionModel> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Errorr....", Toast.LENGTH_SHORT).show();
                            Log.e("Error", "onFailure: Something Went Wrong" + t.getLocalizedMessage());
                        }
                    });
                }
            }
        });

    }
}