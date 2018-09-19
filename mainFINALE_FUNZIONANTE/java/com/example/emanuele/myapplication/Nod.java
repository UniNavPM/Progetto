package com.example.emanuele.myapplication;
import android.graphics.PointF;

import java.util.ArrayList;
import java.util.List;

public class Nod {

    public static List<PointF> getNodesList(String piano) {
        List<PointF> nodes = new ArrayList<>();
        switch(piano) {
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
            case "Q145":
                nodes.add(new PointF(3628, 1593));
                nodes.add(new PointF(3584, 1593));
                nodes.add(new PointF(3584, 1440));
                nodes.add(new PointF(3584, 1380));
                nodes.add(new PointF(3728, 1380));
                nodes.add(new PointF(3728,1328 ));
                nodes.add(new PointF(3476,1440 ));
                nodes.add(new PointF(3476,1198 ));
                nodes.add(new PointF(3476,883 ));
                nodes.add(new PointF(3476,622 ));
                nodes.add(new PointF(3726, 622));
                nodes.add(new PointF(3726,668 ));
                nodes.add(new PointF(2878,622 ));
                nodes.add(new PointF(2872,805 ));
                nodes.add(new PointF(2644,805 ));
                nodes.add(new PointF(2644,475 ));
                nodes.add(new PointF(3086,1440 )); //16
                nodes.add(new PointF(3086,1647 ));
                nodes.add(new PointF(2904,1647 ));
                nodes.add(new PointF(2904,1695 ));
                nodes.add(new PointF(2194, 1695));
                nodes.add(new PointF(2194,1869 ));
                nodes.add(new PointF(2222,1907 ));
                nodes.add(new PointF(2084,1907 ));
                nodes.add(new PointF(2084,1797 ));
                nodes.add(new PointF(1836,1797 ));
                nodes.add(new PointF(3476,436 ));
                break;
            case "Q150":
                nodes.add(new PointF(3808,1835 ));
                nodes.add(new PointF(3622, 1835));
                nodes.add(new PointF(3622,1627 ));
                nodes.add(new PointF(3582,1627 ));
                nodes.add(new PointF(3582,1479 ));
                nodes.add(new PointF(3582,1393 ));
                nodes.add(new PointF(3310, 1479));
                nodes.add(new PointF(3310,1707 ));
                nodes.add(new PointF(3239, 1766));
                nodes.add(new PointF(3394,1835 ));
                nodes.add(new PointF(3239,1837 ));
                nodes.add(new PointF(3239,1941 ));
                nodes.add(new PointF(2719,1941 ));
                nodes.add(new PointF(2520,1941 ));
                nodes.add(new PointF(2359,1941 ));
                nodes.add(new PointF(2091,1941 ));
                nodes.add(new PointF(2091,1872 ));
                nodes.add(new PointF(1990,1873 ));
                break;
            case "Q160":
                nodes.add(new PointF(2521, 2905));
                nodes.add(new PointF(2660, 2905));
                nodes.add(new PointF(2785, 2905));
                nodes.add(new PointF(2785, 2695));
                nodes.add(new PointF(2593, 2695));
                nodes.add(new PointF(2785, 2121));
                nodes.add(new PointF(3129, 2121));
                nodes.add(new PointF(3270, 1981));
                nodes.add(new PointF(3435, 1981));
                nodes.add(new PointF(3435, 1832));
                nodes.add(new PointF(3653, 1832));
                nodes.add(new PointF(3802, 1832));
                nodes.add(new PointF(3802, 1984));
                nodes.add(new PointF(3802, 2227));
                nodes.add(new PointF(3653, 1550));
                break;
            case "Q155":
                nodes.add(new PointF(324, 1739));
                nodes.add(new PointF(324, 1345));
                nodes.add(new PointF(836, 1345));
                nodes.add(new PointF(836, 1449));
                nodes.add(new PointF(1151, 1478));
                nodes.add(new PointF(1193, 1653));
                nodes.add(new PointF(1244, 1653));
                nodes.add(new PointF(1244, 1803));
                nodes.add(new PointF(1492, 1803));
                nodes.add(new PointF(1827, 1803));
                nodes.add(new PointF(1827, 1854));
                nodes.add(new PointF(2024, 1854));
                nodes.add(new PointF(2024, 2126));
                nodes.add(new PointF(1871, 2142));
                nodes.add(new PointF(3188,1854)); //banca    15
                nodes.add(new PointF(3327,1854)); //cesmi 2    16
                nodes.add(new PointF(3633,1854)); //cesmi 1    17
                nodes.add(new PointF(3581,1658)); //scala    18
                nodes.add(new PointF(3581,1389)); //laboratorio ecdl  19
                nodes.add(new PointF(3495,1389)); //nodo    20
                nodes.add(new PointF(3495,1196)); // 155/2-3 e D2 e D1  21
                nodes.add(new PointF(3495,886)); // 155/4 e D3    22
                nodes.add(new PointF(3495,668)); // 155/5-4 e 7    23
                nodes.add(new PointF(3666,668)); // 155/D4    24
                break;
        }
        return nodes;
    }

