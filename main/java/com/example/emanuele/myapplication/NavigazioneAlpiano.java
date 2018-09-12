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
        Position p=Position.getInstance();

        ImageButton b=(ImageButton) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f=new Intent(getApplicationContext(),Navigazione.class);//dopo che l utente ha raggiunto le scale puo partire direttamente l activity navigazione
                Position p=Position.getInstance();
                databaseAccess.getMarksPassaggioCod(p.getTarget());
                startActivity(f);                                           //bisogna impostare però il punto di partenza dato che l utente arriva dalle scale
            }
        });

        marks =databaseAccess.getMarksPassaggio(p.getPiano());
        //marks.add(p.getPosition());
        nodes=Nod.getNodesList(p.getDestinationPiano());
        nodesContract = Nod.getNodesContactList(p.getDestinationPiano());

        mapView = (MapView) findViewById(R.id.mapview);
        byte[] data = databaseAccess.getImage(p.getPiano());
        Bitmap bitmap = toBitmap(data);
        mapView.loadMap(bitmap);

        mapView.setMapViewListener(new MapViewListener() {
            @Override
            public void onMapLoadSuccess() {
                routeLayer = new RouteLayer(mapView);
                mapView.addLayer(routeLayer);

                markLayer = new MarkLayer(mapView, marks, marksName);
                mapView.addLayer(markLayer);
                markLayer.setMarkIsClickListener(new MarkLayer.MarkIsClickListener() {
                    @Override
                    public void markIsClick(int num) {
                        Position p=Position.getInstance();
                        PointF target = new PointF(marks.get(num).x, marks.get(num).y);
                        List<Integer> routeList = MapUtils.getShortestDistanceBetweenTwoPoints
                                (p.getPosition(), target, nodes, nodesContract);
                        p.setTarget(target);
                        routeLayer.setNodeList(nodes);
                        routeLayer.setRouteList(routeList);
                        mapView.refresh();
                    }
                });
                mapView.refresh();
            }

            @Override
            public void onMapLoadFail() {
            }

        });
    }
}
