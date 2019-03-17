package com.example.www.week.mvp.model;

import android.util.Log;

import com.example.www.week.net.OKhttpUtils;

public class Mainmodeliml implements MainModel{

    @Override
    public void getData(final Callbanck callbanck) {
        //请求数据
        new OKhttpUtils().get("https://api.apiopen.top/videoCategory?page=1").result(new OKhttpUtils.Httplisenter() {
            @Override
            public void success(String data) {

                callbanck.success(data);
            }

            @Override
            public void fail() {
                callbanck.fail();
            }
        });
    }
}
