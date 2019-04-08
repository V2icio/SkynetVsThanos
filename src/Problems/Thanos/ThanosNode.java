package Problems.Thanos;

import Problems.Problema;

import java.util.ArrayList;

public class ThanosNode implements Problema {

    Char thanos, thanosFinal;
    ArrayList<Char> chars;
    int pesoMovimento;


    ThanosNode pai;

    public ThanosNode(){

        thanosFinal = new Char("ThanosFinal", 0, 0, null, 0);
    }

    public ArrayList<Problema> gerarSucessores() {
        return null;
    }

    @Override
    public boolean equals(Problema problema) {//este equals compara a vida do thanos

        ThanosNode thanosNode = (ThanosNode) problema;

        if(thanosNode.thanos.vida == this.thanos.vida)
            return true;

        return false;
    }

    public Problema getFinal() {

        ThanosNode thanosNode = new ThanosNode();
        thanosNode.thanos = thanosFinal;

        return thanosNode;
    }

    public Problema criaFilho() {
        return null;
    }

    public void printa() {}

    public Problema getPai() {

        return pai;
    }

    public Object[] base() {

        return null;
    }

    public Object[] alvo() {

        return null;
    }

    public int totalPossibilidades() {
        return 0;
    }

    public int pesoHeuristica() {

        int total = 0;

        total = total + (2 * pesoMovimento);

        for(Char c : chars){

            if(c.vida > 0)
                total += c.peso;
        }

        total = total - (thanos.vida / 100);

        return total;
    }

    public int tipo() {

        return 0;
    }

    public void geraInicial() {

        ArrayList<Char> todos = new ArrayList<>();

        ArrayList<Habilidade> habilidades0 = new ArrayList<>();
        habilidades0.add(new Habilidade("Raio com a Joia do Poder", 200, 12));
        habilidades0.add(new Habilidade("Raio com todas as Joias", 500, 50));
        habilidades0.add(new Habilidade("Golpe com a Espada do Infinito", 70, 5));

        Char char0 = new Char("Thanos", 2000, 30, habilidades0, 100);
        thanos = char0;


        ArrayList<Habilidade> habilidades1 = new ArrayList<>();
        habilidades1.add(new Habilidade("Flecha explosiva", 50, 8));
        habilidades1.add(new Habilidade("Flecha superexplosiva", 80, 20));

        todos.add(new Char("HawkEye", 90, 15, habilidades1, 35));


        todos.add(new Char("IronMan"));
        todos.add(new Char("CaptainAmerica"));
        todos.add(new Char("Hulk"));
        todos.add(new Char("Thor"));
        todos.add(new Char("BlackWidow"));
        todos.add(new Char("DrStrange"));
        todos.add(new Char("BlackPanther"));
        todos.add(new Char("SpiderMan"));
        todos.add(new Char("AntMan"));
        todos.add(new Char("WarMachine"));
        todos.add(new Char("Falcon"));
        todos.add(new Char("Vision"));
        todos.add(new Char("ScarletWitch"));
        todos.add(new Char("WinterSoldier"));
        todos.add(new Char("Loki"));
        todos.add(new Char("StarLord"));
        todos.add(new Char("Gamora"));
        todos.add(new Char("Drax"));
        todos.add(new Char("RocketRacoon"));
        todos.add(new Char("Groot"));
        todos.add(new Char("Nebula"));
        todos.add(new Char("Heimdall"));
        todos.add(new Char("Shuri"));
        todos.add(new Char("Okoye"));
        todos.add(new Char("MBaku"));
        todos.add(new Char("Wong"));

    }
}
