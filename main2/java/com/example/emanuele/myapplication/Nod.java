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
            case "Q140":
                nodes.add(new PointF(5701, 2050));//aula 140/1   0
                nodes.add(new PointF(5373, 2050));//aula 140/2   1
                nodes.add(new PointF(4785, 2050));//              2
                nodes.add(new PointF(4785, 1679));//3
                nodes.add(new PointF(4785, 1426));//4
                nodes.add(new PointF(4785, 1133));//5
                nodes.add(new PointF(5337, 1133));//6
                nodes.add(new PointF(4025, 2050));//7
                nodes.add(new PointF(4025, 1399));//8
                nodes.add(new PointF(3365, 2050)); //140/3    9
                nodes.add(new PointF(2849, 2050)); //140/D4   10
                nodes.add(new PointF(2685, 2050));//11
                nodes.add(new PointF(2685, 2448));  //qui ci sono sia le scale S8 che l'aula 140/D5  12

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
            case "Q140":
                nodesContact.add(new PointF(0, 1));
                nodesContact.add(new PointF(1, 2));
                nodesContact.add(new PointF(2, 3));
                nodesContact.add(new PointF(3, 4));
                nodesContact.add(new PointF(4, 5));
                nodesContact.add(new PointF(5, 6));
                nodesContact.add(new PointF(2, 7));
                nodesContact.add(new PointF(7, 8));
                nodesContact.add(new PointF(7, 9));
                nodesContact.add(new PointF(9, 10));
                nodesContact.add(new PointF(10, 11));
               // nodesContact.add(new PointF(11, 10));
                nodesContact.add(new PointF(11, 12));
                nodesContact.add(new PointF(12, 11));

               /* nodesContact.add(new PointF(12, 11));
                nodesContact.add(new PointF(10, 9));*/
                break;
        }
        return nodesContact;
    }
}
