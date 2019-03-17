package com.example.www.week.mvp.presenter;

import com.example.www.week.mvp.model.MainModel;
import com.example.www.week.mvp.view.MainView;

public class MainPresenteriml implements MainPresenter, MainModel.Callbanck {
    private MainModel mainModel;
    private MainView mainView;

    public MainPresenteriml(MainModel mainModel, MainView mainView) {
        this.mainModel = mainModel;
        this.mainView = mainView;
    }

    @Override
    public void doData() {
        mainModel.getData(this);
    }

    @Override
    public void success(String data) {
        mainView.success(data);
    }

    @Override
    public void fail() {
        mainView.fail();
    }
    //为了防止内存泄漏
    public void destory() {
        if(mainView!=null){
            mainView=null;
        }
        if(mainModel!=null){
            mainView=null;
        }
        //通知回收机制可以回收了
        System.gc();
    }
}
