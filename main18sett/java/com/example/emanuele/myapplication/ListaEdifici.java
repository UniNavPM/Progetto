package com.example.emanuele.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.List;

public class ListaEdifici extends AppCompatActivity implements SearchView.OnQueryTextListener {
    ListView listView;ArrayAdapter<String> adapter;SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_edifici);
        searchView=(SearchView)findViewById(R.id.idsearch);
        this.listView=(ListView) findViewById(R.id.listViewEdifici);
        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> Edifici = databaseAccess.getEdifici();
        databaseAccess.close();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Edifici);
        this.listView.setAdapter(adapter);
        searchView.setOnQueryTextListener(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected =(String) listView.getItemAtPosition(position);
                Intent finestra=new Intent(getApplicationContext(),ListaPiani.class);
                String test="Ingegneria";
                if(!selected.equals(test))
                    {
                        Intent finestra1=new Intent(getApplicationContext(),VisualizzaEdificio.class);
                        Position p=Position.getInstance();
                        p.setEdificio(selected);
                        startActivity(finestra1);
                    }
                else{finestra.putExtra("a",selected);
                startActivity(finestra);}
            }
        });

    }
    @Override
    public boolean onQueryTextSubmit(String query){return false;}
    @Override
    public boolean onQueryTextChange(String newText){
        String text=newText;
        adapter.getFilter().filter(newText);
        return false;}
}
