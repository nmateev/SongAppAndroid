package com.wasp.songapp.http;

import com.wasp.songapp.http.base.HttpRequester;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpHttpRequester implements HttpRequester {


    public OkHttpHttpRequester() {

    }

    @Override
    public String get(String url) throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        String body = response
                .body()
                .string();

        return body;
    }

    @Override
    public void post(String url, String bodyString) throws IOException {

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"),
                bodyString);

        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();

        client
                .newCall(request)
                .execute();

    }

    @Override
    public void delete(String url, int id) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .delete()
                .url(url)
                .build();

        client
                .newCall(request)
                .execute();

    }

    @Override
    public void update(String url, int id) throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .method("PUT", null)
                .url(url)
                .build();

        client
                .newCall(request)
                .execute();

    }
}
