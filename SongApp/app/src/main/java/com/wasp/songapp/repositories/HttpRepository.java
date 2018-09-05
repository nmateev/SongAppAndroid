package com.wasp.songapp.repositories;

import com.wasp.songapp.http.base.HttpRequester;
import com.wasp.songapp.parsers.base.JsonParser;
import com.wasp.songapp.repositories.base.Repository;

import java.io.IOException;
import java.util.List;

public class HttpRepository<T> implements Repository<T> {

    private final HttpRequester mHttpRequester;
    private final String mServerUrl;
    private final JsonParser<T> mJsonParser;


    public HttpRepository(String serverUrl, HttpRequester httpRequester, JsonParser<T> jsonParser) {
        mServerUrl = serverUrl;
        mHttpRequester = httpRequester;
        mJsonParser = jsonParser;
    }


    @Override
    public void add(T item) throws IOException {

        String requestBody = mJsonParser.toJson(item);
        String postServerUrl = mServerUrl + "/new";
        mHttpRequester.post(postServerUrl, requestBody);
    }

    @Override
    public void delete(int id) throws IOException {
        String deleteServerUrl = mServerUrl + "/delete/" + id;

        mHttpRequester.delete(deleteServerUrl, id);

    }

    @Override
    public void update(int id) throws IOException {
        String updateServerUrl = mServerUrl + "/update/" + id;

        mHttpRequester.update(updateServerUrl, id);


    }

    @Override
    public T getById(int id) throws IOException {

        String itemJson = null;
        itemJson = mHttpRequester.get(mServerUrl + "/" + id);
        return mJsonParser.fromJson(itemJson);
    }

    @Override
    public List<T> getAll() throws IOException {


        String itemsJson = null;
        itemsJson = mHttpRequester.get(mServerUrl + "/get");
        return mJsonParser.fromJsonArray(itemsJson);

    }
}
