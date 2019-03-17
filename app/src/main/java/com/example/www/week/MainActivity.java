package com.example.www.week;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.www.week.bean.JavaBEAN;
import com.example.www.week.bean.LtemList;
import com.example.www.week.bean.Result;
import com.example.www.week.mvp.model.Mainmodeliml;
import com.example.www.week.mvp.presenter.MainPresenteriml;
import com.example.www.week.mvp.view.MainView;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenteriml mainPresenteriml;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenteriml = new MainPresenteriml(new Mainmodeliml(),this);
        mainPresenteriml.doData();
        recyclerView = findViewById(R.id.recycler);
        //布局管理器
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void success(String data) {
        Log.d("bb",data);
        Gson gson=new Gson();
        JavaBEAN javaBEAN = gson.fromJson(data, JavaBEAN.class);
        Result result = javaBEAN.getResult();
        ArrayList<LtemList> itemList = result.getItemList();
        Log.d("sss",itemList.toString());
    }

    @Override
    public void fail() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenteriml.destory();
    }
}
