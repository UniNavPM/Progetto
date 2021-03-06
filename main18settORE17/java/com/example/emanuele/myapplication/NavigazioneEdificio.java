package com.example.emanuele.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.onlylemi.mapview.library.MapView;
import com.onlylemi.mapview.library.MapViewListener;
import com.onlylemi.mapview.library.layer.MarkLayer;
import com.onlylemi.mapview.library.layer.RouteLayer;
import com.onlylemi.mapview.library.utils.MapUtils;

import java.util.List;

import static com.example.emanuele.myapplication.VisualizzaPianoStanza.toBitmap;

public class NavigazioneEdificio extends AppCompatActivity {
    private MapView mapView;
    private List<PointF> marks;
    private List<PointF> nodes;
    private List<PointF> nodesContract;
    private MarkLayer markLayer;
    private RouteLayer routeLayer;
    private List<String> marksName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigazione);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        Position p=Position.getInstance();

        marks =Nod.marksCampus(p.getEdificioDest());
        marks.add(p.getEdificioPosition());
        nodes=Nod.nodesCampus();
        nodesContract=Nod.nodescontactCampus();

        mapView = (MapView) findViewById(R.id.mapview);
        MapUtils.init(nodes.size(), nodesContract.size());
        byte[] data = databaseAccess.getImageCampus();
        Bitmap bitmap = toBitmap(data);
        mapView.loadMap(bitmap);
        mapView.setMapViewListener(new MapViewListener() {
            @Override
            public void onMapLoadSuccess() {
                Position p=Position.getInstance();
                routeLayer = new RouteLayer(mapView);
                mapView.addLayer(routeLayer);
                markLayer = new MarkLayer(mapView, marks,marksName);
                mapView.addLayer(markLayer);
                List<Integer> routeList = MapUtils.getShortestDistanceBetweenTwoPoints
                        (p.getEdificioPosition(),marks.get(0), nodes,nodesContract);
                routeLayer.setNodeList(nodes);
                routeLayer.setRouteList(routeList);
                mapView.refresh();

                ImageButton b=(ImageButton) findViewById(R.id.button);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent f=new Intent(getApplicationContext(),QRCode.class);
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
    protected void onDestroy() {
        super.onDestroy();
    }
}
