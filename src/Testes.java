import Problems.Problema;
import Problems.Thanos.Char;
import Problems.Thanos.ThanosNode;

import java.util.ArrayList;
import java.util.Stack;

public class Testes {

    public static void main(String[] args) {

        ThanosNode thanosNode = new ThanosNode(null);
        thanosNode.geraInicial();

        /*thanosNode.testaVida();

        ArrayList<Problema> filhos = thanosNode.gerarSucessores();*/

        Char perso = thanosNode.chars.get(0).copy();

        System.out.println(perso.vida);
        System.out.println(thanosNode.chars.get(0).vida);

        thanosNode.ataque(thanosNode.chars.get(0), perso);
        System.out.println(perso.vida);

    }
}
