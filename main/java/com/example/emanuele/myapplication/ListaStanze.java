package com.example.emanuele.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.List;

public class ListaStanze extends AppCompatActivity implements SearchView.OnQueryTextListener{
    ListView listView;ArrayAdapter<String> adapter;SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_stanze);
        listView=(ListView)findViewById(R.id.listViewStanze);
        searchView=(SearchView)findViewById(R.id.idsearch);
        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> Stanze = databaseAccess.getStanze(getIntent().getExtras().getString("a"));
        databaseAccess.close();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Stanze);
        this.listView.setAdapter(adapter);
        searchView.setOnQueryTextListener(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Position p=Position.getInstance();
                String selected =(String) listView.getItemAtPosition(position);
                Intent finestra=new Intent(getApplicationContext(),VisualizzaPianoStanza.class);
               // finestra.putExtra("a",getIntent().getExtras().getString("a"));//sostituire il secondo elemento con selected
                //finestra.putExtra("stanza",selected);//passo il nome della stanza
                p.setDestination(getIntent().getExtras().getString("a"),selected);
                startActivity(finestra);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                databaseAccess.open();
                String selected =(String) listView.getItemAtPosition(position);
                databaseAccess.addPreferito(selected);
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1500);
                Toast.makeText(getApplicationContext(),"PREFERITO AGGIUNTO",Toast.LENGTH_LONG).show();
                return false;
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
