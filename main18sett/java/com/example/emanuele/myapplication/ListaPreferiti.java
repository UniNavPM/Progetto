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
import android.widget.Toast;

import java.util.List;

public class ListaPreferiti extends AppCompatActivity {
    ListView listView;ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_preferiti);
        listView=(ListView)findViewById(R.id.listViewPreferiti);
        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        final List<String> Pref = databaseAccess.getPreferiti();
        databaseAccess.close();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Pref);
        this.listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Position p=Position.getInstance();
                databaseAccess.open();
                String selected =(String) listView.getItemAtPosition(position);
                String piano=databaseAccess.getPianoStanza(selected);databaseAccess.close();
                Intent finestra=new Intent(getApplicationContext(),VisualizzaPianoStanza.class);
                p.setDestination(piano,selected);
                startActivity(finestra);
                finish();//termina l activity
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                databaseAccess.open();
                String selected =(String) listView.getItemAtPosition(position);
                databaseAccess.deletePreferito(selected);
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1500);
                Toast.makeText(getApplicationContext(),"PREFERITO RIMOSSO",Toast.LENGTH_LONG).show();

                return false;
            }
        });
    }
}
