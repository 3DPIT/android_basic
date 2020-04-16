package com.example.jsonaccept;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.pas);
        String resultText = "값이없음";

        try {
            resultText = new Task().execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        textView.setText(resultText);
    }
    public class Task extends AsyncTask<String, Void, String> {

      //  String clientKey = "#########################";

        private String str, receiveMsg;
        private final String ID = "########";
        @Override
        protected String doInBackground(String... params) {
            URL url = null;
            try {
                String lat = "35.123";
                String lng ="127.123";
                url = new URL("http://15.165.80.75:8080/v1/dashboard/air_pollution?lat="+lat+"&lng="+lng);

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
               // conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
              //  conn.setRequestProperty("x-waple-authorization", clientKey);
                if (conn.getResponseCode() == conn.HTTP_OK) {
                    InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    BufferedReader reader = new BufferedReader(tmp);
                    StringBuffer buffer = new StringBuffer();
                    while ((str = reader.readLine()) != null) {
                        buffer.append(str);
                    }
                    receiveMsg = buffer.toString();
                    Log.i("receiveMsg : ", receiveMsg);

                    reader.close();
                } else {
                    Log.i("통신 결과", conn.getResponseCode() + "에러");
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return receiveMsg;
        }
    }
}