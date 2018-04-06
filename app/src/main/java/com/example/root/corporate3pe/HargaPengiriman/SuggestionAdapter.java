package com.example.root.corporate3pe.HargaPengiriman;


import android.widget.ArrayAdapter;
import android.widget.Filter;

import com.example.root.corporate3pe.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class SuggestionAdapter extends ArrayAdapter<String> {

    protected static final String TAG = "DataLokasi";
    private List<DataLokasi> suggestions;

    public SuggestionAdapter(MainActivity context, String nameFilter) {
        super(context, android.R.layout.simple_dropdown_item_1line);
        suggestions = new ArrayList<DataLokasi>();
    }

    @Override
    public int getCount() {
        return suggestions.size();
    }

    @Override
    public String getItem(int index) {
        return suggestions.get(index).getLokasi();
    }

    @Override
    public long getItemId(int position) {
        return suggestions.get(position).getId_kecamatan();
    }

    @Override
    public Filter getFilter() {
        Filter myFilter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                JsonParse jp=new JsonParse();
                if (constraint != null) {
                    suggestions = jp.getParseJsonWCF(constraint.toString());

                    filterResults.values = suggestions;
                    filterResults.count = suggestions.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence contraint, FilterResults results) {
                if (results != null && results.count > 0) {
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }
        };
        return myFilter;
    }

}
