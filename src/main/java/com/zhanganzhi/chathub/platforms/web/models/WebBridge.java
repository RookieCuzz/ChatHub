package com.zhanganzhi.chathub.platforms.web.models;

import lombok.Getter;
import okhttp3.*;
import com.alibaba.fastjson2.JSON;

import java.io.IOException;

public class WebBridge {

    private final OkHttpClient okHttpClient;

    public WebBridge(){
        this.okHttpClient=new OkHttpClient();
    }

    public void addMessage2Web(ChatMessageDTO chatMessageDTO){

        String chatStr = JSON.toJSONString(chatMessageDTO);

        RequestBody body = RequestBody.create(chatStr, MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url("http://localhost:8081/web/chat/add-message")
                .post(body)
                .build();

        try (Response response = this.okHttpClient.newCall(request).execute()) {
            if (response.isSuccessful()) {
                System.out.println("Response: " + response.body().string());
            } else {
                System.out.println("Request failed: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
