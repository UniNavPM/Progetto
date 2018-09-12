package com.example.emanuele.myapplication;


import android.content.Intent;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;


public class QRCode extends AppCompatActivity implements View.OnClickListener {
    private ImageButton buttonScan;
    private IntentIntegrator qrScan;
    Intent finestra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        buttonScan = (ImageButton) findViewById(R.id.buttonScan);
        qrScan = new IntentIntegrator(this);
        buttonScan.setOnClickListener(this);
        finestra=null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "NESSUN RISULTATO", Toast.LENGTH_LONG).show();
            } else {
                try {
                    JSONObject obj = new JSONObject(result.getContents());
                    Position p=Position.getInstance();
                    String x=obj.getString("cordx");
                    String y=obj.getString("cordy");
                    String piano=obj.getString("piano");
                    p.setPosition(new PointF(Integer.valueOf(x),Integer.valueOf(y)),piano);
                    if(p.getPiano().equals(p.getDestinationPiano())){finestra=new Intent(getApplicationContext(),Navigazione.class);}//controllo se il qr code si trova nello stesso piano della destinazione
                    else{finestra=new Intent(getApplicationContext(),NavigazioneAlpiano.class);}
                    startActivity(finestra);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    @Override
    public void onClick(View view) {
        qrScan.initiateScan();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}