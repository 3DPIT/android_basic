package com.example.currentposaddress;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private TextView textView1;
    private TextView textView2;
   String ilist = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.button1);
        textView1 = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView);
        final Geocoder geocoder = new Geocoder(this);

        final LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 위도,경도 입력 후 변환 버튼 클릭
                if ( Build.VERSION.SDK_INT >= 23 &&
                        ContextCompat.checkSelfPermission( getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {
                    ActivityCompat.requestPermissions( MainActivity.this, new String[] {  android.Manifest.permission.ACCESS_FINE_LOCATION  },
                            0 );
                }
                else {
                    Log.d("current_location", "현재 위치 찾기 시작");
                    Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    if (location == null) {
                        location = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    } else {

                        String provider = location.getProvider();
                        double longitude = location.getLongitude();
                        double latitude = location.getLatitude();
                        double altitude = location.getAltitude();
                        List<Address> list = null;
                        try {
                            double lat = (latitude);
                            double longi = (longitude);
                            list = geocoder.getFromLocation(
                                    lat, // 위도
                                    longi, // 경도
                                    10); // 얻어올 값의 개수
                        } catch (IOException e) {
                            e.printStackTrace();
                            Log.e("test", "입출력 오류 - 서버에서 주소변환시 에러발생");
                        }
                        if (list != null) {
                            if (list.size() == 0) {
                                textView1.setText("해당되는 주소 정보는 없습니다");
                            } else {
                                textView1.setText(list.get(0).toString());
                            }
                        }
                        Address ad = list.get(0);
                        String address =  ad.getAddressLine(0).toString()+"\n";

                        ilist=address;
                        textView2.setText("위치정보 : " + provider + "\n" +
                                "위도 : " + latitude + "\n" +
                                "경도 : " + longitude + "\n" +
                                "고도  : " + altitude+"\n"+
                                address);
                        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                                1000,
                                1,
                                gpsLocationListener);
                        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                                1000,
                                1,
                                gpsLocationListener);
                    }
                }
            }

        });

    }
    final LocationListener gpsLocationListener = new LocationListener() {
        public void onLocationChanged(Location location) {

            String provider = location.getProvider();
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            double altitude = location.getAltitude();
            textView2.setText("위치정보 : " + provider + "\n" +
                    "위도 : " + latitude + "\n" +
                    "경도 : " + longitude + "\n" +
                    "고도  : " + altitude+"\n"+
                    ilist);
        }
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        public void onProviderEnabled(String provider) {
        }

        public void onProviderDisabled(String provider) {
        }
    };
}


