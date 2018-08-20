package com.example.emanuele.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void LiEd(View view){startActivity(new Intent(MainActivity.this,ListaEdifici.class));}
    public void Pref(View view){startActivity(new Intent(MainActivity.this,ListaPreferiti.class));}
}
