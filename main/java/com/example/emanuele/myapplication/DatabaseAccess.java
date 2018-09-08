package com.example.emanuele.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.PointF;
import android.media.Image;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public List<String> getPiani(String a) {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("select nome_piano from Piano where edificio=? order by codice_piano asc",new String[]{a});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public String getPianoStanza(String a) {
        String result=new String();
        Cursor cursor = database.rawQuery("select piano from Stanza where nome_stanza=?",new String[]{a});
        cursor.moveToFirst();
        result=cursor.getString(0);
        cursor.close();
        return result;
    }
    public List<String> getEdifici() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("select nome_edificio from Edificio order by codice_edificio asc", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getStanze(String a) {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("select nome_stanza from Stanza where piano=?", new String[]{a});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public byte[] getImage(String a) {
        byte[] data = null;
        Cursor cursor = database.rawQuery("SELECT immagine FROM Piano WHERE nome_piano=?",new String[]{a});
        cursor.moveToFirst();

        data = cursor.getBlob(0);

        cursor.close();
        return data;
    }
    public List<String> getPreferiti() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("select nome_stanza,piano from Stanza where preferito=1",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public boolean addPreferito(String nome) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Preferito",1);
        database.update("Stanza", contentValues, "nome_stanza = ?",new String[] { nome });
        return true;
    }
    public boolean deletePreferito(String nome) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Preferito",0);
        database.update("Stanza", contentValues, "nome_stanza = ?",new String[] { nome });
        return true;
    }

    public List<PointF> getMarks(String stanza) {//viasualizza la stanza nella mappa
        List<PointF> marks = new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT coordinata_x,coordinata_y from Stanza WHERE nome_stanza=?",new String[] { stanza });
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            float x=cursor.getFloat(0);
            float y=cursor.getFloat(1);
            marks.add(new PointF(x,y));
            cursor.moveToNext();
        }
        cursor.close();
        return marks;
    }
    public List<PointF> getNodesPiani(String piano) {
        List<PointF> marks = new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT coordinata_x,coordinata_y from NodesPiani WHERE piano=? order by cod",new String[] { piano });
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            float x=cursor.getFloat(0);
            float y=cursor.getFloat(1);
            marks.add(new PointF(x,y));
            cursor.moveToNext();
        }
        cursor.close();
        return marks;
    }
    public List<PointF> getNodesContractPiani(String piano) {
        List<PointF> marks = new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT node1,node2 from NodesContractPiani WHERE piano=? order by node1",new String[] { piano });
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            float x=cursor.getFloat(0);
            float y=cursor.getFloat(1);
            marks.add(new PointF(x,y));
            cursor.moveToNext();
        }
        cursor.close();
        return marks;
    }
    public List<PointF> getMarksPassaggio(String piano) {
        List<PointF> marks = new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT coordinata_x,coordinata_y from Passaggio WHERE piano=?",new String[] { piano });
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            float x=cursor.getFloat(0);
            float y=cursor.getFloat(1);
            marks.add(new PointF(x,y));
            cursor.moveToNext();
        }
        cursor.close();
        return marks;
    }
    public void getMarksPassaggioCod(PointF start) {//serve per trovare la posizione di partenza quando l utente all inizio non si trova sul piano corretto
        Position p=Position.getInstance();
        List<PointF> marks = new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT cod from Passaggio WHERE coordinata_x=? and coordinata_y=?",new String[] {String.valueOf(start.x),String.valueOf(start.y)});
        cursor.moveToFirst();
        String cod=cursor.getString(0);
        cursor.close();
        Cursor cursor2=database.rawQuery("SELECT coordinata_x,coordinata_y from Passaggio WHERE piano=? and cod=?",new String[] { p.getDestinationPiano(),cod });
        cursor2.moveToFirst();
        while (!cursor2.isAfterLast()) {
            float x=cursor2.getFloat(0);
            float y=cursor2.getFloat(1);
            PointF startposition=new PointF(x,y);
            p.setPosition(startposition,p.getDestinationPiano());
            cursor2.moveToNext();
        }
        cursor2.close();
    }

    /*
    public List<String> getMarksName() {
        List<String> marksName = new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT nome_stanza FROM Stanza ",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            marksName.add("Stanza"+cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return marksName;
    }*/
}
