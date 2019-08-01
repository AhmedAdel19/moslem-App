package com.example.azkarelmoslem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.azkarelmoslem.Adapters.Azkar_Sabah_Adapter;
import com.example.azkarelmoslem.models.Azkar_Content;
import com.example.azkarelmoslem.models.Zekr;
import com.example.azkarelmoslem.network.Api_sabah_interface;
import com.example.azkarelmoslem.network.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Azkar_sabah_Activity extends AppCompatActivity
{

    ArrayList<Azkar_Content> AzkarList;
    Azkar_Sabah_Adapter azkar_sabah_adapter = null;
    RecyclerView zekrRecView;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkar_sabah_);

        AzkarList = new ArrayList<>();

        azkar_sabah_adapter = new Azkar_Sabah_Adapter(Azkar_sabah_Activity.this , R.layout.zekr_item_view , AzkarList);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext() , LinearLayoutManager.VERTICAL , false);
        zekrRecView = findViewById(R.id.recycler_View_Azkar_Sabah);
        zekrRecView.setHasFixedSize(true);
        zekrRecView.setItemAnimator(new DefaultItemAnimator());
        zekrRecView.setLayoutManager(linearLayoutManager);

        returnAllItems();
    }

    public void returnAllItems()
    {
        Api_sabah_interface api_interface = RetrofitClient.getClient().create(Api_sabah_interface.class);
        Call<Zekr> call = api_interface.get_azkar();
        call.enqueue(new Callback<Zekr>() {
            @Override
            public void onResponse(Call<Zekr> call, Response<Zekr> response) {
                if (response.isSuccessful()) {
                    Zekr azkar_contents = response.body();
                    AzkarList.clear();

                    AzkarList.addAll(azkar_contents.getContent());
                    zekrRecView.setAdapter(azkar_sabah_adapter);
                    azkar_sabah_adapter.notifyDataSetChanged();

//                    for(int i = 0 ; i < AzkarList.size() ; i++)
//                    {
//                        Log.v("Azkarrrrrrrrrrrrr" , AzkarList.get(i).getZekr());
//                        Toast.makeText(Azkar_sabah_Activity.this,AzkarList.get(i).getZekr() , Toast.LENGTH_SHORT).show();
//                    }


                } else {
                    int statusCode = response.code();
                    String messageCode = response.message();

                    Toast.makeText(Azkar_sabah_Activity.this, "code : " + String.valueOf(statusCode), Toast.LENGTH_SHORT).show();
                    Toast.makeText(Azkar_sabah_Activity.this, "Message : " + messageCode, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Zekr> call, Throwable t) {
                Log.e("error message is", t.getMessage());
            }
        });
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        azkar_sabah_adapter.notifyDataSetChanged();
    }
}
