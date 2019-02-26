package com.example.a.checkattendance;

import android.util.Log;

import com.google.gson.JsonObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpUtil {
    public static final MediaType JSON=MediaType.parse("application/json; charset=utf-8");

    public static void sendLoginRequest(String address,String json,okhttp3.Callback callback){
        RequestBody body = RequestBody.create(JSON,json);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static String createLoginJson(String choice,String account,String password){
        JsonObject jsonObject= new JsonObject();
        jsonObject.addProperty(choice+"id",account);
        jsonObject.addProperty(choice+"password",password);
        Log.d("test",jsonObject.toString());
        return jsonObject.toString();
    }
}
