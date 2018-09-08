package com.example.emanuele.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.onlylemi.mapview.library.MapView;
import com.onlylemi.mapview.library.MapViewListener;
import com.onlylemi.mapview.library.layer.BitmapLayer;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class VisualizzaPianoStanza extends AppCompatActivity {
    private MapView mapView;
    private BitmapLayer bitmapLayer;
    private List<PointF> x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizzapianostanza);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        Position p=Position.getInstance();
        mapView = (MapView) findViewById(R.id.mapview);
        Bitmap bitmap = null;
        bitmap = toBitmap(databaseAccess.getImage(p.getDestinationPiano()));
        mapView.loadMap(bitmap);
        x=databaseAccess.getMarks(p.getDestinationStanza());
        mapView.setMapViewListener(new MapViewListener() {
            @Override
            public void onMapLoadSuccess() {
                Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.iconaposizione);
                bitmapLayer = new BitmapLayer(mapView, bmp);
                bitmapLayer.setLocation(x.get(0));
                bitmapLayer.setOnBitmapClickListener(new BitmapLayer.OnBitmapClickListener() {
                    @Override
                    public void onBitmapClick(BitmapLayer layer) {
                        Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
                    }
                });
                mapView.addLayer(bitmapLayer);
                mapView.refresh();
            }

            @Override
            public void onMapLoadFail() {}
        });
        ImageButton b=(ImageButton) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f=new Intent(getApplicationContext(),QRCode.class);
                startActivity(f);
            }
        });
    }
    public static Bitmap toBitmap(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }
}
