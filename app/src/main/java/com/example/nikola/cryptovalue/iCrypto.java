package com.example.nikola.cryptovalue;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;


public interface iCrypto {
    public static final String ENDPOINT_URL = "https://api.cryptonator.com/api/ticker/";
    @GET("/btc-usd")
    void getCrypto1(@Query("coin1") String coin1, Callback<Crypto> callback);
    @GET("/eth-usd")
    void getCrypto2(@Query("coin2") String coin2, Callback<Crypto> callback);
    @GET("/ltc-usd")
    void getCrypto3(@Query("coin3") String coin3, Callback<Crypto> callback);

}


