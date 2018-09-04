package com.wasp.songapp.http.base;

import java.io.IOException;

public interface HttpRequester {

    String get(String url) throws IOException;

    String post(String url, String body) throws IOException;
}