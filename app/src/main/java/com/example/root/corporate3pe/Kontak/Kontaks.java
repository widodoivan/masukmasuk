package com.example.root.corporate3pe.Kontak;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.corporate3pe.AlamatKantor3pe.KantorJakarta;
import com.example.root.corporate3pe.AlamatKantor3pe.KantorSemarang;
import com.example.root.corporate3pe.AlamatKantor3pe.KantorSurabaya;
import com.example.root.corporate3pe.R;

public class Kontaks extends AppCompatActivity {

    // Kontak SURABAYA
    TextView phoneSBU;
    TextView waSBU;

        // Kontak JAKARTA
        TextView phoneJKT;
        TextView phoneJKTT;
        TextView phoneJKTMar;
        TextView waJKT;

            //Kontak SEMARANG
            TextView phoneSMR;

    //Kantor Surabaya
    LinearLayout kantorsurabaya;

        //Kantor Jakarta
        LinearLayout kantorJakarta;

            //Kantor Semarang
            LinearLayout kantorSemarang;


    private Context bundle;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontaks);


        kantorsurabaya = (LinearLayout) findViewById(R.id.kantorsurabaya);
        kantorsurabaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), KantorSurabaya.class);
                startActivity(intent);
            }
        });

    //////////          //////////

        kantorJakarta = (LinearLayout) findViewById(R.id.kantorjakarta);
        kantorJakarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), KantorJakarta.class);
                startActivity(intent);
            }
        });

    //////////          //////////

        kantorSemarang = (LinearLayout) findViewById(R.id.kantorSemarang);
        kantorSemarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), KantorSemarang.class);
                startActivity(intent);
            }
        });

//////////////////////////////                  //////////////////////////////

        phoneSBU = (TextView) findViewById(R.id.phoneSBU);
        assert phoneSBU != null;

        phoneSBU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final TextView isitelpon = (TextView) findViewById(R.id.phoneSBU);
                assert isitelpon != null;

                String nomere = isitelpon.getText().toString();
                if (nomere.isEmpty()) {

                    Toast.makeText(getApplicationContext(), "oke wes bener a nomere", Toast.LENGTH_SHORT).show();

                } else {

                    Intent masuk = new Intent(Intent.ACTION_CALL);
                    masuk.setData(Uri.parse("tel:" + nomere));

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                            Toast.makeText(getApplicationContext(), "Tunggu Sebentar", Toast.LENGTH_SHORT).show();
                            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 10);
                            return;
                        }
                    }

                    startActivity(masuk);
                }
            }
        });


//////////////////////////////                  //////////////////////////////

        waSBU = (TextView) findViewById(R.id.waSBU);
        waSBU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url="tel:08113478181";
                if (url.startsWith("tel:"))
                {
                    Intent intent = new Intent(Intent.ACTION_DIAL,
                            Uri.parse(url));
                    startActivity(intent);
                }

            }


        });


//////////////////////////////                  //////////////////////////////

        phoneJKT = (TextView) findViewById(R.id.phoneJKT);
        assert phoneJKT != null;

        phoneJKT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final TextView isitelpon = (TextView) findViewById(R.id.phoneJKT);
                assert isitelpon != null;

                String nomere = isitelpon.getText().toString();
                if (nomere.isEmpty()) {

                    Toast.makeText(getApplicationContext(), "oke wes bener a nomere", Toast.LENGTH_SHORT).show();

                } else {

                    Intent masuk = new Intent(Intent.ACTION_CALL);
                    masuk.setData(Uri.parse("tel:" + nomere));

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                            Toast.makeText(getApplicationContext(), "Tunggu Sebentar", Toast.LENGTH_SHORT).show();
                            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 10);
                            return;
                        }
                    }

                    startActivity(masuk);
                }
            }
        });

        //////////////////////////////                  //////////////////////////////

        phoneJKTT = (TextView) findViewById(R.id.phoneJKTT);
        assert phoneJKTT != null;

        phoneJKTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final TextView isitelpon = (TextView) findViewById(R.id.phoneJKTT);
                assert isitelpon != null;

                String nomere = isitelpon.getText().toString();
                if (nomere.isEmpty()) {

                    Toast.makeText(getApplicationContext(), "oke wes bener a nomere", Toast.LENGTH_SHORT).show();

                } else {

                    Intent masuk = new Intent(Intent.ACTION_CALL);
                    masuk.setData(Uri.parse("tel:" + nomere));

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                            Toast.makeText(getApplicationContext(), "Tunggu Sebentar", Toast.LENGTH_SHORT).show();
                            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 10);
                            return;
                        }
                    }

                    startActivity(masuk);
                }
            }
        });

        //////////////////////////////                  //////////////////////////////

        phoneJKTMar = (TextView) findViewById(R.id.phoneJKTMar);
        assert phoneJKTMar != null;

        phoneJKTMar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final TextView isitelpon = (TextView) findViewById(R.id.phoneJKTMar);
                assert isitelpon != null;

                String nomere = isitelpon.getText().toString();
                if (nomere.isEmpty()) {

                    Toast.makeText(getApplicationContext(), "oke wes bener a nomere", Toast.LENGTH_SHORT).show();

                } else {

                    Intent masuk = new Intent(Intent.ACTION_CALL);
                    masuk.setData(Uri.parse("tel:" + nomere));

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                            Toast.makeText(getApplicationContext(), "Tunggu Sebentar", Toast.LENGTH_SHORT).show();
                            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 10);
                            return;
                        }
                    }

                    startActivity(masuk);
                }
            }
        });

        //////////////////////////////                  //////////////////////////////

        waJKT = (TextView) findViewById(R.id.waJKT);
        waJKT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url="tel:08113131300";
                if (url.startsWith("tel:"))
                {
                    Intent intent = new Intent(Intent.ACTION_DIAL,
                            Uri.parse(url));
                    startActivity(intent);
                }

            }


        });

        //////////////////////////////                  //////////////////////////////

        phoneSMR = (TextView) findViewById(R.id.phoneSMR);
        assert phoneSMR != null;

        phoneSMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final TextView isitelpon = (TextView) findViewById(R.id.phoneSMR);
                assert isitelpon != null;

                String nomere = isitelpon.getText().toString();
                if (nomere.isEmpty()) {

                    Toast.makeText(getApplicationContext(), "oke wes bener a nomere", Toast.LENGTH_SHORT).show();

                } else {

                    Intent masuk = new Intent(Intent.ACTION_CALL);
                    masuk.setData(Uri.parse("tel:" + nomere));

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                            Toast.makeText(getApplicationContext(), "Tunggu Sebentar", Toast.LENGTH_SHORT).show();
                            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 10);
                            return;
                        }
                    }

                    startActivity(masuk);
                }
            }
        });
    }
}
