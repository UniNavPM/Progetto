package com.example.emanuele.myapplication;
import android.graphics.PointF;

import java.util.ArrayList;
import java.util.List;

public class Nod {

    public static List<PointF> getNodesList(String piano) {
        List<PointF> nodes = new ArrayList<>();
        switch(piano) {
            case "Q150":
                nodes.add(new PointF(103, 1992));//0
                nodes.add(new PointF(262, 1992));//1
                nodes.add(new PointF(359, 1992));
                nodes.add(new PointF(359, 1737));
                nodes.add(new PointF(359, 1439));
                break;
        }
        return nodes;
    }

    public static List<PointF> getNodesContactList(String piano) {
        List<PointF> nodesContact = new ArrayList<PointF>();
        switch(piano) {
            case "Q150":
                nodesContact.add(new PointF(0, 1));
                nodesContact.add(new PointF(1, 2));
                nodesContact.add(new PointF(2, 3));
                nodesContact.add(new PointF(3, 4));
                break;
        }
        return nodesContact;
    }
}
