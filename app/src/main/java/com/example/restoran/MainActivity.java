package com.example.restoran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {

    ListView superListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listmenu);
//        Spinner spinnerLanguages=findViewById(R.id.list_resto);

        superListView = findViewById(R.id.mobile_list);
        getSuperMenu();
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.list_location, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
    }

    private void getSuperMenu() {
        Call<List<Results>> call = RetrofitClient.getInstance().getMyApi().getSuperMenu();
        call.enqueue(new Callback<List<Results>>() {
            @Override
            public void onResponse(Call<List<Results>> call, Response<List<Results>> response) {
                List<String> arrayList = new ArrayList<String>();
                List<Results> foodMenuList = response.body();
                String[] nameFood = new String[foodMenuList.size()];
                String[] priceFood = new String[foodMenuList.size()];
                String[] detailsFood = new String[foodMenuList.size()];

                for(int i=0; i<foodMenuList.size(); i++) {
                    nameFood[i] = foodMenuList.get(i).getFoodName();
                    priceFood[i] = foodMenuList.get(i).getPrice();
                    detailsFood[i] = foodMenuList.get(i).getDetails();
                    arrayList.add("Nama\t\t: " + nameFood[i] + "\nHarga\t\t: " + priceFood[i] + "\nDetail\t\t: " + detailsFood[i]);
                }
                superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList
                ));
            }
            @Override
            public void onFailure(Call<List<Results>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }
        });
    }
}