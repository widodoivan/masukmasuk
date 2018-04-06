package com.example.root.corporate3pe;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.corporate3pe.ArtikelClass.NavigationDrawerConstants;
import com.example.root.corporate3pe.HargaPengiriman.RequestPost;
import com.example.root.corporate3pe.HargaPengiriman.SuggestionAdapter;
import com.example.root.corporate3pe.Kontak.Kontaks;
import com.example.root.corporate3pe.Layanan.Kurir;
import com.example.root.corporate3pe.Layanan.PengirimanDarat;
import com.example.root.corporate3pe.Layanan.PengirimanLaut;
import com.example.root.corporate3pe.Layanan.PengirimanUdara;
import com.example.root.corporate3pe.Layanan.PenyimpananBarang;
import com.example.root.corporate3pe.Perusahaan.Fragment1;
import com.example.root.corporate3pe.Perusahaan.Fragment2;
import com.example.root.corporate3pe.Perusahaan.Fragment3;
import com.example.root.corporate3pe.Perusahaan.Fragment4;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity
        implements

            Fragment1.OnFragmentInteractionListener,
            Fragment2.OnFragmentInteractionListener,
            Fragment3.OnFragmentInteractionListener,
            Fragment4.OnFragmentInteractionListener,

                PengirimanDarat.OnFragmentInteractionListener,
                PengirimanLaut.OnFragmentInteractionListener,
                PengirimanUdara.OnFragmentInteractionListener,
                Kurir.OnFragmentInteractionListener,
                PenyimpananBarang.OnFragmentInteractionListener,

        NavigationView.OnNavigationItemSelectedListener {

    //cek_harga//
    private static String ROOT_URL = "http://api.3permata.co.id/relokasi/cari";
    private static final String TAG = MainActivity.class.getSimpleName();
    AutoCompleteTextView Aslokasi, TuLokasi;
    long AsLokasiId, TuLokasiId;
    TextView harganyacuy, refresh_btn;
    Button button;
    ImageView gambarhome;
    private int title;
    private android.view.ViewGroup transitionsContainer;
    private boolean expanded;
    //cek_harga//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.home);

        //NOTE:  Open fragment1 initially.
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.replace(R.id.mainFrame, new Home());
//        ft.commit();


        Aslokasi = (AutoCompleteTextView) findViewById(R.id.AsalLokasi);
        Aslokasi.setAdapter(new SuggestionAdapter(MainActivity.this, Aslokasi.getText().toString()));
        Aslokasi.setThreshold(1);
        Aslokasi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
//                Toast.makeText(SlideActivity.this,"origin", Toast.LENGTH_SHORT).show();
                AsLokasiId = id;
            }
        });

        TuLokasi = (AutoCompleteTextView) findViewById(R.id.TujuanLokasi);
        TuLokasi.setAdapter(new SuggestionAdapter(MainActivity.this, TuLokasi.getText().toString()));
        TuLokasi.setThreshold(1);
        TuLokasi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
//                Toast.makeText(SlideActivity.this,"origin", Toast.LENGTH_SHORT).show();
                TuLokasiId = id;
            }
        });

        harganyacuy = (TextView) findViewById(R.id.harganyacuy);

        refresh_btn = (TextView) findViewById(R.id.refresh_btn);
        refresh_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                harganyacuy.setText("");
                Aslokasi.setText("");
                TuLokasi.setText("");
            }
        });

        button = (Button) findViewById(R.id.btncekharga);
        findViewById(R.id.btncekharga).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                okeoke();
                //


            }
        });
    }

    private void okeoke() {

        final String origin = AsLokasiId + "";
        final String destination = TuLokasiId + "";
        Log.d(TAG, "origin : " + origin);
        Log.d(TAG, "destination : " + destination);

        class okeoke extends AsyncTask<Void, Void, String> {

            @Override
            protected String doInBackground(Void... Voids) {
                RequestPost requestpost = new RequestPost();
                HashMap<String, String> params = new HashMap<>();
                params.put("origin_kecamatan", origin);
                params.put("destination_kecamatan", destination);
                return requestpost.sendPostRequest(ROOT_URL, params);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                try {

                    Log.d(TAG, "Response: " + s);
                    //converting response to json object
                    JSONObject obj = new JSONObject(s);

                    //if no error in response
                    if (obj.has("data")) {
                        String harga = obj.getString("harga");
                        harganyacuy.setText(harga);
                    } else {
                        Toast.makeText(getApplicationContext(), "coba lagi cuy", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        okeoke ru = new okeoke();
        ru.execute();

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;

        if (id == R.id.home) {
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
        }

//        else if (id == R.id.cobabutton) {
//            Intent intent = new Intent(getApplication(), Cek Shipment.class);
//            startActivity(intent);
//        }

                else if (id == R.id.nav_frag1) {
                    fragment = new Fragment1();
                }

                    else if (id == R.id.nav_frag2) {
                        fragment = new Fragment2();
                    }

                        else if (id == R.id.nav_frag3) {
                            fragment = new Fragment3();
                        }

                            else if (id == R.id.nav_frag4) {
                                fragment = new Fragment4();
                            }

        else if (id == R.id.pengirimandarat) {
            fragment = new PengirimanDarat();
        }

            else if (id == R.id.pengirimanlaut) {
                fragment = new PengirimanLaut();
            }

                else if (id == R.id.pengirimanudara) {
                    fragment = new PengirimanUdara();
                }

                    else if (id == R.id.kurir) {
                        fragment = new Kurir();
                    }

                        else if (id == R.id.penyimpananbarang) {
                            fragment = new PenyimpananBarang();
                        }

            else if (id == R.id.artikel) {
                Intent urlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(NavigationDrawerConstants.SITE_URL));
                startActivity(urlIntent);
            }

                else if (id == R.id.kontak) {
                    Intent intent = new Intent(getApplication(), Kontaks.class);
                    startActivity(intent);
                }


        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, fragment);
            ft.commit();
        }

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
    }

    @Override
    public void onFragmentInteraction(String title) {

        // NOTE:  Code to replace the toolbar title based current visible fragment
        getSupportActionBar().setTitle(title);
    }

}
