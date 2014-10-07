package com.twistedblizzard.skyrimitemdatabase;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Ammunition extends ListActivity {

    String[] ammunitionNamesArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> adapter;

        ammunitionNamesArray = getResources().getStringArray(R.array.AmmunitionNames);

        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                ammunitionNamesArray);
        setListAdapter(adapter);

        ListView listView = getListView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(view.getContext(), ItemViewer.class);
                intent.putExtra("posNo", position);
                intent.putExtra("parent", 0);
                startActivity(intent);
            }
        });
    }
}
