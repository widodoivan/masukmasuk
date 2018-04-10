package com.example.root.corporate3pe.HargaPengiriman;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

class JsonParse {
    double id_kecamatan, lokasi;
    public JsonParse(){}
    public JsonParse(double id_kecamatan, double lokasi){
        this.id_kecamatan = id_kecamatan;
        this.lokasi = lokasi;
    }

    public List<DataLokasi> getParseJsonWCF(String sLokasi)
    {
        List<DataLokasi> ListData = new ArrayList<DataLokasi>();
        try {

//          String slokasi=sLokasi.replace(" ", "%20");
            URL js = new URL(" "+sLokasi);
            URLConnection jc = js.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(jc.getInputStream()));
            String line = reader.readLine();
            JSONObject jsonResponse = new JSONObject(line);
            JSONArray jsonArray = jsonResponse.getJSONArray("data");
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject r = jsonArray.getJSONObject(i);
                ListData.add(new DataLokasi(r.getInt("id_kecamatan"),r.getString("lokasi")));
//                ListData.add(new DataLokasi(r.getInt("id_kecamatan"),r.getString("id_kecamatan")));
            }

        } catch (Exception e1) {

            e1.printStackTrace();
        }
        return ListData;

    }
}
