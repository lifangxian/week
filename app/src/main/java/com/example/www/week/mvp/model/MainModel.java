package com.example.www.week.mvp.model;

public interface MainModel {
    interface Callbanck{
        void success(String data);
        void fail();
    }
    void getData(Callbanck callbanck);
}
