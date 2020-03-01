package com.test.http;

public class Request {

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "body=%7B%22name%22%3A123%7D");
        Request request = new Request.Builder()
                .url("http://localhost:8081/user?id=123")
                .get()
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "3600dd9e-c7ab-37fd-cb7c-92f5f4337367")
                .build();

        Response response = client.newCall(request).execute();
    }
}
