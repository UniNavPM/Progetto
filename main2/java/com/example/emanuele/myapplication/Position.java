package com.example.emanuele.myapplication;

import android.graphics.PointF;

public class Position {
    private static Position instance=new Position();
    public static Position getInstance(){return instance;}
    public static void setInstance(Position instance){Position.instance=instance;}

    private PointF position;
    private String piano;
    private String destinationStanza;
    private String destinationPiano;
    private PointF cod;

    public void setPosition(PointF i,String piano){
        this.position=i;
        this.piano=piano;
        return;}

    public PointF getPosition(){return position;}

    public boolean hasPosition(){
        if (this.position==null){return false;}
        else return true;}

    public String getPiano(){return piano;}

    public void setDestination(String piano,String stanza){
        this.destinationStanza=stanza;
        this.destinationPiano=piano;}

     public String getDestinationStanza(){return destinationStanza;}
     public String getDestinationPiano(){return destinationPiano;}


     public void setTarget(PointF target){this.cod=target;}//servono per il codice della scala o ascensore nell entità passaggio
     public PointF getTarget(){return this.cod;}
}
