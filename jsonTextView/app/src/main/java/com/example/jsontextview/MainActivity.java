package com.example.jsontextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.textView1);
        TextView findtextView = (TextView) findViewById(R.id.findDustTextView);
        TextView ultrafindtextView = (TextView) findViewById(R.id.ultraFineDustTextView);
        TextView No2textView = (TextView) findViewById(R.id.NO2TextView);
        TextView NotextView = (TextView) findViewById(R.id.NOTextView);
        String findDust = null;
        String ultraFindDust = null;
        String No2 = null;
        String No = null;
        Log.d("findDust","findDust");

        String[] arraysum = new String[8];
        String resultText = "NULL";
        try {
            resultText = new Task().execute().get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        textView.setText(resultText);
        int start=resultText.indexOf("pm10Value");
        int end=resultText.indexOf("pm10Grade");
        findDust=resultText.substring(start+11,end-2);
         start=resultText.indexOf("pm25Value");
         end=resultText.indexOf("pm25Grade");
        ultraFindDust=resultText.substring(start+11,end-2);
        start=resultText.indexOf("no2Value");
        end=resultText.indexOf("no2Grade");
        No2=resultText.substring(start+10,end-2);
        start=resultText.indexOf("coValue");
        end=resultText.indexOf("coGrade");
        No=resultText.substring(start+9,end-2);
        findtextView.setText(findDust);
        ultrafindtextView.setText(ultraFindDust);
        No2textView.setText(No2);
        NotextView.setText(No);
    }
    public class Task extends AsyncTask<String, Void, String> {

        //  String clientKey = " ";

        private String str, receiveMsg;
        private final String ID = " ";
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