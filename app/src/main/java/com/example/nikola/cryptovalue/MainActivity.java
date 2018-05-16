package com.example.nikola.cryptovalue;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
    private iCrypto ICrypto;
    private Callback<Crypto> callback1;
    private Callback<Crypto> callback2;
    private Callback<Crypto> callback3;
    public TextView tvBit;
    public TextView tvEth;
    public TextView tvLtc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRestAdapter();
        searchForCrypto(new View(this));
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                searchForCrypto(new View(MainActivity.this));
                handler.postDelayed(this, 30000);
                Toast.makeText(MainActivity.this, "aaaaaa", Toast.LENGTH_LONG).show();
            }
        }, 30000);  //the time is in miliseconds


    }
    public void searchForCrypto(View view){

        String coin1 = "btc";
        String coin2 = "eth";
        String coin3 = "ltc";


            ICrypto.getCrypto1(coin1, callback1);
            ICrypto.getCrypto2(coin2, callback2);
            ICrypto.getCrypto3(coin3, callback3);

    }
    private void setupRestAdapter(){
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(iCrypto.ENDPOINT_URL).build();
        ICrypto = restAdapter.create(iCrypto.class);
        callback1 = new Callback<Crypto>() {
            @Override
            public void success(Crypto crypto, Response response) {
                String report = new String();
                if(crypto.getTicker() != null){
                    Ticker ticker = crypto.getTicker();
                        report=ticker.getPrice();
                        tvBit=(TextView)findViewById(R.id.tvBitcoin);
                        tvBit.setText(report);
                    } else {
                        report=("Error");
                    }

            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        };
        callback2 = new Callback<Crypto>() {
            @Override
            public void success(Crypto crypto, Response response) {
                String report = new String();
                if(crypto.getTicker() != null){
                    Ticker ticker = crypto.getTicker();
                    report=ticker.getPrice();
                    tvEth=(TextView)findViewById(R.id.tvEthernum);
                    tvEth.setText(report);
                } else {
                    report=("Error");
                }

            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        };
        callback3 = new Callback<Crypto>() {
            @Override
            public void success(Crypto crypto, Response response) {
                String report = new String();
                if(crypto.getTicker() != null){
                    Ticker ticker = crypto.getTicker();
                    report=ticker.getPrice();
                    tvLtc=(TextView)findViewById(R.id.tvLitecoin);
                    tvLtc.setText(report);
                } else {
                    report=("Error");
                }

            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        };
    }
}
