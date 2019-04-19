import Problems.Problema;
import Problems.Thanos.Char;
import Problems.Thanos.ThanosNode;

import java.util.ArrayList;
import java.util.Stack;

public class Testes {

    public static void main(String[] args) {

        ThanosNode thanosNode = new ThanosNode(null);
        thanosNode.geraInicial();

        ArrayList<Problema> filhos = thanosNode.gerarSucessores();



    }
}
