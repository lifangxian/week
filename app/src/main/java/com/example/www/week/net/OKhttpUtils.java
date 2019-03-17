package com.example.www.week.net;

import android.os.Handler;
import android.os.Message;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OKhttpUtils {
    private int HTTP_SUCCESS=1000;
    private int HTTP_FAIL=1001;
    private Httplisenter httplisenter;
    public OKhttpUtils get(String url){
        dohttp(url,0,null);
        return this;
    }
    public OKhttpUtils post(String url,FormBody.Builder bodybuilder){
        dohttp(url,1,bodybuilder);
        return this;
    }

    private void dohttp(String url, int i,FormBody.Builder bodybuilder) {
        //网络请求
        OkHttpClient client=new OkHttpClient();


        Request.Builder builder = new Request.Builder();
        builder.url(url);
        if(i==0){
            builder.get();
        }else{
            RequestBody body=bodybuilder.build();

            builder.post(body);
        }
        Request request = builder.build();
        final Message message=new Message();
        client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        message.what=HTTP_FAIL;
                        handler.sendMessage(message);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        message.what=HTTP_SUCCESS;
                        message.obj=response.body().string();
                        handler.sendMessage(message);
                    }
                });
    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==HTTP_SUCCESS){
                String obj = (String) msg.obj;
                httplisenter.success(obj);
            }else {
                httplisenter.fail();
            }
        }
    };

    public void result(Httplisenter httplisenter) {
        this.httplisenter = httplisenter;
    }

    public interface Httplisenter{
        void success(String data);
        void fail();
    }


}
