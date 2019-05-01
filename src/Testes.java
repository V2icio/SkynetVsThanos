import Problems.Problema;
import Problems.Thanos.Char;
import Problems.Thanos.ThanosNode;

import java.util.ArrayList;
import java.util.Stack;

public class Testes {

    public static void main(String[] args) {


        ArrayList<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");

        for(int x = 0; x < a.size(); x++){

            if(x == 0)
                a.remove(x);

            System.out.println(x);
        }



        /*jogoDosOitoNode.matriz[0][0] = 1;
        jogoDosOitoNode.matriz[0][1] = 2;
        jogoDosOitoNode.matriz[0][2] = 3;
        jogoDosOitoNode.matriz[1][0] = 4;
        jogoDosOitoNode.matriz[1][1] = 5;
        jogoDosOitoNode.matriz[1][2] = 6;
        jogoDosOitoNode.matriz[2][0] = 8;
        jogoDosOitoNode.matriz[2][1] = 0;
        jogoDosOitoNode.matriz[2][2] = 7;*/

        /*jogoDosOitoNode.matriz[0][0] = 1;
        jogoDosOitoNode.matriz[0][1] = 2;
        jogoDosOitoNode.matriz[0][2] = 3;
        jogoDosOitoNode.matriz[1][0] = 8;
        jogoDosOitoNode.matriz[1][1] = 0;
        jogoDosOitoNode.matriz[1][2] = 5;
        jogoDosOitoNode.matriz[2][0] = 7;
        jogoDosOitoNode.matriz[2][1] = 6;
        jogoDosOitoNode.matriz[2][2] = 4;*/

    }
}
