package com.example.authenticatewithapi;

import static com.example.authenticatewithapi.RetrofitClient.getRetrofit;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity {
    TextView tv_getFname, tv_getLname;
    ArrayList<LinkedTreeMap> arrayList;
    ListView lv;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lv = findViewById(R.id.ll1);


//        SharedPreferences sharedPreferences = getSharedPreferences("spfirst", MODE_PRIVATE);
//        String firstName = sharedPreferences.getString("firstName", "");
//        String lastname = sharedPreferences.getString("lastName", "");
//        tv_getFname.setText(firstName);
//        tv_getLname.setText(lastname);

        System.out.println("+++++getRetrofit+++++" + getRetrofit());

        GetMethod getMethod = getRetrofit().create(GetMethod.class);
        Call<HashMap> call = getMethod.getData();
        System.out.println("======call=====" + call);

        call.enqueue(new Callback<HashMap>() {

            @Override
            public void onResponse(Call<HashMap> call, Response<HashMap> response) {
//                Object o = response.body();
                arrayList = (ArrayList<LinkedTreeMap>) response.body().get("users");
//                lv.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList));
//                arrayList.forEach((x) -> System.out.println(x.get("id")));
                lv.setAdapter(new BaseAdapter() {
                    @Override
                    public int getCount() {
                        return arrayList.size();
                    }

                    @Override
                    public Object getItem(int i) {
                        return null;
                    }

                    @Override
                    public long getItemId(int i) {
                        return 0;
                    }

                    @Override
                    public View getView(int i, View view, ViewGroup viewGroup) {
                        LinearLayout ll = (LinearLayout) getLayoutInflater().inflate(R.layout.show, null);
                        tv_getFname = ll.findViewById(R.id.tv_getFname);
                        tv_getLname = ll.findViewById(R.id.tv_getLname);

                        tv_getFname.setText((CharSequence) arrayList.get(i).get("firstName"));
                        tv_getLname.setText((CharSequence) arrayList.get(i).get("lastName"));

                        return ll;
                    }
                });
            }

            @Override
            public void onFailure(Call<HashMap> call, Throwable t) {

                Log.e("TAG ERROR", "onFailure: some thi...." + t.getLocalizedMessage());
            }
        });


//        System.out.println("+++++getMethod.getData()+++++" + getMethod.getData().request().body());
//        System.out.println("+++++getMethod.getData()+++++" + getMethod.getData().request().method());
//        call.enqueue(new Callback<RegistraionModel>() {
//            @Override
//            public void onResponse(Call<RegistraionModel> call, Response<RegistraionModel> response) {
//                ArrayList<RegistraionModel> registraionModelArrayList = response.body().getRegistrationModelArrayList();
//                if (registraionModelArrayList.isEmpty()) {
//                    Toast.makeText(Home.this, "List is Empty...", Toast.LENGTH_SHORT).show();
//                } else {
//                    for (int i = 0; i < registraionModelArrayList.size(); i++) {
//                        tv_getFname.append("First Name : " + registraionModelArrayList.get(i).getFname());
//                        tv_getLname.append("Last Name : " + registraionModelArrayList.get(i).getLname());
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<RegistraionModel> call, Throwable t) {
//                Log.e("ErrorTAG", "onFailure: " + t.getLocalizedMessage());
//            }
//        });
    }
}


//    ArrayList<RegistraionModel> registrationModelArrayListInstance = response.body().getRegistrationModelArrayList();
//
//                if (registrationModelArrayListInstance.isEmpty()) {
//                        Toast.makeText(Home.this, "Sorry ArrayList is Empty!!!", Toast.LENGTH_LONG).show();
//                        } else {
//
//        }


//===========================
//        registrationModelArrayList = response.body();
//        String[] names = new String[registrationModelArrayList.size()];
//        if (registrationModelArrayList != null) {
//        } else {
//            for (int i = 0; i <= registrationModelArrayList.size(); i++) {
//                names[i] = "First Name : " + registrationModelArrayList.get(i).getFname() + "\nLast Name : " + registrationModelArrayList.get(i).getLname();
//            }
//        }
//        lv1.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, names));