    public static List<PointF> getNodesContactList(String piano) {
        List<PointF> nodesContact = new ArrayList<PointF>();
        switch(piano) {
            case "Q150":
                nodesContact.add(new PointF(0,1 ));
                nodesContact.add(new PointF(1,0 ));
                nodesContact.add(new PointF(1,2 ));
                nodesContact.add(new PointF(2,3 ));
                nodesContact.add(new PointF(3,4 ));
                nodesContact.add(new PointF(4,5 ));
                nodesContact.add(new PointF(5,4 ));
                nodesContact.add(new PointF(4,6 ));
                nodesContact.add(new PointF(6,7 ));
                nodesContact.add(new PointF(7,8 ));
                nodesContact.add(new PointF(8,9 ));
                nodesContact.add(new PointF(1,9 ));
                nodesContact.add(new PointF(8,10 ));
                nodesContact.add(new PointF(9,10));
                nodesContact.add(new PointF(10,11 ));
                nodesContact.add(new PointF(11,12 ));
                nodesContact.add(new PointF(12,13 ));
                nodesContact.add(new PointF(13,14 ));
                nodesContact.add(new PointF(14,15 ));
                nodesContact.add(new PointF(15,16 ));
                nodesContact.add(new PointF(16,17 ));
                nodesContact.add(new PointF(17,16 ));
                break;
            case "Q155":
                nodesContact.add(new PointF(0, 1));
                nodesContact.add(new PointF(1, 0));
                nodesContact.add(new PointF(1, 2));
                nodesContact.add(new PointF(2, 3));
                nodesContact.add(new PointF(3, 4));
                nodesContact.add(new PointF(4, 5));
                nodesContact.add(new PointF(5, 6));
                nodesContact.add(new PointF(6, 7));
                nodesContact.add(new PointF(7, 8));
                nodesContact.add(new PointF(8, 9));
                nodesContact.add(new PointF(9, 10));
                nodesContact.add(new PointF(10, 11));
                nodesContact.add(new PointF(11, 12));
                nodesContact.add(new PointF(12, 13));
                nodesContact.add(new PointF(13, 12));
                nodesContact.add(new PointF(11, 14));
                nodesContact.add(new PointF(14, 15));
                nodesContact.add(new PointF(15, 16));
                nodesContact.add(new PointF(16, 17));
                nodesContact.add(new PointF(17, 18));
                nodesContact.add(new PointF(18, 19));
                nodesContact.add(new PointF(19, 20));
                nodesContact.add(new PointF(20, 21));
                nodesContact.add(new PointF(21, 22));
                nodesContact.add(new PointF(22, 23));
                nodesContact.add(new PointF(23, 22));
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
            case "Q145":
                nodesContact.add(new PointF(0,1 ));
                nodesContact.add(new PointF(1,2 ));
                nodesContact.add(new PointF(2,3 ));
                nodesContact.add(new PointF(3,4 ));
                nodesContact.add(new PointF(4, 5));
                nodesContact.add(new PointF(5,4 ));
                nodesContact.add(new PointF(2, 6));
                nodesContact.add(new PointF(6, 7));
                nodesContact.add(new PointF(7,8 ));
                nodesContact.add(new PointF(8,9 ));
                nodesContact.add(new PointF(9, 10));
                nodesContact.add(new PointF(10, 11));
                nodesContact.add(new PointF(11,10 ));
                nodesContact.add(new PointF(9, 12));
                nodesContact.add(new PointF(12,13 ));
                nodesContact.add(new PointF(13,14 ));
                nodesContact.add(new PointF(14,15 ));
                nodesContact.add(new PointF(15,14 ));
                nodesContact.add(new PointF(6,16 ));
                nodesContact.add(new PointF(16,17 ));
                nodesContact.add(new PointF(17,18 ));
                nodesContact.add(new PointF(18,19 ));
                nodesContact.add(new PointF(19,20 ));
                nodesContact.add(new PointF(20,21 ));
                nodesContact.add(new PointF(21,22 ));
                nodesContact.add(new PointF(22,23 ));
                nodesContact.add(new PointF(23,24 ));
                nodesContact.add(new PointF(24,25 ));
                nodesContact.add(new PointF(25,24 ));
                nodesContact.add(new PointF(9,26 ));
                nodesContact.add(new PointF(26,9 ));
                break;
            case "Q160":
                nodesContact.add(new PointF(0, 1));
                nodesContact.add(new PointF(1, 0));
                nodesContact.add(new PointF(1, 2));
                nodesContact.add(new PointF(2, 3));
                nodesContact.add(new PointF(3, 4));
                nodesContact.add(new PointF(4, 3));
                nodesContact.add(new PointF(3, 5));
                nodesContact.add(new PointF(5, 6));
                nodesContact.add(new PointF(6, 7));
                nodesContact.add(new PointF(7, 8));
                nodesContact.add(new PointF(8, 9));
                nodesContact.add(new PointF(9, 10));
                nodesContact.add(new PointF(10, 14));
                nodesContact.add(new PointF(14, 10));
                nodesContact.add(new PointF(10, 11));
                nodesContact.add(new PointF(11, 12));
                nodesContact.add(new PointF(12, 13));
                nodesContact.add(new PointF(13, 12));
                break;
        }
        return nodesContact;
    }
    public static List<PointF> marksCampus(String edificio) {
        List<PointF> marks = new ArrayList<>();
        switch(edificio) {
            case "Segreterie Studenti": marks.add(new PointF(316, 332));break;
            case "Blocco Aule Sud": marks.add(new PointF(376, 55));break;
            case "Scienze 1": marks.add(new PointF(130,119));break;
            case "Scienze 2": marks.add(new PointF(200,104));break;
            case "Scienze 3": marks.add(new PointF(273,84));break;
            case "Aula Magna Agraria": marks.add(new PointF(351,676));break;
            case "Laboratori Scienze": marks.add(new PointF(288,542));break;
            case "Fermata autobus / Ingresso Ovest": marks.add(new PointF(69,324));break;}
            return marks;}

