package com.example.azkarelmoslem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.azkarelmoslem.models.Azkar_Content;
import com.example.azkarelmoslem.models.Zekr;
import com.example.azkarelmoslem.network.Api_sabah_interface;
import com.example.azkarelmoslem.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


}
