package com.example.emanuele.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.onlylemi.mapview.library.MapView;
import com.onlylemi.mapview.library.MapViewListener;
import com.onlylemi.mapview.library.layer.MarkLayer;
import com.onlylemi.mapview.library.layer.RouteLayer;
import com.onlylemi.mapview.library.utils.MapUtils;

import java.util.List;

import static com.example.emanuele.myapplication.VisualizzaPianoStanza.toBitmap;


public class NavigazioneAlpiano extends AppCompatActivity {
    private MapView mapView;
    private List<PointF> marks;
    private List<PointF> marks2;
    private List<PointF> nodes;
    private List<PointF> nodesContract;
    private MarkLayer markLayer;
    private RouteLayer routeLayer;
    private List<String> marksName;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigazione_alpiano);

        textView=(TextView)findViewById(R.id.tv);
        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        final Position p=Position.getInstance();


        marks2=(databaseAccess.getMarkPassaggio(p.getDestinationPiano()));

        marks=(databaseAccess.getMarkPassaggio(p.getPiano()));
        marks.add(p.getPosition());
        nodes=Nod.getNodesList(p.getPiano());
        nodesContract = Nod.getNodesContactList(p.getPiano());
        MapUtils.init(nodes.size(), nodesContract.size());
        mapView = (MapView) findViewById(R.id.mapview);
        byte[] data = databaseAccess.getImage(p.getPiano());
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
                        (p.getPosition(),marks.get(0), nodes,nodesContract);
                routeLayer.setNodeList(nodes);
                routeLayer.setRouteList(routeList);
                mapView.refresh();

               ImageButton b=(ImageButton) findViewById(R.id.nav);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /*DatabaseAccess databaseAccess = DatabaseAccess.getInstance(NavigazioneAlpiano.this);
                       databaseAccess.open();*/

                        Position p=Position.getInstance();
                        p.setPosition(marks2.get(0),p.getDestinationPiano());
                        Intent f=new Intent(getApplicationContext(),Navigazione.class);
                        startActivity(f);
                       /*Intent f=new Intent(getApplicationContext(),QRCode.class);
                        startActivity(f);*/
                    }
                });
            }

            @Override
            public void onMapLoadFail() {
            }

        });databaseAccess.close();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