    public static List<PointF> nodesCampus() {
        List<PointF> nodes = new ArrayList<>();
        nodes.add(new PointF(69,324));//Fermata autobus 0
        nodes.add(new PointF(135,311));//1
        nodes.add(new PointF(172,268));//2
        nodes.add(new PointF(261,268));//3
        nodes.add(new PointF(316,286));//4
        nodes.add(new PointF(438,354));//5
        nodes.add(new PointF(426,461));//6
        nodes.add(new PointF(279,491));//7
        nodes.add(new PointF(288,542));//Lab scienze 8
        nodes.add(new PointF(256,579));//9
        nodes.add(new PointF(122,589));//10
        nodes.add(new PointF(159,619));//11
        nodes.add(new PointF(338,610));//12
        nodes.add(new PointF(351,676));//aula magna agraria 13
        nodes.add(new PointF(316,704));//14
        nodes.add(new PointF(130,119));// scienze 1 15
        nodes.add(new PointF(200,104));// scienze 2 16
        nodes.add(new PointF(273,84));// scienze 3 17
        nodes.add(new PointF(376,55));// blocco aule sud 18
        nodes.add(new PointF(272,137));//19
        nodes.add(new PointF(295,233));//20
        nodes.add(new PointF(330,230));//21
        nodes.add(new PointF(308,378));//22
        nodes.add(new PointF(357,165));//23
        nodes.add(new PointF(344,146));// magazzino sperim ocean 24
        nodes.add(new PointF(385,189));// lab acquari 25
        nodes.add(new PointF(316,332));// segreteria 26
        return nodes;}

    public static List<PointF> nodescontactCampus() {
        List<PointF> nodescontact = new ArrayList<>();
        nodescontact.add(new PointF(0,1));
        nodescontact.add(new PointF(1,0));
        nodescontact.add(new PointF(1,2));
        nodescontact.add(new PointF(2,3));
        nodescontact.add(new PointF(3,4));
        nodescontact.add(new PointF(4,5));
        nodescontact.add(new PointF(5,6));
        nodescontact.add(new PointF(6,7));
        nodescontact.add(new PointF(7,8));
        nodescontact.add(new PointF(8,9));
        nodescontact.add(new PointF(9,10));
        nodescontact.add(new PointF(10,11));
        nodescontact.add(new PointF(11,12));
        nodescontact.add(new PointF(12,13));
        nodescontact.add(new PointF(13,14));
        nodescontact.add(new PointF(14,11));
        nodescontact.add(new PointF(2,15));
        nodescontact.add(new PointF(15,16));
        nodescontact.add(new PointF(16,17));
        nodescontact.add(new PointF(17,18));
        nodescontact.add(new PointF(17,19));
        nodescontact.add(new PointF(19,16));
        nodescontact.add(new PointF(19,20));
        nodescontact.add(new PointF(20,3));
        nodescontact.add(new PointF(3,20));
        nodescontact.add(new PointF(20,21));
        nodescontact.add(new PointF(21,22));
        nodescontact.add(new PointF(22,23));
        nodescontact.add(new PointF(23,24));
        nodescontact.add(new PointF(24,23));
        nodescontact.add(new PointF(23,25));
        nodescontact.add(new PointF(25,23));
        nodescontact.add(new PointF(4,26));
        nodescontact.add(new PointF(26,4));

        nodescontact.add(new PointF(23,22));
        nodescontact.add(new PointF(22,21));
        nodescontact.add(new PointF(21,20));
        nodescontact.add(new PointF(26,4));
        return nodescontact;}
}
