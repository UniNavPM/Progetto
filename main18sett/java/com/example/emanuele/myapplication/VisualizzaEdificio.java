package com.example.emanuele.myapplication;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.onlylemi.mapview.library.MapView;
import com.onlylemi.mapview.library.MapViewListener;
import com.onlylemi.mapview.library.layer.MarkLayer;
import com.onlylemi.mapview.library.layer.RouteLayer;
import com.onlylemi.mapview.library.utils.MapUtils;

import java.util.List;
import java.util.Random;

import static com.example.emanuele.myapplication.VisualizzaPianoStanza.toBitmap;

public class VisualizzaEdificio extends AppCompatActivity {

    private MapView mapView;
    private List<PointF> marks;
    private List<PointF> nodes;
    private List<PointF> nodesContract;
    private MarkLayer markLayer;
    private RouteLayer routeLayer;
    private List<String> marksName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_navigazione);
        super.onCreate(savedInstanceState);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        Position p=Position.getInstance();

        marks =Nod.marksCampus(p.getEdificio());
        nodes=Nod.nodesCampus();
        nodesContract=Nod.nodescontactCampus();

        mapView = (MapView) findViewById(R.id.mapview);

        byte[] data = databaseAccess.getImageCampus();
        Bitmap bitmap = toBitmap(data);
        mapView.loadMap(bitmap);
        mapView.setMapViewListener(new MapViewListener() {
            @Override
            public void onMapLoadSuccess() {
                routeLayer = new RouteLayer(mapView);
                mapView.addLayer(routeLayer);
                markLayer = new MarkLayer(mapView, marks,marksName);
                mapView.addLayer(markLayer);
                mapView.refresh();

                ImageButton b=(ImageButton) findViewById(R.id.button);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent f=new Intent(getApplicationContext(),QRCodeEdificio.class);
                        startActivity(f);
                    }
                });
            }

            @Override
            public void onMapLoadFail() {
            }

        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_map_layer_test, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mapView.isMapLoadFinish()) {
            switch (item.getItemId()) {
                case R.id.map_layer_set_rotate:
                    int rotate = new Random().nextInt(360);
                    mapView.setCurrentRotateDegrees(rotate);
                    mapView.refresh();

                    Toast.makeText(this, "current rotate: " + rotate, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.map_layer_set_zoom1:
                    mapView.setCurrentZoom(mapView.getCurrentZoom() / 2);
                    mapView.refresh();
                    break;
                case R.id.map_layer_set_zoom2:
                    mapView.setCurrentZoom(mapView.getCurrentZoom() * 2);
                    mapView.refresh();
                    break;
                case R.id.map_layer_set_auto_rotate_and_scale:
                    if (mapView.isScaleAndRotateTogether()) {
                        item.setTitle("Set Rotate and Scale Together");
                    } else {
                        item.setTitle("Set Rotate and Scale Not Together");
                    }
                    mapView.setScaleAndRotateTogether(!mapView.isScaleAndRotateTogether());
                    break;
                default:
                    break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
    public static Bitmap toBitmap(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
