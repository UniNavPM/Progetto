package com.example.emanuele.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.List;


public class ListaPiani extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private ListView listView;
    SearchView searchView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_piani);
        searchView=(SearchView)findViewById(R.id.idsearch);
        this.listView = (ListView) findViewById(R.id.listView);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> Piani = databaseAccess.getPiani(getIntent().getExtras().getString("a"));
        databaseAccess.close();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Piani);
        this.listView.setAdapter(adapter);
        searchView.setOnQueryTextListener(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected =(String) listView.getItemAtPosition(position);
                Intent finestra=new Intent(getApplicationContext(),ListaStanze.class);
                finestra.putExtra("a",selected);
                startActivity(finestra);
            }
        });
        }
        @Override
    public boolean onQueryTextSubmit(String query){return false;}
    @Override
    public boolean onQueryTextChange(String newText){
        String text=newText;
        adapter.getFilter().filter(newText);
        return false;

    }
}